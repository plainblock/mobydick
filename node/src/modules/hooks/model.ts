export interface Book {
  id: string;
  isbn: string;
  title: string;
  author: string;
  publisher: string;
  publishedDate: string;
  information: string;
  status: string;
  registerAt: string;
  readAt: string;
}

export interface BookStatus {
  code: number,
  label: string,
}