package io.github.plainblock.mobydick.infrastructure.sqlite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SqliteClient {

    private static final String PERSISTENCE_UNIT_NAME = "mobydick";
    private static EntityManagerFactory factory;

    public static EntityManager createEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

}
