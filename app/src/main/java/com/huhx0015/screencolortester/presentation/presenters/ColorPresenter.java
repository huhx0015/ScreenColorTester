package com.huhx0015.screencolortester.presentation.presenters;

import com.huhx0015.screencolortester.domain.models.ScreenColor;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public interface ColorPresenter extends BasePresenter {

    void initView();

    List<ScreenColor> getAllColors();

    void setColorList(List<ScreenColor> colorList);

    void onColorListLoaded();

    void testButtonClicked();

}
