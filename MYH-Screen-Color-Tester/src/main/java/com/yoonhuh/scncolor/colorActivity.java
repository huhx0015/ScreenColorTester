package com.yoonhuh.scncolor;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * Created by Michael Yoon Huh on 8/25/13.
 */
public class colorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_background); // Sets the layout

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.color_layout);
        final WindowManager.LayoutParams layoutParams = this.getWindow().getAttributes();

        // Set the background color and brightness.
        layout.setBackgroundColor(Color.RED);
        layoutParams.screenBrightness = 1.0F;
        getWindow().setAttributes(layoutParams);

    }
}
