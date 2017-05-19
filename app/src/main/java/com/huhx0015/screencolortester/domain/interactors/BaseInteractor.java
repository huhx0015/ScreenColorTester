package com.huhx0015.screencolortester.domain.interactors;

/**
 * This is the main interface of an interactor. Each interactor serves a specific use case.
 *
 * Reference: https://medium.com/@dmilicic/a-detailed-guide-on-developing-android-apps-using-the-clean-architecture-pattern-d38d71e94029
 */
public interface BaseInteractor {

    /**
     * This is the main method that starts an interactor. It will make sure that the interactor operation is done on a
     * background thread.
     */
    void execute();
}
