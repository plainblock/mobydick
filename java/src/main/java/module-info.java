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
    exports io.github.plainblock.mobydick.service;
    exports io.github.plainblock.mobydick.domain.model.entity;
    exports io.github.plainblock.mobydick.domain.model.object;
    exports io.github.plainblock.mobydick.domain.repository;
    exports io.github.plainblock.mobydick.presentation.component.atom;
    exports io.github.plainblock.mobydick.presentation.component.block;
    exports io.github.plainblock.mobydick.presentation.controller;
    exports io.github.plainblock.mobydick.presentation.view;
}