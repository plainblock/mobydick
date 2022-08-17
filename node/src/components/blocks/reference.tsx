import classNames from "classnames";
import {useEffect, useMemo, useState} from "react";
import {Cell, Column, HeaderGroup, Row, useSortBy, useTable} from "react-table";

import {Identifier, TableClass} from "components/constants/html";
import {Book} from "modules/hooks/model";

export function ReferenceForm() {

}

class ReferenceTableData {
  index: number;
  title: string;
  author: string;
  publisher: string;
  publishedDate: string;
  isbn: string;

  constructor(index: number, book: Book) {
    this.index = index;
    this.title = book.title;
    this.author = book.author;
    this.publisher = book.publisher;
    this.publishedDate = book.publishedDate;
    this.isbn = book.isbn.value;
  }
}

const referenceTableColumns: Column<ReferenceTableData>[] = [
  {Header: Identifier.title.label, accessor: "title"},
  {Header: Identifier.author.label, accessor: "author"},
  {Header: Identifier.publisher.label, accessor: "publisher"},
  {Header: Identifier.publishedDate.label, accessor: "publishedDate"},
  {Header: Identifier.isbn.label, accessor: "isbn"},
]

export function ReferenceTable(props: { books: Book[] }): JSX.Element {
  const {books} = props;
  const columns: Column<ReferenceTableData>[] = useMemo(() => referenceTableColumns, []);
  const data: ReferenceTableData[] = useMemo(
    () => books.map((book: Book, index: number) => new ReferenceTableData(index, book)),
    [books]
  );
  const {getTableProps, getTableBodyProps, headerGroups, rows, prepareRow} = useTable<ReferenceTableData>(
    {columns, data},
    useSortBy
  );

  const [selected, setSelected] = useState<ReferenceTableData>()

  useEffect(() => {
    setSelected(selected)
  }, [selected])

  return (
    <>
      <table className={classNames(TableClass.base)} {...getTableProps()}>
        <thead>
        {headerGroups.map((headerGroup: HeaderGroup<ReferenceTableData>) => (
          <tr {...headerGroup.getHeaderGroupProps()}>
            {headerGroup.headers.map((column: HeaderGroup<ReferenceTableData>) => (
              <th {...column.getHeaderProps(column.getSortByToggleProps())}>
                {column.render("Header")}
                <span>{column.isSorted ? (column.isSortedDesc ? " 🔽" : " 🔼") : ""}</span>
              </th>
            ))}
          </tr>
        ))}
        </thead>
        <tbody {...getTableBodyProps()}>
        {rows.map((row: Row<ReferenceTableData>) => {
          prepareRow(row);
          return (
            <tr {...row.getRowProps()} onClick={() => setSelected(row.original)}>
              {row.cells.map((cell: Cell<ReferenceTableData>) => (
                <td {...cell.getCellProps()}>{cell.render("Cell")}</td>
              ))}
            </tr>
          );
        })}
        </tbody>
      </table>
      <p>{selected?.title}</p>
    </>
  );
}
