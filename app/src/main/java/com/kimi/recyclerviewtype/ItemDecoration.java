package com.kimi.recyclerviewtype;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kimipon on 2017/8/31.
 */

public class ItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public ItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = space;
        } else {
            outRect.top = 0;
        }
    }
}
