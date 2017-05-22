package com.huhx0015.screencolortester.domain.repositories;

import com.huhx0015.screencolortester.domain.models.ScreenColor;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 5/19/2017.
 */

public interface FullColorRepository {

    ScreenColor getColor();

    void setColor(ScreenColor color);

    boolean getTestMode();

    void setTestMode(boolean isTest);

    List<ScreenColor> getColorList();

    void setColorList(List<ScreenColor> colorList);

    int getColorListPosition();

    void setColorListPosition(int positon);

    void clearColorList();
}
