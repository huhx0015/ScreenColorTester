package com.huhx0015.screencolortester.presentation.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.huhx0015.screencolortester.R;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.domain.repositories.implementations.ColorRepositoryImpl;
import com.huhx0015.screencolortester.presentation.presenters.implementations.ColorPresenterImpl;
import com.huhx0015.screencolortester.presentation.ui.view.ColorView;
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
    private static final int COLOR_COLUMNS_VALUE = 3;
    private static final int PREFETCH_VALUE = 6;

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
        mPresenter = new ColorPresenterImpl(this, new ColorRepositoryImpl());
        mPresenter.initView();
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

//        RecipeListAdapter adapter = new RecipeListAdapter(mPresenter.getRecipeResults(), this);
//        adapter.setHasStableIds(true);
//        mColorRecyclerView.setAdapter(adapter);
    }

    /** VIEW METHODS ___________________________________________________________________________ **/

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

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
