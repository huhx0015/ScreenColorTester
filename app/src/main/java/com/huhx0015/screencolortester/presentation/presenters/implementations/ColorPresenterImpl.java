package com.huhx0015.screencolortester.presentation.presenters.implementations;

import com.huhx0015.screencolortester.domain.repositories.ColorRepository;
import com.huhx0015.screencolortester.presentation.presenters.ColorPresenter;
import com.huhx0015.screencolortester.presentation.ui.view.ColorView;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class ColorPresenterImpl implements ColorPresenter {

    private ColorView mView;
    private ColorRepository mRepository;

    public ColorPresenterImpl(ColorView view, ColorRepository repository) {
        this.mView = view;
        this.mRepository = repository;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void initView() {
        mView.showView();
    }

    @Override
    public void getAllColors() {

    }

    @Override
    public void testButtonClicked() {

    }

    @Override
    public void fabButtonClicked() {

    }
}
