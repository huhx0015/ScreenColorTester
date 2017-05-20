package com.huhx0015.screencolortester.presentation.ui.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import com.huhx0015.screencolortester.R;
import com.huhx0015.screencolortester.constants.ColorConstants;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.presentation.presenters.implementations.FullColorPresenterImpl;
import com.huhx0015.screencolortester.presentation.ui.view.FullColorView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class FullColorActivity extends AppCompatActivity implements FullColorView {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // PRESENTER VARIABLES:
    private FullColorPresenterImpl mPresenter;

    // VIEw INJECTION VARIABLES:
    @BindView(R.id.activity_full_color_layout) RelativeLayout mActivityLayout;

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_color);
        ButterKnife.bind(this);
        mPresenter = new FullColorPresenterImpl(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ScreenColor color = bundle.getParcelable(ColorConstants.BUNDLE_SCREEN_COLOR);
            if (color != null) {
                mPresenter.setColorBackground(color);
            }
        }
    }

    /** VIEW METHODS ___________________________________________________________________________ **/

    @Override
    public void showBackgroundColor(ScreenColor color) {
        if (color.resource != null) {
            mActivityLayout.setBackgroundColor(color.resource);
        } else {
            mActivityLayout.setBackgroundColor(Color.rgb(color.red, color.green, color.blue));
        }
    }

    @Override
    public void showProgress() {}

    @Override
    public void hideProgress() {}

    @Override
    public void showError(String message) {}
}
