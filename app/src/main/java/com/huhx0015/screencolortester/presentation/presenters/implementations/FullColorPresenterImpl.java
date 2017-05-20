package com.huhx0015.screencolortester.presentation.presenters.implementations;

import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.presentation.presenters.FullColorPresenter;
import com.huhx0015.screencolortester.presentation.ui.view.FullColorView;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public class FullColorPresenterImpl implements FullColorPresenter {

    private FullColorView mView;

    public FullColorPresenterImpl(FullColorView view) {
        this.mView = view;
    }

    @Override
    public void setColorBackground(ScreenColor color) {
        // TODO: Sets color in repository.
        mView.showBackgroundColor(color);
    }
}
