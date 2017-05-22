package com.huhx0015.screencolortester.domain.repositories;

import com.huhx0015.screencolortester.domain.models.ScreenColor;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public interface ColorRepository {

    void initColorList();

    List<ScreenColor> getAllColors();

    void setColorList(List<ScreenColor> colorList);

    void clearColorList();
}
