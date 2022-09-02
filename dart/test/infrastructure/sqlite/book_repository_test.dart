import 'dart:convert';

import 'package:dart/infrastructure/sqlite/book_repository_impl.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:sqflite/sqflite.dart';
import 'package:sqflite_common_ffi/sqflite_ffi.dart';

final bookRepository = BookRepositoryImpl();

void main() {
  setUpAll(() async {
    sqfliteFfiInit();
    databaseFactory = databaseFactoryFfi;
  });
  test('get books test', () async {
    var books = await bookRepository.getAllBooks();
    if (kDebugMode) {
      for (var book in books) {
        print(jsonEncode(book));
      }
    }
  });
}
