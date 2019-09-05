package cn.easydroid.android.ui.help;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

/**
 * Create Date: 6/29/2019
 * Author: Yang Du
 * Description:
 */
public class ColorHelper {
    public static void setTextViewColor(TextView textView,int color) {
        if (textView == null ) {
            return;
        }
        textView.setTextColor(color);
    }

    public static void setBackgoundColor(View view, int color) {
        if (view == null ) {
            return;
        }
        view.setBackgroundColor(color);
    }

    /**
     *
     * @param colorStr "#FFFFFF" 或 "#FFFFFFFF"
     * @return
     */
    public static int reverse(String colorStr) {
        int color = Color.BLACK;
        if (colorStr == null|| (colorStr.length() != 7 &&  colorStr.length() != 9)) {
            return color;
        }
        int alpha = 0xFF;
        int red = 0xFF;
        int green = 0xFF;
        int blue = 0xFF;
        if (colorStr.length() == 9) {
            String alphaStr = colorStr.substring(1, 3);
            alpha = alpha - Integer.parseInt(alphaStr, 16);
            red = red - Integer.parseInt(colorStr.substring(3, 5), 16);
            green = green - Integer.parseInt(colorStr.substring(5, 7), 16);
            blue = blue - Integer.parseInt(colorStr.substring(7, 9), 16);
        } else {
            red = red - Integer.parseInt(colorStr.substring(1,3), 16);
            green = green - Integer.parseInt(colorStr.substring(3,5), 16);
            blue = blue - Integer.parseInt(colorStr.substring(5,7), 16);
        }

        return Color.argb(alpha, red, green, blue);
    }
}
