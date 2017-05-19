package com.huhx0015.screencolortester.presentation.ui.view;

import com.huhx0015.screencolortester.domain.models.ScreenColor;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public interface ColorView extends BaseView {

    void showView();

    void showColorList(List<ScreenColor> colorList);

    void onFabButtonClicked();

    void onRandomButtonClicked();

}
