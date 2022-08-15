
sqlite3 -batch -init initdb.sql mobydick.db
gradlew.bat shadowJar
move build\libs\*all.jar mobydick.jar
