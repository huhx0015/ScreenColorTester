package com.huhx0015.screencolortester.presentation.ui.utils;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class DisplayUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    public static int getOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static void setMaximumBrightness(Activity activity) {
        WindowManager.LayoutParams windowManagerParams = activity.getWindow().getAttributes();
        windowManagerParams.screenBrightness = 1.0F; // Raises the brightness level.
        activity.getWindow().setAttributes(windowManagerParams); // Sets the attributes.
    }
}
