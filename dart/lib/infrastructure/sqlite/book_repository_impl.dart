import 'package:dart/domain/model/book.dart';
import 'package:dart/domain/repository/book_repository.dart';
import 'package:sqflite/sqflite.dart';

import 'client.dart';

class BookTable {
  String id;
  String isbn;
  String title;
  String author;
  String publisher;
  String publishedDate;
  String information;

  BookTable(
    this.id,
    this.isbn,
    this.title,
    this.author,
    this.publisher,
    this.publishedDate,
    this.information,
  );
}

class BookRepositoryImpl extends SqliteClient implements BookRepository {
  @override
  Future<List<Book>> getAllBooks() async {
    final Database db = await getConnection();
    final List<Map<String, dynamic>> maps = await db.query('books');
    await db.close();
    return List.generate(maps.length, (index) {
      return _toEntity(maps[index]);
    });
  }
}

_toEntity(Map<String, dynamic> map) => Book(
      map['id'] ?? "",
      map['isbn'] ?? "",
      map['title'] ?? "",
      map['author'] ?? "",
      map['publisher'] ?? "",
      map['published_date'] ?? "",
      map['information'] ?? "",
    );

_fromEntity(Book book) => BookTable(book.id, book.isbn, book.title, book.author,
    book.publisher, book.publishedDate, book.information);
