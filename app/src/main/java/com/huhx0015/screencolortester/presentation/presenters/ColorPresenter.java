package com.huhx0015.screencolortester.presentation.presenters;

import com.huhx0015.screencolortester.domain.repositories.implementations.ColorRepositoryImpl;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public interface ColorPresenter extends BasePresenter {

    void initView();

    ColorRepositoryImpl getRepository();

    void onColorListLoaded();

    void testButtonClicked();

}
