package cn.easydroid.android.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import cn.easydroid.droidlib.R;
import cn.easydroid.util.DimensionConvert;


public class CommonLoadingDialog extends Dialog {
    public CommonLoadingDialog(@NonNull Context context) {
        super(context, R.style.Dialog);
        setOwnerActivity((Activity) context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void show() {
        super.show();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.width = DimensionConvert.dp2px(getContext(),100);
        layoutParams.height = DimensionConvert.dp2px(getContext(),80);

        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(layoutParams);
//        window.setWindowAnimations(R.style.DialogAnimBottom);
    }

}
