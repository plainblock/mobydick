import {fetchBook, searchBooks} from "modules/google/client";
import {Book} from "modules/hooks/model";

test("searchBooksTest", async () => {
  const books = await searchBooks("Moby-Dick", "", "", 10, 1);
  expect(books).not.toBeNull()
  books.forEach((book: Book) => {
    viewConsole(book);
  })
})

test("fetchBookTest", async () => {
  const book = await fetchBook("9780810102699");
  expect(book.title).toBe("Moby-Dick, Or The Whale");
  expect(book.author).toBe("Herman Melville");
  expect(book.publisher).toBe("Northwestern University Press");
  expect(book.publishedDate).toBe("1988-09-09");
  expect(book.isbn).toBe("9780810102699");
  viewConsole(book);
})

function viewConsole(book: Book) {
  console.log("[title: " + book.title + ", author: " + book.author + ", publisher: " + book.publisher + ", publishedDate: " + book.publishedDate + ", ISBN: " + book.isbn + "]")
}
