package com.huhx0015.screencolortester.presentation.ui.utils;

import android.graphics.Color;
import com.huhx0015.screencolortester.constants.ColorConstants;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class ColorUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    // getAllColors(): Returns a list of all available colors.
    public List<ScreenColor> getAllColors() {

        List<ScreenColor> colorList = new ArrayList<>();

        colorList.add(new ScreenColor(ColorConstants.BLACK, Color.BLACK));
        colorList.add(new ScreenColor(ColorConstants.DKGRAY, Color.DKGRAY));
        colorList.add(new ScreenColor(ColorConstants.GRAY, Color.GRAY));
        colorList.add(new ScreenColor(ColorConstants.LTGRAY, Color.LTGRAY));
        colorList.add(new ScreenColor(ColorConstants.WHITE, Color.WHITE));
        colorList.add(new ScreenColor(ColorConstants.RED, Color.RED));
        colorList.add(new ScreenColor(ColorConstants.GREEN, Color.GREEN));
        colorList.add(new ScreenColor(ColorConstants.BLUE, Color.BLUE));
        colorList.add(new ScreenColor(ColorConstants.YELLOW, Color.YELLOW));
        colorList.add(new ScreenColor(ColorConstants.CYAN, Color.CYAN));
        colorList.add(new ScreenColor(ColorConstants.MAGENTA, Color.MAGENTA));

        return colorList;
    }

    // randomColor(): Generates a random color value for the random color background.
    public static int randomColor() {
        Random rand = new Random();
        return rand.nextInt(255 - 1) + 1; // Establishes the range to 255.
    }
}
