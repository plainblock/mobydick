package io.github.plainblock.mobydick.service;

import io.github.plainblock.mobydick.domain.model.entity.Book;
import io.github.plainblock.mobydick.domain.model.object.BookId;
import io.github.plainblock.mobydick.domain.repository.InternalRepository;

public class ManagementService {

    private final InternalRepository internal;

    public ManagementService(InternalRepository internal) {
        this.internal = internal;
    }

    public Book findById(String id) {
        return internal.getBook(new BookId(id)).orElseThrow();
    }

}
