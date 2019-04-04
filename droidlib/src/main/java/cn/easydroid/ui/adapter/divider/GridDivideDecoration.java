package cn.easydroid.ui.adapter.divider;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridDivideDecoration extends RecyclerView.ItemDecoration {
    private int itemSpace;
    private int columnCount;

    /**
     *
     * @param itemSpace item间隔
     * @param columnCount 每行item的个数
     */
    public GridDivideDecoration(int itemSpace, int columnCount) {
        this.itemSpace = itemSpace;
        this.columnCount = columnCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = itemSpace;

        int childPos = parent.getChildLayoutPosition(view);
        if (childPos % columnCount == 0){  //parent.getChildLayoutPosition(view) 获取view的下标
            outRect.left = 0;
        } else {
            outRect.left = itemSpace;
//            XLog.d("NineGridImageAdapter", "outRect.left:" + outRect.left + "  , pos:" + childPos);

        }

    }
}
