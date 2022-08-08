import 'dart:convert';

import 'package:http/http.dart' as http;

const appId = "4fd6d8610392d07f3ec0381c25760d35d4ef83a6";

Future<Object> getStatsList() async {
  var response = await http.get(Uri.https(
      'api.e-stat.go.jp',
      '/rest/3.0/app/json/getStatsList',
      {'appId': appId, 'limit': '10', 'surveyYears': '2020'}));

  var json = jsonDecode(response.body);
  return json;
}
