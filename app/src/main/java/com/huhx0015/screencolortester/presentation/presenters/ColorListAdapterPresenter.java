package com.huhx0015.screencolortester.presentation.presenters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.domain.repositories.ColorRepository;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public interface ColorListAdapterPresenter extends BasePresenter {

    ColorRepository getRepository();

    void setColor(AppCompatImageView view, ScreenColor color);

    void onColorClicked(ScreenColor color, Context context);
}
