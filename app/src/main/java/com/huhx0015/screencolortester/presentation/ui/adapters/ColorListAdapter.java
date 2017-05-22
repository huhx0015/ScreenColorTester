package com.huhx0015.screencolortester.presentation.ui.adapters;

import android.graphics.Color;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huhx0015.screencolortester.R;
import com.huhx0015.screencolortester.domain.models.ScreenColor;
import com.huhx0015.screencolortester.presentation.presenters.implementations.ColorListAdapterPresenterImpl;
import com.huhx0015.screencolortester.presentation.ui.view.ColorListAdapterView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Michael Yoon Huh on 5/18/2017.
 */

public class ColorListAdapter extends RecyclerView.Adapter<ColorListAdapter.ColorListViewHolder>
        implements ColorListAdapterView {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // ADAPTER VARIABLES:
    private int mColorSize;

    // PRESENTER VARIABLES:
    private ColorListAdapterPresenterImpl mPresenter;

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public ColorListAdapter(List<ScreenColor> colorList) {
        mPresenter = new ColorListAdapterPresenterImpl(this);
        mPresenter.getRepository().setColorList(colorList);
        mColorSize = colorList.size();
    }

    /** ADAPTER METHODS ________________________________________________________________________ **/

    @Override
    public ColorListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_color_row, parent, false);
        return new ColorListViewHolder(view, new ColorListViewHolder.ColorListClickListener() {
            @Override
            public void onColorClicked(View view, int position) {
                mPresenter.onColorClicked(mPresenter.getRepository().getAllColors().get(position), view.getContext());
            }
        });
    }

    @Override
    public void onBindViewHolder(ColorListViewHolder holder, int position) {
        ScreenColor color = mPresenter.getRepository().getAllColors().get(position);
        mPresenter.setColor(holder.colorView, color);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mColorSize;
    }

    /** VIEW METHODS ___________________________________________________________________________ **/

    @Override
    public void showColorRow(AppCompatImageView view, ScreenColor color) {
        if (color.isRandom) {
            view.setImageResource(R.drawable.ic_random);
        } else if (color.resource != 0) {
            view.setBackgroundColor(color.resource);
        } else {
            view.setBackgroundColor(Color.rgb(color.red, color.green, color.blue));
        }
    }

    @Override
    public void showProgress() {}

    @Override
    public void hideProgress() {}

    @Override
    public void showError(String message) {}

    /** SUBCLASSES _____________________________________________________________________________ **/

    static class ColorListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.adapter_color_view) AppCompatImageView colorView;

        ColorListClickListener colorListClickListener;

        ColorListViewHolder(View itemView, ColorListClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            if (listener != null) {
                colorListClickListener = listener;
                itemView.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View v) {
            int itemPos = getAdapterPosition();
            colorListClickListener.onColorClicked(v, itemPos);
        }

        interface ColorListClickListener {
            void onColorClicked(View view, int position);
        }
    }
}
