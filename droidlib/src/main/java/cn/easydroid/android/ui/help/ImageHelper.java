package cn.easydroid.android.ui.help;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.ImageView;

/**
 * Create Date: 6/6/2019
 * Author: Yang Du
 * Description:
 */
public class ImageHelper {
    public static void changeTintColor(ImageView imageView, int newColor) {
        if (imageView == null) {
            return;
        }
        Drawable vectorDrawable = imageView.getDrawable();
        Drawable tintIcon = DrawableCompat.wrap(vectorDrawable).mutate();
        DrawableCompat.setTint(tintIcon,newColor);
        imageView.setImageDrawable(tintIcon);
    }
}
