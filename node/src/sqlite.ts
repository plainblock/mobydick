import sqlite3 from "sqlite3";

export function getData() {
  const db = new sqlite3.Database('mobydick.db')
  db.serialize(() => {
    db.each("SELECT * FROM books", (err, row) => {
      console.log(row.id);
    })
  })
  db.close()
}