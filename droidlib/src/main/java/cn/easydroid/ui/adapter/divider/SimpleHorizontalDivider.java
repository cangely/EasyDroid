package cn.easydroid.ui.adapter.divider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.print.PrinterId;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.easydroid.util.DimensionConvert;
import cn.easydroid.util.ScreenUtils;


public class SimpleHorizontalDivider extends RecyclerView.ItemDecoration{
    private Drawable mLine;
    private boolean drawDividerLine;
    int mSpace;
    int leftSpace;
    int rightSpace;
    private final int DEFAULT_COLOR = Color.parseColor("#333333");
    private int default_horizontal_margin = 15;

    public void setDividerMatchScreen(boolean dividerMatchScreen) {
        isDividerMatchScreen = dividerMatchScreen;
    }

    private boolean isDividerMatchScreen = false;
    private int screenWidth;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        if (layoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
            outRect.top = 0;
            outRect.left = 0;
            outRect.right = 0;
            outRect.bottom = mSpace;
            if (parent.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                outRect.bottom = 0;
            }

        }

    }

    private ColorDrawable colorDrawable() {
        return new ColorDrawable(DEFAULT_COLOR);
    }

    public void setLineColor(int color) {
        mLine = new ColorDrawable(color);
    }

    public SimpleHorizontalDivider(Context context, int space) {
        this.mSpace = space;
        init(context, space, false);
    }
    public SimpleHorizontalDivider(Context context, int space, boolean drawDividerLine) {
        this.mSpace = space;
        init(context, space, drawDividerLine);
    }

    private void init(Context context, int space, boolean drawDividerLine) {
        mLine = colorDrawable();
        leftSpace = DimensionConvert.dp2px(context,default_horizontal_margin);
        rightSpace = leftSpace;
        this.drawDividerLine = drawDividerLine;
        this.screenWidth = ScreenUtils.getScreenWidth(context);
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (drawDividerLine) {
            drawHorizontal(c, parent, state);
        }
    }
    private void drawHorizontal(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            int left = child.getLeft() + leftSpace;
            int top = child.getBottom() + mSpace/2;
            int right = child.getRight() - rightSpace;
            int bottom = top + 2;

            if (isDividerMatchScreen) {
                left = 0;
                right = screenWidth;
            }
            mLine.setBounds(left, top, right, bottom);
            mLine.draw(c);
        }
    }

    public void setLinePadingSpace(int leftSpace, int rightSpace) {
        this.leftSpace = leftSpace;
        this.rightSpace = rightSpace;
    }
}
