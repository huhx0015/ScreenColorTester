package com.huhx0015.screencolortester.presentation.ui.view;

/**
 * This interface represents a basic view. All views should implement these common methods.
 *
 * Reference: https://medium.com/@dmilicic/a-detailed-guide-on-developing-android-apps-using-the-clean-architecture-pattern-d38d71e94029
 */
public interface BaseView {

    /**
     * This is a general method used for showing some kind of progress during a background task. For example, this
     * method should show a progress bar and/or disable buttons before some background work starts.
     */
    void showProgress();

    /**
     * This is a general method used for hiding progress information after a background task finishes.
     */
    void hideProgress();

    /**
     * This method is used for showing error messages on the UI.
     *
     * @param message The error message to be displayed.
     */
    void showError(String message);
}

