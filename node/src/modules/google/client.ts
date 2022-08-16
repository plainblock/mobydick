import axios, { AxiosInstance } from "axios";

import { GoogleBook, GoogleBookItem, toBook } from "modules/google/model";
import { Book, ISBN } from "modules/hooks/model";

export class GoogleBookApi {
  endpoint: string = "https://www.googleapis.com/books/v1/volumes";
  client: AxiosInstance;

  constructor() {
    this.client = axios.create({
      responseType: "json",
      headers: {
        "Content-Type": "application/json",
      }
    })
  };

  async searchBooks(condition: { title?: string, author?: string, publisher?: string }, number: number, page: number): Promise<Book[]> {
    const { title, author, publisher } = condition;
    if (number < 1) number = 10;
    if (page < 1) page = 1;
    const index = (page - 1) * number;
    const query: Query = new Query({ title, author, publisher, number, index });
    const response = await this.client.get(this.endpoint + query.toParam());
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

  async fetchBook(isbn: ISBN): Promise<Book> {
    if (!isbn || !isbn.value) {
      return Promise.reject();
    }
    const query: Query = new Query({ isbn: isbn.value });
    const response = await this.client.get(this.endpoint + query.toParam());
    if (response.status === 200) {
      const data: GoogleBook = response.data as GoogleBook;
      if (data.items) {
        const item: GoogleBookItem = response.data.items[0] as GoogleBookItem;
        return Promise.resolve(toBook(item));
      }
    }
    return Promise.reject();
  }
}

class Query {
  keyword: string;
  title: string;
  author: string;
  publisher: string;
  subject: string;
  isbn: string;
  lccn: string;
  oclc: string;
  number: number;
  index: number;

  constructor(query: { keyword?: string, title?: string, author?: string, publisher?: string, subject?: string, isbn?: string, lccn?: string, oclc?: string, number?: number, index?: number }) {
    this.keyword = query.keyword ? query.keyword : "";
    this.title = query.title ? query.title : "";
    this.author = query.author ? query.author : "";
    this.publisher = query.publisher ? query.publisher : "";
    this.subject = query.subject ? query.subject : "";
    this.isbn = query.isbn ? query.isbn : "";
    this.lccn = query.lccn ? query.lccn : "";
    this.oclc = query.oclc ? query.oclc : "";
    this.number = query.number ? query.number : 0;
    this.index = query.index ? query.index : 0;
  }

  toParam(): string {
    let param: string = "?q="
    let requirePlusMarker: boolean = false;
    if (this.keyword) {
      param += encodeURI(this.keyword);
      requirePlusMarker = true;
    }
    if (this.title) {
      param += this.appendParam("intitle", this.title, requirePlusMarker);
      requirePlusMarker = true;
    }
    if (this.author) {
      param += this.appendParam("inauthor", this.author, requirePlusMarker);
      requirePlusMarker = true;
    }
    if (this.publisher) {
      param += this.appendParam("inpublisher", this.publisher, requirePlusMarker);
      requirePlusMarker = true;
    }
    if (this.subject) {
      param += this.appendParam("subject", this.subject, requirePlusMarker);
      requirePlusMarker = true;
    }
    if (this.isbn) {
      param += this.appendParam("isbn", this.isbn, requirePlusMarker);
      requirePlusMarker = true;
    }
    if (this.lccn) {
      param += this.appendParam("lccn", this.lccn, requirePlusMarker);
      requirePlusMarker = true;
    }
    if (this.oclc) {
      param += this.appendParam("oclc", this.oclc, requirePlusMarker);
    }
    if (this.number !== 0) {
      param += `&maxResults=${this.number}`
    }
    if (this.index !== 0) {
      param += `&startIndex=${this.index}`
    }
    return param;
  }

  appendParam(key: string, value: string, plusMarker: boolean): string {
    if (plusMarker) {
      return "+" + key + ":" + encodeURI(value);
    }
    return key + ":" + encodeURI(value);
  }
}
