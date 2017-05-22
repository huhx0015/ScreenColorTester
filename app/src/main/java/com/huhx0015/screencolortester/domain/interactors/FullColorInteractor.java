package com.huhx0015.screencolortester.domain.interactors;

/**
 * Created by Michael Yoon Huh on 5/21/2017.
 */

public interface FullColorInteractor {

    void start();

    void stop();

    int getTestPosition();

    void setTestPosition(int position);

    interface Callback {

        void onScreenColorChange(int position);

        void onTestFinished();
    }
}
