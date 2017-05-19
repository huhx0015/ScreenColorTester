package com.huhx0015.screencolortester.domain.models;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class ScreenColor {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // COLOR ATTRIBUTE VARIABLES:
    public int resource;
    public int red;
    public int green;
    public int blue;

    // COLOR NAME VARIABLES:
    public String name;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public ScreenColor(String color, int resource) {
        this.name = color;
        this.resource = resource;
    }

    public ScreenColor(String color, int r, int g, int b) {
        this.name = color;
        this.red = r;
        this.green = g;
        this.blue = b;
    }
}
