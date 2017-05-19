package com.huhx0015.screencolortester.presentation.ui.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Michael Yoon Huh on 2/1/2017.
 */

public class SnackbarUtils {

    /** UTILITY METHODS ________________________________________________________________________ **/

    public static void displaySnackbar(View view, String message, int length, int color) {
        Snackbar snackbar = Snackbar.make(view, message, length);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(color);
        snackbar.show();
    }

    public static void displaySnackbarWithAction(View view, String message, int length, int color,
                                                 String action, View.OnClickListener listener) {
        Snackbar snackbar = Snackbar.make(view, message, length)
                .setAction(action, listener);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(color);
        snackbar.show();
    }
}