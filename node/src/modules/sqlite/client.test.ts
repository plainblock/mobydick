import {filterBooks, getAllBooks, searchBooks} from "modules/sqlite/client";
import {Book, BookStatus} from "modules/hooks/model";

test("searchBooks", async () => {
  const books = await searchBooks({keyword: "Moby"});
  books.forEach((book: Book) => {
    viewConsole(book);
  })
})

test("filterBooks", async () => {
  const books = await filterBooks({title: "Moby-Dick", status: new BookStatus(2)});
  books.forEach((book: Book) => {
    viewConsole(book);
  })
})

test("getAllBooks", async () => {
  const books = await getAllBooks();
  books.forEach((book: Book) => {
    viewConsole(book);
  })
})

function viewConsole(book: Book) {
  console.log(JSON.stringify(book))
}