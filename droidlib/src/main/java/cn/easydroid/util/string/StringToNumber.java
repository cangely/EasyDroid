package cn.easydroid.util.string;

import cn.easydroid.util.SuperChecker;

/**
 * Create Date: 3/1/2019
 * Author: Yang Du
 * Description: 字符串与数字的转换工具类
 */
public class StringToNumber {
    /**
     * Convert String to Int
     * @param string expect a number,but can be null or empty(return 0).
     * @return number of string
     */
    public static int toInt(String string) {
        int value = 0;
        if (SuperChecker.checkEmptyString(string)) {
            return 0;
        }
        try {
            value = Integer.valueOf(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    /**
     * Convert String to Long
     * @param string expect a number,but can be null or empty(return 0).
     * @return number of string
     */
    public static long toLong(String string) {
        long value = 0;
        if (SuperChecker.checkEmptyString(string)) {
            return 0;
        }
        try {
            value = Long.valueOf(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Convert String to Float
     * @param string expect a number,but can be null or empty(return 0).
     * @return number of string
     */
    public static float toFloat(String string) {
        float value = 0;
        if (SuperChecker.checkEmptyString(string)) {
            return 0.0f;
        }
        try {
            value = Float.valueOf(string);
        } catch (Exception e) {
            e.printStackTrace();
            value = Float.MAX_VALUE;
        }
        return value;
    }
    /**
     * Convert String to Float
     * @param string expect a number,but can be null or empty(return 0).
     * @return number of string
     */
    public static double toDouble(String string) {
        double value = 0;
        if (SuperChecker.checkEmptyString(string)) {
            return 0.0f;
        }
        try {
            value = Double.valueOf(string);
        } catch (Exception e) {
            value = Double.MAX_VALUE;
        }
        return value;
    }

    /**
     *
     * @param progress [0,100]
     * @return e.g 95%
     */
    public static String getPercentage(int progress) {
        int value = 0;
        if (progress >= 0 && progress <= 100) {
            value = progress;
        }
        return value + "%";
    }


}
