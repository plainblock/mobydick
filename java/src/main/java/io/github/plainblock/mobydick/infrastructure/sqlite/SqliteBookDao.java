package io.github.plainblock.mobydick.infrastructure.sqlite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookId;
import io.github.plainblock.mobydick.domain.model.object.BookStatus;
import io.github.plainblock.mobydick.domain.model.object.ISBN;
import io.github.plainblock.mobydick.domain.repository.InternalRepository;
import io.github.plainblock.mobydick.infrastructure.sqlite.table.BookTable;

public class SqliteBookDao implements InternalRepository {

    @Override
    public List<Book> searchBooks(String keyword, BookStatus status) {
        EntityManager manager = SqliteClient.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<BookTable> query = builder.createQuery(BookTable.class);
        Root<BookTable> root = query.from(BookTable.class);
        query.select(root);
        List<Predicate> predicates = new ArrayList<>();
        if (keyword != null && !keyword.isBlank()) {
            predicates.add(builder.or(
                    builder.like(root.get("title"), "%" + keyword + "%"),
                    builder.like(root.get("author"), "%" + keyword + "%"),
                    builder.like(root.get("publisher"), "%" + keyword + "%")
            ));
        }
        if (status != null) {
            predicates.add(builder.equal(root.get("status"), status.code()));
        }
        if (predicates.size() > 0) {
            query.where(predicates.toArray(new Predicate[0]));
        }
        List<BookTable> list = manager.createQuery(query).getResultList();
        manager.close();
        return list.stream().map(BookTable::toEntity).toList();
    }

    @Override
    public List<Book> filterBooks(String title, String author, String publisher, ISBN isbn, BookStatus status) {
        EntityManager manager = SqliteClient.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<BookTable> query = builder.createQuery(BookTable.class);
        Root<BookTable> root = query.from(BookTable.class);
        query.select(root);
        List<Predicate> predicates = new ArrayList<>();
        if (title != null && !title.isBlank()) {
            predicates.add(builder.like(root.get("title"), "%" + title + "%"));
        }
        if (author != null && !author.isBlank()) {
            predicates.add(builder.like(root.get("author"), "%" + author + "%"));
        }
        if (publisher != null && !publisher.isBlank()) {
            predicates.add(builder.like(root.get("publisher"), "%" + publisher + "%"));
        }
        if (isbn != null) {
            predicates.add(builder.equal(root.get("isbn"), isbn.value()));
        }
        if (status != null) {
            predicates.add(builder.equal(root.get("status"), status.code()));
        }
        if (predicates.size() > 0) {
            query.where(predicates.toArray(new Predicate[0]));
        }
        List<BookTable> list = manager.createQuery(query).getResultList();
        manager.close();
        return list.stream().map(BookTable::toEntity).toList();
    }

    @Override
    public List<Book> getAllBooks() {
        EntityManager manager = SqliteClient.createEntityManager();
        CriteriaQuery<BookTable> query = manager.getCriteriaBuilder().createQuery(BookTable.class);
        Root<BookTable> root = query.from(BookTable.class);
        query.select(root);
        List<BookTable> list = manager.createQuery(query).getResultList();
        manager.close();
        return list.stream().map(BookTable::toEntity).toList();
    }

    @Override
    public Optional<Book> getBook(BookId id) {
        EntityManager manager = SqliteClient.createEntityManager();
        BookTable data = manager.find(BookTable.class, id.value());
        manager.close();
        if (data != null) {
            return Optional.of(data.toEntity());
        }
        return Optional.empty();
    }

    @Override
    public Book persist(Book book) {
        BookTable target = BookTable.fromEntity(book);
        EntityManager manager = SqliteClient.createEntityManager();
        manager.getTransaction().begin();
        BookTable data = manager.find(BookTable.class, book.getId().value());
        if (data != null) {
            manager.persist(manager.merge(target));
        } else {
            manager.persist(target);
        }
        manager.getTransaction().commit();
        manager.close();
        return book;
    }

    @Override
    public void truncate(Book book) {
        BookTable target = BookTable.fromEntity(book);
        EntityManager manager = SqliteClient.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(manager.contains(target) ? target : manager.merge(target));
        manager.getTransaction().commit();
        manager.close();
    }

}
