package com.huhx0015.screencolortester.presentation.presenters.implementations;

import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.domain.repositories.ColorRepository;
import com.huhx0015.screencolortester.domain.repositories.implementations.ColorRepositoryImpl;
import com.huhx0015.screencolortester.presentation.presenters.ColorPresenter;
import com.huhx0015.screencolortester.presentation.ui.view.ColorView;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class ColorPresenterImpl implements ColorPresenter {

    private ColorView mView;
    private ColorRepository mRepository;

    public ColorPresenterImpl(ColorView view) {
        this.mView = view;
        this.mRepository = new ColorRepositoryImpl();
    }

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
    public void initView() {
        mView.showView();
    }

    @Override
    public List<ScreenColor> getAllColors() {
        return mRepository.getAllColors();
    }

    @Override
    public void setColorList(List<ScreenColor> colorList) {
        mRepository.setColorList(colorList);
    }

    @Override
    public void onColorListLoaded() {
        if (mRepository.getAllColors() == null) {
            mRepository.initColorList();
        }
        mView.showColorList(mRepository.getAllColors());
    }

    @Override
    public void testButtonClicked() {

    }

    @Override
    public void fabButtonClicked() {

    }
}
