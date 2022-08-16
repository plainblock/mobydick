import { v4 } from "uuid";

export interface Book {
  id: BookId;
  isbn: ISBN;
  title: string;
  author: string;
  publisher: string;
  publishedDate: string;
  information: string;
  status: BookStatus;
  registerAt: string;
  readAt: string;
}

export class BookId {
  value: string;

  constructor(value: string) {
    if (value) {
      this.value = value;
    } else {
      this.value = v4();
    }
  }
}

export class BookStatus {
  code: number;
  label: string;

  constructor(code: number) {
    this.code = code;
    this.label = toStatusLabel(code);
  }
}

function toStatusLabel(code: number): string {
  switch (code) {
    case 0:
      return "未購入";
    case 1:
      return "積読";
    case 2:
      return "既読";
    default:
      return "不明";
  }
}

export class ISBN {
  value: string;

  constructor(value: string) {
    if (value) {
      this.value = value.trim().replaceAll("-", "")
    } else {
      this.value = ""
    }
  }
}