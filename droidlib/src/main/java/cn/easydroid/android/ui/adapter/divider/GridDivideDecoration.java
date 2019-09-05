package cn.easydroid.android.ui.adapter.divider;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridDivideDecoration extends RecyclerView.ItemDecoration {
    private int spacing;
    private int spanCount;
    private boolean includeEdge;
    /**
     *
     * @param itemSpace item间隔
     * @param columnCount 每行item的个数
     */
    public GridDivideDecoration(int itemSpace, int columnCount) {
        this.spacing = itemSpace;
        this.spanCount = columnCount;
    }

    public GridDivideDecoration(int itemSpace, int columnCount, boolean includeEdge) {
        this.includeEdge = includeEdge;
        this.spacing = itemSpace;
        this.spanCount = columnCount;
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        int column = position % spanCount;
        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount;
            outRect.right = (column + 1) * spacing / spanCount;
            if (position < spanCount) {
                outRect.top = spacing;
            }
            outRect.bottom = spacing;
        } else {
            outRect.left = column * spacing / spanCount;
            outRect.right = spacing - (column + 1) * spacing / spanCount;
            if (position < spanCount) {
                outRect.top = spacing;
            }
            outRect.bottom = spacing;
        }

    }
}
