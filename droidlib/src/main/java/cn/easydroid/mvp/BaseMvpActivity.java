package cn.easydroid.mvp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import cn.easydroid.android.ui.dialog.CommonLoadingDialog;
import cn.easydroid.droidlib.R;

public abstract class BaseMvpActivity<T extends BasePresenter> extends RxFragmentActivity implements BaseView {

    public T mPresenter;

    private Dialog loadingDialog;

    public abstract T cretaePresenter();

    //获取当前activity布局文件
    public abstract int getContentViewId();

    //设置监听事件
    public abstract void setListener();

    //处理逻辑业务
    protected abstract void processLogic();


    private void initAnotherProgressBar() {
        View view = LayoutInflater.from(this).inflate(R.layout.loading_dialog, null);
        loadingDialog = new CommonLoadingDialog(this);
        loadingDialog.setCancelable(true);
        loadingDialog.setContentView(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mPresenter = cretaePresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        setListener();
        processLogic();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    @Override
    public void showLoading(String message) {
        if (loadingDialog == null || loadingDialog.isShowing()) {
            return;
        }
        if (message != null) {
            TextView textView = loadingDialog.findViewById(R.id.loadingTextView);
            textView.setText(message);
        }
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }


    public void transfer(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }


    //快速获取textView 或 EditText上文字内容
    public String getStringByUI(View view) {
        if (view instanceof EditText) {
            return ((EditText) view).getText().toString().trim();
        } else if (view instanceof TextView) {
            return ((TextView) view).getText().toString().trim();
        }
        return "";
    }

    @Override
    public LifecycleTransformer bindLifecycle() {
        LifecycleTransformer objectLifecycleTransformer = bindToLifecycle();
        return objectLifecycleTransformer;
    }
}
