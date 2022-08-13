package io.github.plainblock.mobydick.factory;

import io.github.plainblock.mobydick.presentation.controller.ManagementController;
import io.github.plainblock.mobydick.domain.repository.ExternalRepository;
import io.github.plainblock.mobydick.domain.repository.InternalRepository;
import io.github.plainblock.mobydick.infrastructure.google.GoogleBookApi;
import io.github.plainblock.mobydick.infrastructure.sqlite.SqliteBookDao;
import io.github.plainblock.mobydick.presentation.controller.ReferenceController;
import io.github.plainblock.mobydick.presentation.view.ManagementView;
import io.github.plainblock.mobydick.presentation.view.ReferenceView;
import io.github.plainblock.mobydick.service.ManagementService;
import io.github.plainblock.mobydick.service.ReferenceService;

public class MobyDickFactory {

    public static ReferenceController getReferenceController() {
        return new ReferenceController(getReferenceService(), getManagementService(), getReferenceView());
    }

    public static ManagementController getManagementController() {
        return new ManagementController(getManagementService(), getManagementView());
    }

    private static ReferenceView getReferenceView() {
        return new ReferenceView();
    }

    private static ManagementView getManagementView() {
        return new ManagementView();
    }

    private static ReferenceService getReferenceService() {
        return new ReferenceService(getExternalRepository());
    }

    private static ManagementService getManagementService() {
        return new ManagementService(getInternalRepository());
    }

    private static ExternalRepository getExternalRepository() {
        return new GoogleBookApi();
    }

    private static InternalRepository getInternalRepository() {
        return new SqliteBookDao();
    }

}
