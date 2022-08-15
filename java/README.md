# MobyDick Java edition

MobyDick application implemented by Java

## Enviroment

- Java 17.0.2
- SQLite 3.39.2

## Getting start

### Windows

1. Initialize mobydick database.
```
> sqlite3 -init initdb.sql mobydick.db
```

2. Exit from database.
```
sqlite> .exit
```

3. Build mobydick application.
```
> gradlew.bat shadowJar
> move build\libs\*all.jar mobydick.jar
```

4. Execute mobydick application.
```
> java -jar mobydick.jar
```

### Linux

1. Initialize mobydick database.
```
$ sqlite3 -init initdb.sql mobydick.db
```

2. Exit from database.
```
sqlite> .exit
```

3. Build mobydick application.
```
$ ./gradlew shadowJar
$ mv ./build/libs/*all.jar mobydick.jar
```

4. Execute mobydick application.
```
$ java -jar mobydick.jar
```
