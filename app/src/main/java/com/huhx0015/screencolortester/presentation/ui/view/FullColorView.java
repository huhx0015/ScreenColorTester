package com.huhx0015.screencolortester.presentation.ui.view;

import com.huhx0015.screencolortester.domain.models.ScreenColor;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public interface FullColorView extends BaseView {

    void showBackgroundColor(ScreenColor color);

    void showBrightness();

    void showSnackbar(ScreenColor color, String message);

    void showTestFinishedSnackbar();
}
