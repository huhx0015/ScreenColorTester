package com.huhx0015.screencolortester.presentation.ui.view;

import android.support.v7.widget.AppCompatImageView;
import com.huhx0015.screencolortester.domain.models.ScreenColor;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public interface ColorListAdapterView extends BaseView {

    void showColorRow(AppCompatImageView view, ScreenColor color);
}
