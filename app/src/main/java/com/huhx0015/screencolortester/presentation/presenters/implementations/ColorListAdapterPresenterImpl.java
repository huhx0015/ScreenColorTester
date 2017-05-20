package com.huhx0015.screencolortester.presentation.presenters.implementations;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.domain.repositories.ColorRepository;
import com.huhx0015.screencolortester.domain.repositories.implementations.ColorRepositoryImpl;
import com.huhx0015.screencolortester.presentation.presenters.ColorListAdapterPresenter;
import com.huhx0015.screencolortester.presentation.ui.activities.FullColorActivity;
import com.huhx0015.screencolortester.presentation.ui.utils.ColorUtils;
import com.huhx0015.screencolortester.presentation.ui.view.ColorListAdapterView;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public class ColorListAdapterPresenterImpl implements ColorListAdapterPresenter {

    private static final String BUNDLE_SCREEN_COLOR = ColorListAdapterPresenterImpl.class + "_SCREEN_COLOR";

    private ColorListAdapterView mView;
    private ColorRepository mRepository;

    public ColorListAdapterPresenterImpl(ColorListAdapterView view) {
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
    public List<ScreenColor> getAllColors() {
        return mRepository.getAllColors();
    }

    @Override
    public void setColorList(List<ScreenColor> colorList) {
        mRepository.setColorList(colorList);
    }

    @Override
    public void setColor(AppCompatImageView view, ScreenColor color) {
        mView.showColorRow(view, color);
    }

    @Override
    public void onColorClicked(ScreenColor color, Context context) {

        // Sets a random color.
        if (color.isRandom) {
            color.setRGB(ColorUtils.randomColor(), ColorUtils.randomColor(), ColorUtils.randomColor());
        }

        Intent fullColorIntent = new Intent(context, FullColorActivity.class);
        fullColorIntent.putExtra(BUNDLE_SCREEN_COLOR, color);
        context.startActivity(fullColorIntent);
    }
}
