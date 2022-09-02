class Book {
  String id;
  String isbn;
  String title;
  String author;
  String publisher;
  String publishedDate;
  String information;

  Book(
    this.id,
    this.isbn,
    this.title,
    this.author,
    this.publisher,
    this.publishedDate,
    this.information,
  );

  toJson() => {
        'id': id,
        'isbn': isbn,
        'title': title,
        'author': author,
        'publisher': publisher,
        'published_date': publishedDate,
        'information': information,
      };
}
