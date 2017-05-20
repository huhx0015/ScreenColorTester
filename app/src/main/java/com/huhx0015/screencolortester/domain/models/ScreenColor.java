package com.huhx0015.screencolortester.domain.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class ScreenColor implements Parcelable {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // COLOR ATTRIBUTE VARIABLES:
    public boolean isRandom;
    public Integer resource;
    public int red;
    public int green;
    public int blue;

    // COLOR NAME VARIABLES:
    public String name;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public ScreenColor() {
        this.isRandom = true;
    }

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

    protected ScreenColor(Parcel in) {
        isRandom = in.readByte() != 0;
        red = in.readInt();
        green = in.readInt();
        blue = in.readInt();
        name = in.readString();
    }

    /** SET METHODS ____________________________________________________________________________ **/

    public void setRGB(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    /** PARCELABLE METHODS _____________________________________________________________________ **/

    public static final Creator<ScreenColor> CREATOR = new Creator<ScreenColor>() {
        @Override
        public ScreenColor createFromParcel(Parcel in) {
            return new ScreenColor(in);
        }

        @Override
        public ScreenColor[] newArray(int size) {
            return new ScreenColor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isRandom ? 1 : 0));
        dest.writeInt(red);
        dest.writeInt(green);
        dest.writeInt(blue);
        dest.writeString(name);
    }
}
