class Book {
  String id;
  String isbn;
  String title;
  String author;
  String publisher;
  String publishedDate;
  String information;
  int status;
  String registerAt;
  String readAt;

  Book(
    this.id,
    this.isbn,
    this.title,
    this.author,
    this.publisher,
    this.publishedDate,
    this.information,
    this.status,
    this.registerAt,
    this.readAt,
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
