import { GoogleBookApi } from "modules/google/client";
import { Book, ISBN } from "modules/hooks/model";

const client = new GoogleBookApi();

test("searchBooksTest", async () => {
  const books = await client.searchBooks({ title: "Moby-Dick" }, 10, 1);
  expect(books).not.toBeNull()
  books.forEach((book: Book) => {
    console.log(JSON.stringify(book));
  });
});

test("fetchBookTest", async () => {
  const book = await client.fetchBook(new ISBN("9780810102699"));
  expect(book.title).toBe("Moby-Dick, Or The Whale");
  expect(book.author).toBe("Herman Melville");
  expect(book.publisher).toBe("Northwestern University Press");
  expect(book.publishedDate).toBe("1988-09-09");
  expect(book.isbn.value).toBe("9780810102699");
  console.log(JSON.stringify(book));
});
