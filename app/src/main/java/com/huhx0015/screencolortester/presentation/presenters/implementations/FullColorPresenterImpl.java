package com.huhx0015.screencolortester.presentation.presenters.implementations;

import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.domain.repositories.implementations.FullColorRepositoryImpl;
import com.huhx0015.screencolortester.presentation.presenters.FullColorPresenter;
import com.huhx0015.screencolortester.presentation.ui.view.FullColorView;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public class FullColorPresenterImpl implements FullColorPresenter {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // PRESENTER VARIABLES:
    private FullColorView mView;
    private FullColorRepositoryImpl mRepository;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public FullColorPresenterImpl(FullColorView view) {
        this.mView = view;
        this.mRepository = new FullColorRepositoryImpl();
    }

    /** PRESENTER METHODS ______________________________________________________________________ **/

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void stop() {}

    @Override
    public void destroy() {
        mRepository.clearColorList();
        mRepository = null;
    }

    @Override
    public void onError(String message) {}

    @Override
    public FullColorRepositoryImpl getRepository() {
        return mRepository;
    }

    @Override
    public void setColorBackground(ScreenColor color, boolean isInitial) {
        mRepository.setColor(color);
        mView.showBackgroundColor(color);

        // Only displays the snackbar on initial load.
        if (isInitial) {
            mView.showSnackbar(color);
        }
    }

    @Override
    public void setBrightness() {
        mView.showBrightness();
    }
}
