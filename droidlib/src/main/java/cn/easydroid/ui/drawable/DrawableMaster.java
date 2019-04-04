package cn.easydroid.ui.drawable;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class DrawableMaster {

    private int shape = GradientDrawable.RECTANGLE;
    private int startColor = Color.WHITE;
    private int mediumColor = Color.WHITE;
    private int endColor = Color.WHITE;
    private GradientDrawable.Orientation gradientOrientation = GradientDrawable.Orientation.LEFT_RIGHT;
    private int roundRadius = 0;
    private int strokeWidth = 0;
    private int strokeColor = Color.GRAY;
    private int alpha = 255;
    private int disableColor = Color.parseColor("#dddddd");
    private int pressedColor = Color.parseColor("#aaaaaa");


    public static DrawableMaster newInstance() {
        DrawableMaster drawableMaster = new DrawableMaster();
        return drawableMaster;
    }

    /**
     *
     * @param shape The desired shape for this drawable:
     *              {@link android.graphics.drawable.GradientDrawable#LINE},
     *              {@link android.graphics.drawable.GradientDrawable#OVAL},
     *              {@link android.graphics.drawable.GradientDrawable#RECTANGLE} or
     *              {@link android.graphics.drawable.GradientDrawable#RING}
     */
    public DrawableMaster withShape(int shape) {
        this.shape = shape;
        return this;
    }

    public DrawableMaster withSolidColor(int bgColor) {
        this.startColor = bgColor;
        this.mediumColor = bgColor;
        this.endColor = bgColor;
        return this;
    }

    public DrawableMaster withSolidColor(int startColor, int mediumColor, int endColor) {
        this.startColor = startColor;
        this.mediumColor = mediumColor;
        this.endColor = endColor;
        return this;
    }

    public DrawableMaster withGradientOrientation(GradientDrawable.Orientation gradientAngle) {
        this.gradientOrientation = gradientAngle;
        return this;
    }

    public DrawableMaster withRoundRadius(int roundRadius){
        this.roundRadius = roundRadius;
        return this;
    }

    public DrawableMaster withStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        return this;
    }

    public DrawableMaster withStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        return this;
    }

    public DrawableMaster withAlpha(int alpha) {
        this.alpha = alpha;
        return this;
    }

    public DrawableMaster withPressedColor(int pressedColor) {
        this.pressedColor = pressedColor;
        return this;
    }

    public DrawableMaster withDisableColor(int disableColor) {
        this.disableColor = disableColor;
        return this;
    }


    public Drawable createSimple() {
        return createNormalDrawable();
    }

    public Drawable createBtn() {

        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawableNormal = createNormalDrawable();
        Drawable drawablePressed = createPressedDrawable();
        Drawable drawableDisable = createDisableDrawable();

        stateListDrawable.addState(new int[]{-android.R.attr.state_pressed, android.R.attr.state_enabled},drawableNormal);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled},drawablePressed);
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled},drawableDisable);

        return stateListDrawable;
    }

    private Drawable createNormalDrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(shape);
        drawable.setColors(new int[]{startColor, mediumColor, endColor});
        drawable.setCornerRadius(roundRadius);
        drawable.setStroke(strokeWidth,strokeColor);
        drawable.setOrientation(gradientOrientation);
        drawable.setAlpha(alpha);
        return drawable;
    }
    private Drawable createPressedDrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(shape);
        drawable.setColor(pressedColor);
        drawable.setCornerRadius(roundRadius);
        drawable.setStroke(strokeWidth,strokeColor);
        drawable.setOrientation(gradientOrientation);
        return drawable;
    }
    private Drawable createDisableDrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(shape);
        drawable.setColors(new int[]{startColor, mediumColor, endColor});
        drawable.setCornerRadius(roundRadius);
        drawable.setStroke(strokeWidth,strokeColor);
        drawable.setOrientation(gradientOrientation);
        drawable.setAlpha(100);
        return drawable;
    }

}
