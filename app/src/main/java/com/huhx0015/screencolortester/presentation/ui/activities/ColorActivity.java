package com.huhx0015.screencolortester.presentation.ui.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.huhx0015.screencolortester.R;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.presentation.presenters.implementations.ColorPresenterImpl;
import com.huhx0015.screencolortester.presentation.ui.adapters.ColorListAdapter;
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
    private static final int COLOR_COLUMNS_VALUE = 4;
    private static final int PREFETCH_VALUE = 6;

    // INSTANCE VARIABLES:
    private static final String INSTANCE_COLOR_LIST = ColorActivity.class.getSimpleName() + "_COLOR_LIST";

    // PRESENTER VARIABLES:
    private ColorPresenterImpl mPresenter;

    // VIEW INJECTION VARIABLES:
    @BindView(R.id.color_recycler_view) RecyclerView mColorRecyclerView;
    @BindView(R.id.color_toolbar) Toolbar mToolbar;

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________ **/

    // onCreate(): The initial function that is called when the activity is run. onCreate() only
    // runs when the activity is first started.
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
        if (mPresenter.getAllColors() != null) {
            outState.putParcelableArrayList(INSTANCE_COLOR_LIST, new ArrayList<Parcelable>(mPresenter.getAllColors()));
        }
    }

    /** INIT METHODS ___________________________________________________________________________ **/

    @OnClick(R.id.color_test_button)
    public void colorTestButton() {
        mPresenter.testButtonClicked();
    }

    @OnClick(R.id.color_floating_action_button)
    public void colorFloatingActionButton() {
        mPresenter.fabButtonClicked();
    }

    private void initColorList(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            List<ScreenColor> colorList = savedInstanceState.getParcelableArrayList(INSTANCE_COLOR_LIST);
            if (colorList != null) {
                mPresenter.setColorList(colorList);
            }
        }
        mPresenter.onColorListLoaded();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
    }

    private void initRecyclerView(List<ScreenColor> colorList) {
        GridLayoutManager layoutManager = new GridLayoutManager(this, COLOR_COLUMNS_VALUE);
        layoutManager.setItemPrefetchEnabled(true);
        layoutManager.setInitialPrefetchItemCount(PREFETCH_VALUE);

        mColorRecyclerView.setLayoutManager(layoutManager);
        mColorRecyclerView.setHasFixedSize(true);
        mColorRecyclerView.setDrawingCacheEnabled(true);
        mColorRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        ColorListAdapter adapter = new ColorListAdapter(mPresenter.getAllColors());
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
        initToolbar();
    }

    @Override
    public void showColorList(List<ScreenColor> colorList) {
        initRecyclerView(colorList);
    }

    @Override
    public void onFabButtonClicked() {

    }

    @Override
    public void onRandomButtonClicked() {

    }
}
