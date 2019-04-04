package cn.easydroid.ui.adapter;

public abstract class OnRecItemCallback<T, F> {

    public void onItemClick(int position, T model, int tag, F holder) {
    }

    public void onItemLongClick(int position, T model, int tag, F holder) {
    }
}
