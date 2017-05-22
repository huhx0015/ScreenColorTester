package com.huhx0015.screencolortester.presentation.presenters.implementations;

import android.content.Context;
import com.huhx0015.screencolortester.R;
import com.huhx0015.screencolortester.domain.interactors.FullColorInteractor;
import com.huhx0015.screencolortester.domain.interactors.implementations.FullColorInteractorImpl;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.domain.repositories.implementations.FullColorRepositoryImpl;
import com.huhx0015.screencolortester.presentation.presenters.FullColorPresenter;
import com.huhx0015.screencolortester.presentation.ui.view.FullColorView;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public class FullColorPresenterImpl implements FullColorPresenter, FullColorInteractor.Callback {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // CONTEXT VARIABLES:
    private Context mContext;

    // PRESENTER VARIABLES:
    private FullColorView mView;
    private FullColorRepositoryImpl mRepository;
    private FullColorInteractorImpl mInteractor;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public FullColorPresenterImpl(FullColorView view, Context context) {
        this.mView = view;
        this.mContext = context;
        this.mRepository = new FullColorRepositoryImpl();
        this.mInteractor = new FullColorInteractorImpl(this);
    }

    /** PRESENTER METHODS ______________________________________________________________________ **/

    @Override
    public void resume() {
        if (mRepository.getTestMode()) {
            mInteractor.start();
        }
    }

    @Override
    public void pause() {
        if (mRepository.getTestMode()) {
            mRepository.setTestPosition(mInteractor.getTestPosition());
            mInteractor.stop();
        }
    }

    @Override
    public void stop() {}

    @Override
    public void destroy() {
        mContext = null;
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
    public FullColorInteractorImpl getInteractor() {
        return mInteractor;
    }

    @Override
    public void setColorBackground(ScreenColor color, boolean displaySnackbar) {
        mRepository.setColor(color);
        mView.showBackgroundColor(color);

        if (displaySnackbar) {
            mView.showSnackbar(color,
                    String.format(mContext.getString(R.string.snackbar_showing_full_color),
                    color.name.toUpperCase()));
        }
    }

    @Override
    public void setBrightness() {
        mView.showBrightness();
    }

    @Override
    public void startTest(int position) {
        mRepository.setTestPosition(position);
        mInteractor.setTestPosition(position);
        mInteractor.start();
    }

    /** CALLBACK METHODS _______________________________________________________________________ **/

    @Override
    public void onScreenColorChange(int position) {
        mRepository.setTestPosition(position);
        ScreenColor color = mRepository.getColorList().get(position);
        setColorBackground(color, true);
    }

    @Override
    public void onTestFinished() {
        mView.showTestFinishedSnackbar();
    }
}
