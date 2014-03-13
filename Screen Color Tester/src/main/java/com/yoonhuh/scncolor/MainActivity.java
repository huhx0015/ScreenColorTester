package com.yoonhuh.scncolor;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import java.util.Random;

/** -----------------------------------------------------------------------------------------------
 *  [MainActivity] CLASS
 *  PROGRAMMER: Michael Yoon Huh (HUHX0015)
 *  DESCRIPTION: MainActivity class is responsible for handling the first activity in the app and sets
 *  up the references and the click actions for the color buttons.
 *  -----------------------------------------------------------------------------------------------
 */

public class MainActivity extends Activity {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // Button variables.
    Button red, black, white, green, grey, brown, pink, blue, purple, random;

    /** ACTIVITY LIFECYCLE FUNCTIONALITY _______________________________________________________ **/

    // onCreate(): The initial function that is called when the activity is run. onCreate() only runs
    // when the activity is first started.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpColorButtons(); // Sets up the color buttons.
    }

    /** ADDITIONAL FUNCTIONALITY _______________________________________________________________ **/

    // randomColor(): Generates a random number for the random color background.
    private int randomColor() {

        // Generates random number and sets the variable.
        Random rand = new Random();
        int random_number = rand.nextInt(255 - 1) + 1; // Establishes the range to 255.

        return random_number;
    }

    // setUpColorButtons(): Sets up the button listeners for the color buttons.
    private void setUpColorButtons() {

        // Defines the local variables for the layout.
        final FrameLayout layout = (FrameLayout) findViewById(R.id.main_layout);
        final WindowManager.LayoutParams layoutParams = this.getWindow().getAttributes();

        // Initializes and sets the proper Button resources to the Button variables.
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

                layout.setBackgroundColor(Color.rgb(138, 138, 138)); // Sets the background grey.
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
    }
}
