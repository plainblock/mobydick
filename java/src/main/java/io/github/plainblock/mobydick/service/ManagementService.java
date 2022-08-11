package io.github.plainblock.mobydick.service;

import io.github.plainblock.mobydick.domain.repository.InternalRepository;

public class ManagementService {

    private final InternalRepository internal;

    public ManagementService(InternalRepository internal) {
        this.internal = internal;
    }

}
