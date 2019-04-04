package cn.easydroid.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import cn.easydroid.util.DimensionConvert;


public class HeaderFooterMargin {
    private static final int marginTopDefault = 15;
    private static final int marginBottomDefault = 15;
    public static void adjustDefault(View itemView, int maxCount, int position) {
        if (checkParams(itemView, maxCount, position)) {
            Context context = itemView.getContext().getApplicationContext();
            int topMargin = DimensionConvert.dp2px(context,marginTopDefault);
            int bottomMargin = DimensionConvert.dp2px(context,marginBottomDefault);
            adjust(itemView, maxCount, position, topMargin, bottomMargin);
        }

    }

    private static boolean checkParams(View itemView, int maxCount, int position) {
        return itemView != null && maxCount > 0 && position >= 0 && position < maxCount;
    }

    public static void adjust(View itemView, int maxCount, int position, int marginTop, int marginBottom) {
        if (!checkParams(itemView, maxCount, position)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        RecyclerView.LayoutParams lp;
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            lp = (RecyclerView.LayoutParams) layoutParams;
        } else {
            return;
        }
        if (isFirstItem(maxCount, position)) {
            lp.topMargin = marginTop;
        } else if (isLastItem(maxCount, position)) {
            lp.bottomMargin = marginBottom;
        } else {
            lp.topMargin = 0;
            lp.bottomMargin = 0;
        }

        itemView.setLayoutParams(lp);
    }


    private static boolean isFirstItem(int maxCount, int position) {
        if (maxCount > 0) {
            return position == 0;
        }
        return false;
    }

    private static boolean isLastItem(int maxCount, int position) {
        if (maxCount > 1) {
            return position == maxCount - 1;
        }
        return false;
    }
}
