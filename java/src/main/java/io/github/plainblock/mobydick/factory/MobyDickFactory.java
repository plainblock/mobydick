package io.github.plainblock.mobydick.factory;

import io.github.plainblock.mobydick.presentation.controller.MobyDickController;
import io.github.plainblock.mobydick.domain.repository.ExternalRepository;
import io.github.plainblock.mobydick.domain.repository.InternalRepository;
import io.github.plainblock.mobydick.infrastructure.google.GoogleBookApi;
import io.github.plainblock.mobydick.infrastructure.sqlite.SqliteBookDao;
import io.github.plainblock.mobydick.presentation.view.MobyDickView;
import io.github.plainblock.mobydick.service.ManagementService;
import io.github.plainblock.mobydick.service.ReferenceService;

public class MobyDickFactory {

    public static MobyDickView getMobyDickView() {
        return new MobyDickView();
    }

    public static MobyDickController getMobyDickController() {
        return new MobyDickController(getReferenceService(), getManagementService());
    }

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
