import { ReferenceForm, ReferenceTable } from "components/blocks/reference";
import { Book, BookId, BookStatus, ISBN } from "modules/hooks/model";

const example: Book[] = [
  {
    id: new BookId("example-01"),
    isbn: new ISBN(""),
    title: "白鯨　（上）",
    author: "メルヴィル",
    publisher: "KADOKAWA",
    publishedDate: "2015-06-20",
    information:
      "http://books.google.co.jp/books?id=D_DtCQAAQBAJ&printsec=frontcover&dq=intitle:%E7%99%BD%E9%AF%A8&hl=&cd=1&source=gbs_api|0|1660744367577",
    status: new BookStatus(0),
    registerAt: "2022-08-01",
    readAt: "",
  },
  {
    id: new BookId("example-02"),
    isbn: new ISBN(""),
    title: "白鯨　（下）",
    author: "メルヴィル",
    publisher: "KADOKAWA",
    publishedDate: "2015-06-20",
    information:
      "http://books.google.co.jp/books?id=NPDtCQAAQBAJ&printsec=frontcover&dq=intitle:%E7%99%BD%E9%AF%A8&hl=&cd=4&source=gbs_api|0|1660744369609",
    status: new BookStatus(0),
    registerAt: "2022-08-01",
    readAt: "",
  },
];

function ReferenceView(): JSX.Element {
  return (
    <div className="reference">
      <ReferenceForm />
      <ReferenceTable books={example} />
    </div>
  );
}

export default ReferenceView;
