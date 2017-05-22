package com.huhx0015.screencolortester.domain.repositories.implementations;

import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.domain.repositories.FullColorRepository;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public class FullColorRepositoryImpl implements FullColorRepository {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // COLOR VARIABLES:
    private ScreenColor mColor;

    // COLOR LIST VARIABLES:
    private List<ScreenColor> mColorList;

    // TEST VARIABLES:
    private boolean mTestMode;
    private int mTestPosition;

    /** REPOSITORY METHODS _____________________________________________________________________ **/

    @Override
    public ScreenColor getColor() {
        return mColor;
    }

    @Override
    public void setColor(ScreenColor color) {
        this.mColor = color;
    }

    @Override
    public boolean getTestMode() {
        return mTestMode;
    }

    @Override
    public void setTestMode(boolean isTest) {
        this.mTestMode = isTest;
    }

    @Override
    public List<ScreenColor> getColorList() {
        return mColorList;
    }

    @Override
    public void setColorList(List<ScreenColor> colorList) {
        this.mColorList = colorList;
    }

    @Override
    public int getTestPosition() {
        return mTestPosition;
    }

    @Override
    public void setTestPosition(int positon) {
        this.mTestPosition = positon;
    }

    @Override
    public void clearColorList() {
        mColorList.clear();
        mColorList = null;
    }
}
