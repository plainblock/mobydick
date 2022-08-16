import axios from "axios";

import {GoogleBook, GoogleBookItem, toBook} from "modules/google/model";
import {Book, ISBN} from "modules/hooks/model";

const endpoint = "https://www.googleapis.com/books/v1/volumes";
const client = axios.create({
  responseType: "json",
  headers: {
    "Content-Type": "application/json",
  },
})

interface Query {
  keyword: string,
  title: string,
  author: string,
  publisher: string,
  subject: string,
  isbn: string,
  lccn: string,
  oclc: string,
  number: number,
  index: number,
}

export async function searchBooks(title: string, author: string, publisher: string, number: number, page: number): Promise<Book[]> {
  if (page < 1) {
    return Promise.reject();
  }
  const index = (page - 1) * number;
  const query: Query = {
    keyword: "",
    title: title,
    author: author,
    publisher: publisher,
    subject: "",
    isbn: "",
    lccn: "",
    oclc: "",
    number: number,
    index: index,
  }
  const response = await client.get(endpoint + toParam(query));
  if (response.status === 200) {
    const data: GoogleBook = response.data as GoogleBook;
    const books: Book[] = [];
    if (data.items) {
      data.items.forEach((item: GoogleBookItem) => {
        books.push(toBook(item));
      })
    }
    return Promise.resolve(books)
  }
  return Promise.reject();
}

export async function fetchBook(isbn: ISBN): Promise<Book> {
  if (!isbn || !isbn.value) {
    return Promise.reject();
  }
  const query: Query = {
    keyword: "",
    title: "",
    author: "",
    publisher: "",
    subject: "",
    isbn: isbn.value,
    lccn: "",
    oclc: "",
    number: 0,
    index: 0,
  }
  const response = await client.get(endpoint + toParam(query));
  if (response.status === 200) {
    const data: GoogleBook = response.data as GoogleBook;
    if (data.items) {
      const item: GoogleBookItem = response.data.items[0] as GoogleBookItem;
      return Promise.resolve(toBook(item));
    }
  }
  return Promise.reject();
}

function toParam(query: Query): string {
  let param: string = "?q="
  let requirePlusMarker: boolean = false;
  if (query.keyword) {
    param += encodeURI(query.keyword);
    requirePlusMarker = true;
  }
  if (query.title) {
    param += appendParam("intitle", query.title, requirePlusMarker);
    requirePlusMarker = true;
  }
  if (query.author) {
    param += appendParam("inauthor", query.author, requirePlusMarker);
    requirePlusMarker = true;
  }
  if (query.publisher) {
    param += appendParam("inpublisher", query.publisher, requirePlusMarker);
    requirePlusMarker = true;
  }
  if (query.subject) {
    param += appendParam("subject", query.subject, requirePlusMarker);
    requirePlusMarker = true;
  }
  if (query.isbn) {
    param += appendParam("isbn", query.isbn, requirePlusMarker);
    requirePlusMarker = true;
  }
  if (query.lccn) {
    param += appendParam("lccn", query.lccn, requirePlusMarker);
    requirePlusMarker = true;
  }
  if (query.oclc) {
    param += appendParam("oclc", query.oclc, requirePlusMarker);
  }
  if (query.number !== 0) {
    param += `&maxResults=${query.number}`
  }
  if (query.index !== 0) {
    param += `&startIndex=${query.index}`
  }
  return param;
}

function appendParam(key: string, value: string, plusMarker: boolean): string {
  if (plusMarker) {
    return "+" + key + ":" + encodeURI(value);
  }
  return key + ":" + encodeURI(value);
}