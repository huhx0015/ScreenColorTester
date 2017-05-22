package com.huhx0015.screencolortester.presentation.presenters;

import com.huhx0015.screencolortester.domain.interactors.implementations.FullColorInteractorImpl;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.domain.repositories.implementations.FullColorRepositoryImpl;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public interface FullColorPresenter extends BasePresenter {

    FullColorRepositoryImpl getRepository();

    FullColorInteractorImpl getInteractor();

    void setColorBackground(ScreenColor color, boolean isInitial);

    void setBrightness();

    void startTest(int position);

}
