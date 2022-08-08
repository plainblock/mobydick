import 'package:dart/data.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  test('Get stats list test', () async {
    var data = await getStatsList();
    if (kDebugMode) {
      print(data);
    }
  });
}