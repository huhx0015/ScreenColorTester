package com.yoonhuh.scncolor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

/* yH-Screen-Color-Tester
 * PROGRAMMER: Michael Yoon Huh (huhx0015)
 * LAST UPDATED: 9/7/2013
 */

public class MainActivity extends Activity {

    // Button variables.
    Button red, black, white, green, grey, brown, pink, blue, teal, purple, random;

    // Intent variables.
    Intent currentIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    // Function that is responsible for actions on current screen.
    public boolean onCreateOptionsMenu(Menu menu) {

        // Defines the local variables for the layout.
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_layout);
        final WindowManager.LayoutParams layoutParams = this.getWindow().getAttributes();

        // Initializes and sets the proper Button resources (from layout) to the Button variables.
        red = (Button) findViewById(R.id.bRed);
        white = (Button) findViewById(R.id.bWhite);
        blue = (Button) findViewById(R.id.bBlue);
        green = (Button) findViewById(R.id.bGreen);
        pink = (Button) findViewById(R.id.bPink);
        brown = (Button) findViewById(R.id.bBrown);
        purple = (Button) findViewById(R.id.bPurple);
        black = (Button) findViewById(R.id.bBlack);
        grey = (Button) findViewById(R.id.bGrey);
        random = (Button) findViewById(R.id.bRandom);


        // Action for pressing on the red button.
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               layout.setBackgroundColor(Color.RED); // Sets the background red.
               layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
               getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.

                /*
                try {
                    // Sets the path to whatever cheese is set to.
                    Class ourClass = Class.forName("com.yoonhuh.scncolor.colorActivity");
                    Intent ourIntent = new Intent(MainActivity.this, ourClass);
                    startActivity(ourIntent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                */

                // currentIntent = new Intent("com.yoonhuh.scncolor.colorActivity");
               // startActivity(currentIntent);
               // PSUEDO CODE
               // GO TO DIFFERENT SCREEN AND SHOW COLOR.
               //
            }
        });

        // Action for pressing on the red button.
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.WHITE); // Sets the background white.
                layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
                getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.

            }
        });

        // Action for pressing on the blue button.
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.BLUE); // Sets the background blue.
                layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
                getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.

            }
        });

        // Action for pressing on the green button.
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.GREEN); // Sets the background green.
                layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
                getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.

            }
        });

        // Action for pressing on the pink button.
        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.rgb(255, 0, 255)); // Sets the background pink.
                layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
                getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.

            }
        });

        // Action for pressing on the brown button.
        brown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.rgb(97, 33, 11)); // Sets the background brown.
                layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
                getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.
            }
        });

        // Action for pressing on the purple button.
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.rgb(75, 8, 138)); // Sets the background purple.
                layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
                getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.

            }
        });

        // Action for pressing on the black button.
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.BLACK); // Sets the background black.
                layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
                getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.

            }
        });

        // Action for pressing on the grey button.
        grey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.rgb(138, 138, 138)); // Sets the background black.
                layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
                getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.
            }
        });

        // Action for pressing on the random button.
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setBackgroundColor(Color.rgb(randomColor(), randomColor(), randomColor())); // Sets the background to a random color.
                layoutParams.screenBrightness = 1.0F; // Raises the brightness level.
                getWindow().setAttributes(layoutParams); // Sets the attributes onto the layout.
            }
        });

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Generates a random number for the random color background.
    public int randomColor() {

        // Generates random number and sets the variable.
        Random rand = new Random();
        int random_number = rand.nextInt(255 - 1) + 1; // Establishes the range to 255.

        return random_number;
    }
    
}
