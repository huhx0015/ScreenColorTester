package com.huhx0015.screencolortester.domain.interactors.implementations;

import android.os.Handler;
import com.huhx0015.screencolortester.constants.ColorConstants;
import com.huhx0015.screencolortester.domain.interactors.FullColorInteractor;
import timber.log.Timber;

/**
 * Created by Michael Yoon Huh on 5/21/2017.
 */

public class FullColorInteractorImpl implements FullColorInteractor {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // CALLBACK VARIABLES:
    private Callback mCallback;

    // CONSTANT VARIABLES:
    private static final int TOTAL_NUMBER_OF_TESTS = 10;

    // TEST VARIABLES:
    private int mTestPosition = 0;

    // THREAD VARIABLES:
    private Handler mHandler;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public FullColorInteractorImpl(Callback callback) {
        this.mCallback = callback;
    }

    /** INTERACTOR METHODS _____________________________________________________________________ **/

    @Override
    public void start() {
        if (mHandler == null) {
            mHandler = new Handler();
        }

        // Thread constantly loops for every THREAD_TIME_PER_SECOND until the thread is stopped.
        if (mTestPosition < TOTAL_NUMBER_OF_TESTS) {
            mHandler.postDelayed(mThread, ColorConstants.THREAD_TIME_PER_SCREEN);
            Timber.d("FullColorInteractorImpl.start(): Thread started.");
        }
    }

    @Override
    public void stop() {
        mHandler.removeCallbacks(mThread);
        Timber.d("FullColorInteractorImpl.stop(): Thread stopped.");
    }

    @Override
    public int getTestPosition() {
        return mTestPosition;
    }

    @Override
    public void setTestPosition(int position) {
        this.mTestPosition = position;
    }

    /** THREADS ________________________________________________________________________________ **/

    private Runnable mThread = new Runnable() {
        @Override
        public void run() {
            mCallback.onScreenColorChange(++mTestPosition); // Signals for a screen color change.

            // Stops the test if the current test position is equal to TOTAL_NUMBER_OF_TESTS.
            if (mTestPosition >= TOTAL_NUMBER_OF_TESTS) {
                mCallback.onTestFinished(); // Signals that the screen color test has finished.
                stop(); // Stops this thread.
            } else {
                mHandler.postDelayed(mThread, ColorConstants.THREAD_TIME_PER_SCREEN);
            }
        }
    };
}
