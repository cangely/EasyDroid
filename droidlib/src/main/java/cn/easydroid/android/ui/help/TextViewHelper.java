package cn.easydroid.android.ui.help;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/**
 * Create Date: 5/27/2019
 * Author: Yang Du
 * Description:
 */
public class TextViewHelper {
    public static void setStyleBold(TextView textView) {
        if (textView != null) {
            TextPaint paint = textView.getPaint();
            paint.setFakeBoldText(true);
        }
    }
    public static void setStyleNotBold(TextView textView) {
        if (textView != null) {
            TextPaint paint = textView.getPaint();
            paint.setFakeBoldText(false);
        }
    }

    public static void addMidLine(TextView textView) {
        if (textView != null) {
            textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        }
    }
    public static void removeTextPaintFlags(TextView textView) {
        if (textView != null) {
            textView.getPaint().setFlags(0);  // 取消设置的的划线
        }
    }

    public static void setText(TextView textView, String text) {
        if (textView != null) {
            if (text != null) {
                textView.setText(text);
            } else {
                textView.setText("text is null");
            }
        }
    }
    public static void setText(TextView textView, boolean condition, String trueText,String falseText) {
        if (textView != null) {
            if (condition) {
                textView.setText(trueText);
            } else {
                textView.setText(falseText);
            }
        }
    }
    public static void setText(TextView textView, boolean condition, int trueTextId,int falseTextId) {
        if (textView != null) {
            if (condition) {
                textView.setText(trueTextId);
            } else {
                textView.setText(falseTextId);
            }
        }
    }
    public static void setTextOrHide(TextView textView, String text,boolean goneWhenTextEmpty) {
        if (textView != null) {
            if (!TextUtils.isEmpty(text)) {
                textView.setText(text);
            } else {
                textView.setVisibility(goneWhenTextEmpty? View.GONE:View.INVISIBLE);
            }
        }
    }
    public static void setTextOrHide(TextView textView, String text,boolean goneWhenTextEmpty,View... views) {
        if (textView != null) {
            if (!TextUtils.isEmpty(text)) {
                textView.setText(text);
                ViewHelper.showViews(views);
            } else {
                textView.setVisibility(goneWhenTextEmpty? View.GONE:View.INVISIBLE);
                if (goneWhenTextEmpty) {
                    ViewHelper.goneViews(views);
                } else {
                    ViewHelper.inVisibleViews(views);
                }
            }
        }
    }
}
