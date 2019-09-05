package cn.easydroid.android.ui.help;

import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;

/**
 * Create Date: 5/30/2019
 * Author: Yang Du
 * Description:
 */
public class ViewHelper {
    public static void setClickListener(View view, View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            return;
        }
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void setClickListener(View.OnClickListener onClickListener, View... views) {
        if (onClickListener == null) {
            return;
        }
        if (views != null) {
            for (View v : views) {
                if (v != null) {
                    v.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public static void goneView(View view) {
        if (view != null) {
            view.setVisibility(View.GONE);
        }
    }
    public static void goneViews(View... views) {
        if (views != null) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.GONE);
                }
            }
        }
    }

    public static void showView(View view) {
        if (view != null) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void showViews(View... views) {
        if (views != null) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public static void showOrGone(boolean show,View... views) {
        if (views != null) {
            for (View view : views) {
                if (view != null) {

                    view.setVisibility(show?View.VISIBLE:View.GONE);
                }
            }
        }
    }

    public static void highLightAndInvisible(Collection<View> allViews, View... highlightViews) {
        if (allViews == null || highlightViews == null || allViews.isEmpty()) {
            return;
        }
        for (View view : allViews) {
            if (view != null) {
                view.setVisibility(View.INVISIBLE);
            }
        }
        for (View lightView :highlightViews) {
            if (lightView != null) {
                lightView.setVisibility(View.VISIBLE);
            }
        }
    }

    public static void highLightAndGone(Collection<View> allViews, View... highlightViews) {
        if (allViews == null || highlightViews == null || allViews.isEmpty()) {
            return;
        }
        for (View view : allViews) {
            if (view != null) {
                view.setVisibility(View.GONE);
            }
        }
        for (View lightView :highlightViews) {
            if (lightView != null) {
                lightView.setVisibility(View.VISIBLE);
            }
        }
    }

    public static void inVisibleView(View view) {
        if (view != null) {
            view.setVisibility(View.INVISIBLE);
        }
    }

    public static void inVisibleViews(View... views) {
        if (views != null) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    public static void requestFocus(View view) {
        if (view == null) {
            return;
        }
        view.requestFocus();
    }

    public static void setSelect(View view, boolean select) {
        if (view != null) {
            view.setSelected(select);
        }
    }
    public static void setEnabled(View view, boolean enabled) {
        if (view != null) {
            view.setEnabled(enabled);
        }
    }

    public static void setSize(int width, int height, View... views) {
        if (views != null) {
            for (View view : views) {
                if (view != null) {
                    ViewGroup.LayoutParams lp = view.getLayoutParams();
                    lp.width = width;
                    lp.height = height;
                    view.setLayoutParams(lp);
                }
            }
        }
    }
    public static void setWidthSize(int width,View... views) {
        if (views != null) {
            for (View view : views) {
                if (view != null) {
                    ViewGroup.LayoutParams lp = view.getLayoutParams();
                    lp.width = width;
                    view.setLayoutParams(lp);
                }
            }
        }
    }
}
