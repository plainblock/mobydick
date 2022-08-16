import { DataTypes, Model, Op, Sequelize, WhereOptions } from "sequelize";

import { Book, BookId, BookStatus, ISBN } from "modules/hooks/model";

const client = new Sequelize({
  dialect: 'sqlite',
  storage: 'mobydick.db',
  logging: (...msg) => console.log(msg),
})

class BookTable extends Model {
  toBook(): Book {
    return {
      id: this.getDataValue("id"),
      isbn: this.getDataValue("isbn"),
      title: this.getDataValue("title"),
      author: this.getDataValue("author"),
      publisher: this.getDataValue("publisher"),
      publishedDate: this.getDataValue("published_date"),
      information: this.getDataValue("information"),
      status: this.getDataValue("status"),
      registerAt: this.getDataValue("register_at"),
      readAt: this.getDataValue("read_at"),
    }
  }
}

BookTable.init({
  id: {
    type: DataTypes.STRING,
    allowNull: false,
    primaryKey: true,
    get() {
      new BookId(this.getDataValue("id"))
    }
  },
  isbn: {
    type: DataTypes.STRING,
    get() {
      new ISBN(this.getDataValue("isbn"))
    }
  },
  title: { type: DataTypes.STRING, allowNull: false },
  author: { type: DataTypes.STRING },
  publisher: { type: DataTypes.STRING, },
  published_date: { type: DataTypes.STRING },
  information: { type: DataTypes.STRING },
  status: {
    type: DataTypes.INTEGER,
    get() {
      new BookStatus(this.getDataValue("status"));
    }
  },
  register_at: { type: DataTypes.DATE },
  read_at: { type: DataTypes.DATE },
}, {
  sequelize: client,
  tableName: "books",
  freezeTableName: true,
  timestamps: false,
});

export async function searchBooks(condition: { keyword?: string, status?: BookStatus }): Promise<Book[]> {
  const { keyword, status } = condition;
  const options: WhereOptions[] = [];
  if (keyword) {
    options.push({
      [Op.or]: [
        { title: { [Op.like]: "%" + keyword + "%" } },
        { author: { [Op.like]: "%" + keyword + "%" } },
        { publisher: { [Op.like]: "%" + keyword + "%" } },
      ]
    })
  }
  if (status) {
    options.push({
      status: { [Op.eq]: status.code },
    })
  }
  const data = await BookTable.findAll({ where: { [Op.and]: options } });
  const books: Book[] = [];
  if (data) {
    data.forEach((value: BookTable) => {
      books.push(value.toBook())
    })
  }
  return Promise.resolve(books)

}

export async function filterBooks(condition: { title?: string, author?: string, publisher?: string, isbn?: ISBN, status?: BookStatus }): Promise<Book[]> {
  const { title, author, publisher, isbn, status } = condition;
  const books: Book[] = [];
  const options: WhereOptions[] = [];
  if (title) options.push({ title: { [Op.like]: "%" + title + "%" } });
  if (author) options.push({ author: { [Op.like]: "%" + author + "%" } });
  if (publisher) options.push({ publisher: { [Op.like]: "%" + publisher + "%" } });
  if (isbn) options.push({ isbn: { [Op.like]: "%" + isbn.value + "%" } });
  if (status) options.push({ status: { [Op.eq]: status.code } });
  const data = await BookTable.findAll({ where: { [Op.and]: options } })
  if (data) {
    data.forEach((value: BookTable) => {
      books.push(value.toBook())
    })
  }
  return Promise.resolve(books)
}

export async function getAllBooks(): Promise<Book[]> {
  const books: Book[] = [];
  const data = await BookTable.findAll();
  if (data) {
    data.forEach((value: BookTable) => {
      books.push(value.toBook())
    })
  }
  return Promise.resolve(books)
}

export async function getBook(id: BookId): Promise<Book> {
  const data = await BookTable.findByPk(id.value)
  if (data !== null) {
    return Promise.resolve((data as BookTable).toBook());
  }
  return Promise.reject();
}

export async function persist(book: Book): Promise<Book> {
  const target = await BookTable.findByPk(book.id.value)
  if (target === null) {
    const result: BookTable = await BookTable.create({
      id: book.id.value,
      isbn: book.isbn.value,
      title: book.title,
      author: book.author,
      publisher: book.publisher,
      published_date: book.publishedDate,
      information: book.information,
      status: book.status.code,
      register_at: book.registerAt,
      read_at: book.readAt,
    })
    return Promise.resolve(result.toBook())
  } else {
    await BookTable.update({
      isbn: book.isbn.value,
      title: book.title,
      author: book.author,
      publisher: book.publisher,
      published_date: book.publishedDate,
      information: book.information,
      status: book.status.code,
      register_at: book.registerAt,
      read_at: book.readAt,
    }, {
      where: {
        id: book.id.value,
      }
    })
    return Promise.resolve(book)
  }
}

export async function truncate(book: Book) {
  await BookTable.destroy({
    where: {
      id: book.id.value
    }
  })
}