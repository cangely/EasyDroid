package cn.easydroid.android.ui.help;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Create Date: 5/31/2019
 * Author: Yang Du
 * Description:
 */
public class RecyclerViewHelper {
    public static void initRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager) {
        if (recyclerView == null) {
            return;
        }
        if (layoutManager == null) {
            throw new IllegalArgumentException("LayoutManager must not be NULL");
        }
        if (adapter != null) {
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
        }
    }

    public static void iniLinearVerticalRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter, Context context) {
        if (recyclerView == null) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("Context must not be NULL");
        }
        if (adapter != null) {
            recyclerView.setAdapter(adapter);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public static void needBeNested(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusableInTouchMode(false);
    }

    public static void clearItemDecoration(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        int count = recyclerView.getItemDecorationCount();
        for (int i = 0; i < count; i++) {
            recyclerView.removeItemDecorationAt(i );
        }
    }
}
