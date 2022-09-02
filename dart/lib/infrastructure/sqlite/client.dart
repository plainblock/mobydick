import 'dart:io';

import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';
import 'package:sqflite_common_ffi/sqflite_ffi.dart';

const String _database = 'mobydick.db';

class SqliteClient {
  Future<Database> getConnection() async {
    if (Platform.isAndroid || Platform.isIOS) {
      return openDatabase(
        join(await getDatabasesPath(), _database),
      );
    } else {
      sqfliteFfiInit();
      databaseFactory = databaseFactoryFfi;
      return openDatabase(
        join(Directory.current.path, _database),
      );
    }
  }
}
