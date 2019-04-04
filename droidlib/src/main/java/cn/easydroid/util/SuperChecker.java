package cn.easydroid.util;

import android.support.annotation.NonNull;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SuperChecker {

    private static String N_A = "N/A";

    public static boolean checkEmpty(Object obj) {
        return obj == null;
    }

    public static boolean checkEmptyColloction(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean checkEmptyArray(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean checkEmptyString(String str) {
        return str == null || "".equals(str) || str.trim().isEmpty();
    }


    public static boolean checkNotValidValue(String string) {
        return checkEmptyOrNull(string) || string.equals(N_A);
    }

    public static boolean checkEmptyOrNull(String string) {
        if (string == null
                || string.length() == 0
                || string.equalsIgnoreCase("null")) {
            return true;
        }
        String trim = string.trim();
        return trim.length() == 0;
    }

    public static boolean checkPhoneNumber(@NonNull String mobiles) {
        Pattern p = Pattern.compile("^[1][2,3,4,5,6,7,8,9][0-9]{9}$");
        Matcher m = p.matcher(mobiles);
        boolean b = m.matches();
        return b;
    }

    public static boolean checkReference(Reference reference) {
        if (reference == null) {
            return false;
        }
        if (reference.get() == null) {
            return false;
        }
        return true;
    }

    public static boolean checkEmail(String email) {
        if (null == email || email.isEmpty()) {
            return false;
        }
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(checkEmail("abd@dd.com"));
        System.out.println(checkEmail("adsafdd.com"));
        System.out.println(checkEmail("asd-fd@1.com"));
        System.out.println(checkEmail("abd+Abdd@fdc.om"));
    }
}
