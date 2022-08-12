module mobydick {
    requires java.desktop;
    requires java.persistence;
    requires java.sql;
    requires java.xml.bind;

    requires com.fasterxml.classmate;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires net.bytebuddy;
    requires org.slf4j;
    requires org.hibernate.orm.core;

    opens io.github.plainblock.mobydick.infrastructure.google.json to com.fasterxml.jackson.databind;
    opens io.github.plainblock.mobydick.infrastructure.sqlite.table;

    exports io.github.plainblock.mobydick;
    exports io.github.plainblock.mobydick.presentation.controller;
}