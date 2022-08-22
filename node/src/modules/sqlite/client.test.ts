import { filterBooks, getAllBooks, getBook, persist, searchBooks, truncate } from "modules/sqlite/client";
import { Book, BookId, BookStatus, ISBN } from "modules/hooks/model";

test("searchBooks", async () => {
  const books = await searchBooks({ keyword: "Moby", status: new BookStatus(1) });
  books.forEach((book: Book) => {
    console.log(JSON.stringify(book));
  });
});

test("filterBooks", async () => {
  const books = await filterBooks({ title: "Moby-Dick", status: new BookStatus(2) });
  books.forEach((book: Book) => {
    console.log(JSON.stringify(book));
  });
});

test("getAllBooks", async () => {
  const books = await getAllBooks();
  books.forEach((book: Book) => {
    console.log(JSON.stringify(book));
  });
});

test("getBook", async () => {
  const book = await getBook(new BookId("bb6dc3ff-a38d-4cc9-9e2d-0f2bd97a3a65"));
  console.log(JSON.stringify(book));
});

test("persistTest", async () => {
  const target: Book = {
    id: new BookId("bb6dc3ff-a38d-4cc9-9e2d-0f2bd97a3a65"),
    isbn: new ISBN("9780810102699"),
    title: "Moby-Dick, Or The Whale",
    author: "Herman Melville",
    publisher: "Northwestern University Press",
    publishedDate: "1988-09-09",
    information: "",
    status: new BookStatus(2),
    registerAt: "2022-01-01",
    readAt: "2022-07-01",
  };
  const result: Book = await persist(target);
  console.log(JSON.stringify(result));
});

test("truncateTest", async () => {
  const target: Book = {
    id: new BookId("bb6dc3ff-a38d-4cc9-9e2d-0f2bd97a3a65"),
    isbn: new ISBN("9780810102699"),
    title: "Moby-Dick, Or The Whale",
    author: "Herman Melville",
    publisher: "Northwestern University Press",
    publishedDate: "1988-09-09",
    information: "",
    status: new BookStatus(2),
    registerAt: "2022-01-01",
    readAt: "2022-07-01",
  };
  await truncate(target);
});
