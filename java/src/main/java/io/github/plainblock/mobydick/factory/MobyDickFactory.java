package io.github.plainblock.mobydick.factory;

import io.github.plainblock.mobydick.domain.repository.ExternalRepository;
import io.github.plainblock.mobydick.domain.repository.InternalRepository;
import io.github.plainblock.mobydick.infrastructure.google.GoogleBookApi;
import io.github.plainblock.mobydick.infrastructure.sqlite.SqliteBookDao;
import io.github.plainblock.mobydick.service.ManagementService;
import io.github.plainblock.mobydick.service.ReferenceService;

public class MobyDickFactory {

    public static ReferenceService getReferenceService() {
        return new ReferenceService(getExternalRepository());
    }

    public static ManagementService getManagementService() {
        return new ManagementService(getInternalRepository());
    }

    private static ExternalRepository getExternalRepository() {
        return new GoogleBookApi();
    }

    private static InternalRepository getInternalRepository() {
        return new SqliteBookDao();
    }

}
