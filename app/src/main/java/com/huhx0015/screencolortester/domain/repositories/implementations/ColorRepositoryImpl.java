package com.huhx0015.screencolortester.domain.repositories.implementations;

import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.domain.repositories.ColorRepository;
import com.huhx0015.screencolortester.presentation.ui.utils.ColorUtils;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class ColorRepositoryImpl implements ColorRepository {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // COLOR LIST VARIABLES:
    private List<ScreenColor> mColorList;

    /** REPOSITORY METHODS _____________________________________________________________________ **/

    @Override
    public void initColorList() {
        mColorList = ColorUtils.getAllColors();
    }

    @Override
    public List<ScreenColor> getAllColors() {
        return mColorList;
    }

    @Override
    public void setColorList(List<ScreenColor> colorList) {
        mColorList = colorList;
    }

    @Override
    public void clearColorList() {
        mColorList.clear();
        mColorList = null;
    }
}
