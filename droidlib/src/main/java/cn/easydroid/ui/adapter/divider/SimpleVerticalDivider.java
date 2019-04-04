package cn.easydroid.ui.adapter.divider;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SimpleVerticalDivider extends RecyclerView.ItemDecoration{
    int mSpace;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;
        outRect.right = 0;
        outRect.top = 0;
        outRect.bottom = 0;
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = 0;
        }

    }

    public SimpleVerticalDivider(int space) {
        this.mSpace = space;
    }
}
