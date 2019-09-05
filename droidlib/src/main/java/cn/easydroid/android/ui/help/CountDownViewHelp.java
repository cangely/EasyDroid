package cn.easydroid.android.ui.help;

import android.widget.TextView;

import cn.easydroid.util.common.DateUtil;


/**
 * Create Date: 6/12/2019
 * Author: Yang Du
 * Description:
 */
public class CountDownViewHelp {
    private long remainSecond;
    private TextView tvCountDownDay;
    private TextView tvCountDownHour;
    private TextView tvCountDownMinute;
    private TextView tvCountDownSecond;

    private TextView tvSingleTextView;

    private String prefix = "";

    public CountDownViewHelp(TextView tvSingleTextView) {
        this.tvSingleTextView = tvSingleTextView;
    }

    public CountDownViewHelp(TextView tvCountDownDay, TextView tvCountDownHour, TextView tvCountDownMinute, TextView tvCountDownSecond) {
        this.tvCountDownDay = tvCountDownDay;
        this.tvCountDownHour = tvCountDownHour;
        this.tvCountDownMinute = tvCountDownMinute;
        this.tvCountDownSecond = tvCountDownSecond;
    }

    private void refreshUI(long remainSecond) {
        if (remainSecond <= 0) {
            TextViewHelper.setText(tvCountDownDay, prefix+"0天");
            TextViewHelper.setText(tvCountDownHour, "00");
            TextViewHelper.setText(tvCountDownMinute, "00");
            TextViewHelper.setText(tvCountDownSecond, "00");
            return;
        }
        long millis = remainSecond * 1000;
        long day = DateUtil.toDays(millis);
        long hour = DateUtil.toHours(millis - day * DateUtil.ONE_DAY_MILLI_SECONDS);
        long minute = (millis/1000 % 3600 / 60);
        long second = millis / 1000 % 60;
        TextViewHelper.setText(tvCountDownDay, day+"天");
        String hourStr = hour < 10 ? "0" + hour : "" + hour;
        String minStr = minute < 10 ? "0" + minute : "" + minute;
        String secondStr = second < 10 ? "0" + second : "" + second;
        TextViewHelper.setText(tvCountDownHour, hourStr);
        TextViewHelper.setText(tvCountDownMinute, minStr);
        TextViewHelper.setText(tvCountDownSecond, secondStr);

        StringBuilder singleTimeBuilder = new StringBuilder();
        singleTimeBuilder
                .append(prefix).append(" ")
                .append(day).append("天").append(" ")
                .append(hourStr).
                append(":").append(minStr)
                .append(":").append(secondStr)
        ;

        TextViewHelper.setText(tvSingleTextView, singleTimeBuilder.toString());


    }

    private void refreshUI(long remainSecond,boolean enableDayUnit) {
        if (enableDayUnit) {
            refreshUI(remainSecond);
            return;
        }
        if (remainSecond <= 0) {
            TextViewHelper.setText(tvCountDownDay, "0天");
            TextViewHelper.setText(tvCountDownHour, "00");
            TextViewHelper.setText(tvCountDownMinute, "00");
            TextViewHelper.setText(tvCountDownSecond, "00");
            return;
        }
        long millis = remainSecond * 1000;
        long day = DateUtil.toDays(millis);
        long hour = DateUtil.toHours(millis);
        long minute = (millis/1000 % 3600 / 60);
        long second = millis / 1000 % 60;
        TextViewHelper.setText(tvCountDownDay, day+"天");
        String hourStr = hour < 10 ? "0" + hour : "" + hour;
        String minStr = minute < 10 ? "0" + minute : "" + minute;
        String secondStr = second < 10 ? "0" + second : "" + second;
        TextViewHelper.setText(tvCountDownHour, hourStr);
        TextViewHelper.setText(tvCountDownMinute, minStr);
        TextViewHelper.setText(tvCountDownSecond, secondStr);

        StringBuilder singleTimeBuilder = new StringBuilder();
        singleTimeBuilder
                .append(prefix).append(" ")
                .append(hourStr).append(":")
                .append(minStr).append(":")
                .append(secondStr);

        TextViewHelper.setText(tvSingleTextView, singleTimeBuilder.toString());
    }

    public long getRemainSecond() {
        return remainSecond;
    }

    public void setRemainSecond(long remainSecond) {
        this.remainSecond = remainSecond;
        refreshUI(remainSecond,true);
    }
    public void setRemainSecond(long remainSecond,boolean enableDayUnit) {
        this.remainSecond = remainSecond;
        refreshUI(remainSecond,enableDayUnit);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
