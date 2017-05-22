package com.huhx0015.screencolortester.presentation.ui.activities;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.huhx0015.screencolortester.R;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.presentation.presenters.implementations.ColorPresenterImpl;
import com.huhx0015.screencolortester.presentation.ui.adapters.ColorListAdapter;
import com.huhx0015.screencolortester.presentation.ui.utils.DisplayUtils;
import com.huhx0015.screencolortester.presentation.ui.view.ColorView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/** -----------------------------------------------------------------------------------------------
 *  [ColorActivity] CLASS
 *  DEVELOPER: Huh X0015
 *  DESCRIPTION: ColorActivity class is the primary activity class for this application, which
 *  displays the list of colors for the user to select from. When a color is selected, an intent
 *  to FullColorActivity is launched to display the color in fullscreen.
 *  -----------------------------------------------------------------------------------------------
 */

public class ColorActivity extends AppCompatActivity implements ColorView {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // CONSTANTS VARIABLES:
    private static final int COLOR_PORTRAIT_COLUMNS_VALUE = 3;
    private static final int COLOR_LANDSCAPE_COLUMNS_VALUE = 6;
    private static final int PREFETCH_VALUE = 6;

    // INSTANCE VARIABLES:
    private static final String INSTANCE_COLOR_LIST = ColorActivity.class.getSimpleName() + "_COLOR_LIST";

    // PRESENTER VARIABLES:
    private ColorPresenterImpl mPresenter;

    // VIEW INJECTION VARIABLES:
    @BindView(R.id.color_test_button) AppCompatButton mTestButton;
    @BindView(R.id.color_select_text) AppCompatTextView mSelectText;
    @BindView(R.id.color_recycler_view) RecyclerView mColorRecyclerView;
    @BindView(R.id.color_toolbar) Toolbar mToolbar;

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________ **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        ButterKnife.bind(this);
        mPresenter = new ColorPresenterImpl(this);
        mPresenter.initView();
        initColorList(savedInstanceState);
    }

    /** ACTIVITY EXTENSION METHODS _____________________________________________________________ **/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        List<ScreenColor> colorList = mPresenter.getRepository().getAllColors();
        if (colorList != null) {
            outState.putParcelableArrayList(INSTANCE_COLOR_LIST, new ArrayList<Parcelable>(colorList));
        }
    }

    /** INIT METHODS ___________________________________________________________________________ **/

    @OnClick(R.id.color_test_button)
    public void colorTestButton() {
        mPresenter.testButtonClicked(this);
    }

    private void initColorList(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            List<ScreenColor> colorList = savedInstanceState.getParcelableArrayList(INSTANCE_COLOR_LIST);
            if (colorList != null) {
                mPresenter.getRepository().setColorList(colorList);
            }
        }
        mPresenter.onColorListLoaded();
    }

    private void initText() {
        mSelectText.setShadowLayer(2, 2, 2, Color.BLACK);
        mTestButton.setShadowLayer(2, 2, 2, Color.BLACK);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
    }

    private void initRecyclerView() {
        GridLayoutManager layoutManager;
        if (DisplayUtils.getOrientation(this) == Configuration.ORIENTATION_PORTRAIT) {
            layoutManager = new GridLayoutManager(this, COLOR_PORTRAIT_COLUMNS_VALUE);
        } else {
            layoutManager = new GridLayoutManager(this, COLOR_LANDSCAPE_COLUMNS_VALUE);
        }
        layoutManager.setItemPrefetchEnabled(true);
        layoutManager.setInitialPrefetchItemCount(PREFETCH_VALUE);

        mColorRecyclerView.setLayoutManager(layoutManager);
        mColorRecyclerView.setHasFixedSize(true);
        mColorRecyclerView.setDrawingCacheEnabled(true);
        mColorRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        ColorListAdapter adapter = new ColorListAdapter(mPresenter.getRepository().getAllColors());
        adapter.setHasStableIds(true);
        mColorRecyclerView.setAdapter(adapter);
    }

    /** VIEW METHODS ___________________________________________________________________________ **/

    @Override
    public void showProgress() {}

    @Override
    public void hideProgress() {}

    @Override
    public void showError(String message) {}

    @Override
    public void showView() {
        initText();
        initToolbar();
    }

    @Override
    public void showColorList() {
        initRecyclerView();
    }

    @Override
    public void onTestButtonClicked() {

    }
}
