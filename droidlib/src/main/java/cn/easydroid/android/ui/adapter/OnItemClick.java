package cn.easydroid.android.ui.adapter;

public abstract class OnItemClick<T, F> {

    public void onItemClick(int position, T model, int tag, F holder) {
    }

    public void onItemLongClick(int position, T model, int tag, F holder) {
    }
}
