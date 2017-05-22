package com.huhx0015.screencolortester.presentation.ui.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import com.huhx0015.screencolortester.R;
import com.huhx0015.screencolortester.constants.ColorConstants;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.presentation.presenters.implementations.FullColorPresenterImpl;
import com.huhx0015.screencolortester.presentation.ui.utils.DisplayUtils;
import com.huhx0015.screencolortester.presentation.ui.utils.SnackbarUtils;
import com.huhx0015.screencolortester.presentation.ui.view.FullColorView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class FullColorActivity extends AppCompatActivity implements FullColorView {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // PRESENTER VARIABLES:
    private FullColorPresenterImpl mPresenter;

    // INSTANCE VARIABLES:
    private static final String INSTANCE_COLOR = FullColorActivity.class.getSimpleName() + "_COLOR";
    private static final String INSTANCE_COLOR_LIST = FullColorActivity.class.getSimpleName() + "_COLOR_LIST";
    private static final String INSTANCE_TEST_MODE = FullColorActivity.class.getSimpleName() + "_TEST_MODE";
    private static final String INSTANCE_TEST_POSITION = FullColorActivity.class.getSimpleName() + "_TEST_POSITION";

    // VIEW INJECTION VARIABLES:
    @BindView(R.id.activity_full_color_layout) RelativeLayout mActivityLayout;

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_color);
        ButterKnife.bind(this);
        mPresenter = new FullColorPresenterImpl(this);

        if (savedInstanceState != null) {
            initSavedInstance(savedInstanceState);
        } else {
            initBundle();
        }

        mPresenter.setBrightness();
    }

    /** ACTIVITY EXTENSION METHODS _____________________________________________________________ **/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // SCREEN COLOR:
        ScreenColor color = mPresenter.getRepository().getColor();
        if (color != null) {
            outState.putParcelable(INSTANCE_COLOR, mPresenter.getRepository().getColor());
        }

        // COLOR LIST:
        List<ScreenColor> colorList = mPresenter.getRepository().getColorList();
        if (colorList != null) {
            outState.putParcelableArrayList(INSTANCE_COLOR_LIST, new ArrayList<Parcelable>(colorList));
        }

        // TEST MODE:
        outState.putBoolean(INSTANCE_TEST_MODE, mPresenter.getRepository().getTestMode());

        // TEST POSITION:
        outState.putInt(INSTANCE_TEST_POSITION, mPresenter.getRepository().getColorListPosition());
    }

    /** INIT METHODS ___________________________________________________________________________ **/

    private void initBundle() {
        Bundle bundle = getIntent().getExtras();

        // SCREEN COLOR:
        ScreenColor color = bundle.getParcelable(ColorConstants.BUNDLE_SCREEN_COLOR);
        if (color != null) {
            mPresenter.setColorBackground(color, true);
        }

        // COLOR LIST:
        List<ScreenColor> colorList = bundle.getParcelableArrayList(ColorConstants.BUNDLE_COLOR_LIST);
        if (colorList != null) {
            mPresenter.getRepository().setColorList(colorList);
        }

        // TEST MODE:
        boolean testMode = bundle.getBoolean(ColorConstants.BUNDLE_TEST_MODE);
        mPresenter.getRepository().setTestMode(testMode);
    }

    private void initSavedInstance(Bundle savedInstanceState) {

        // SCREEN COLOR:
        ScreenColor color = savedInstanceState.getParcelable(INSTANCE_COLOR);
        if (color != null) {
            mPresenter.setColorBackground(color, false);
        }

        // COLOR LIST:
        List<ScreenColor> colorList = savedInstanceState.getParcelableArrayList(INSTANCE_COLOR_LIST);
        if (colorList != null) {
            mPresenter.getRepository().setColorList(colorList);
        }

        // TEST MODE:
        boolean testMode = savedInstanceState.getBoolean(INSTANCE_TEST_MODE);
        mPresenter.getRepository().setTestMode(testMode);

        // TEST POSITION:
        int testPosition = savedInstanceState.getInt(INSTANCE_TEST_POSITION);
        mPresenter.getRepository().setColorListPosition(testPosition);
    }

    /** VIEW METHODS ___________________________________________________________________________ **/

    @Override
    public void showBackgroundColor(ScreenColor color) {
        if (color.resource != 0) {
            mActivityLayout.setBackgroundColor(color.resource);
        } else {
            mActivityLayout.setBackgroundColor(Color.rgb(color.red, color.green, color.blue));
        }
    }

    @Override
    public void showBrightness() {
        DisplayUtils.setMaximumBrightness(this);
    }

    @Override
    public void showSnackbar(ScreenColor color) {
        SnackbarUtils.displaySnackbar(mActivityLayout,
                String.format(getString(R.string.snackbar_showing_full_color), color.name.toUpperCase()),
                Snackbar.LENGTH_SHORT, ContextCompat.getColor(this, R.color.colorPrimary));
    }

    @Override
    public void showProgress() {}

    @Override
    public void hideProgress() {}

    @Override
    public void showError(String message) {}
}
