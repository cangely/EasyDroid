package cn.easydroid.util.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cn.easydroid.util.SuperChecker;

public final class DateUtil {

        /**
         *
         * @param millis
         * @return
         */
        public static String getDateWithYMDHMS(long millis){
            Date date = new Date(millis);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

            return sdf.format(date);
        }
        public static String getDateWithYMDHMS_CHN(long millis){
            Date date = new Date(millis);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss",Locale.getDefault());

            return sdf.format(date);
        }

        public static String getDateWithYMD(long millis){
            Date date = new Date(millis);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());

            return sdf.format(date);
        }
        public static String getDateWithYMD_CHN(long millis){
            Date date = new Date(millis);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日",Locale.getDefault());

            return sdf.format(date);
        }

        public static String getDateWithDHMS(long millis){
            Date date = new Date(millis);
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss",Locale.getDefault());

            return sdf.format(date);
        }
        public static String getDateWithDHMS_InCHN(long millis){
            Date date = new Date(millis);
            SimpleDateFormat sdf = new SimpleDateFormat("M月d日 HH:mm:ss",Locale.getDefault());

            return sdf.format(date);
        }

        /**
         * 计算已过去几个小时
         * @param lastDayWithYMDHMS "2018-08-08 18:04:01"
         * @return 1
         */
        public static int getPassedHours(String lastDayWithYMDHMS) {
            if (SuperChecker.checkEmptyOrNull(lastDayWithYMDHMS)) {
                return Integer.MAX_VALUE;
            }

            SimpleDateFormat format = getFormatStr(lastDayWithYMDHMS);
            try {
                Date date = format.parse(lastDayWithYMDHMS);
                long freshTime = System.currentTimeMillis() - date.getTime();
                int passedHours = (int) (freshTime / (3600 * 1000));
                return passedHours;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return 0;
        }
        public static int getPassedHours(String lastDayWithYMDHMS,String lastDay2WithYMDHMS) {
//            if (SuperChecker.checkEmptyOrNull(lastDayWithYMDHMS) || SuperChecker.checkEmptyOrNull(lastDay2WithYMDHMS)) {
//                return Integer.MAX_VALUE;
//            }
            SimpleDateFormat format1 = getFormatStr(lastDayWithYMDHMS);
            SimpleDateFormat format2 = getFormatStr(lastDay2WithYMDHMS);
            long time1 = 0;
            long time2 = 0;
            try {
                Date date = format1.parse(lastDayWithYMDHMS);
                time1 = date.getTime();
            } catch (Exception e) {
                System.out.println("Error param 1:"+e.getMessage());
            }

            try {
                Date date2 = format2.parse(lastDay2WithYMDHMS);
                time2 = date2.getTime();
            } catch (Exception e) {
                System.out.println("Error param 2:"+e.getMessage());
            }

            long freshTime = time2 - time1;
            int passedHours = (int) (freshTime / (3600 * 1000));
            return passedHours;
        }
        public static int getPassedSecconds(String lastDayWithYMDHMS,String lastDay2WithYMDHMS) {
//            if (SuperChecker.checkEmptyOrNull(lastDayWithYMDHMS) || SuperChecker.checkEmptyOrNull(lastDay2WithYMDHMS)) {
//                return Integer.MAX_VALUE;
//            }
            SimpleDateFormat format1 = getFormatStr(lastDayWithYMDHMS);
            SimpleDateFormat format2 = getFormatStr(lastDay2WithYMDHMS);

            long time1 = 0;
            long time2 = 0;
            try {
                Date date = format1.parse(lastDayWithYMDHMS);
                time1 = date.getTime();
            } catch (Exception e) {
                System.out.println("Error param 1:"+e.getMessage());
            }

            try {
                Date date2 = format2.parse(lastDay2WithYMDHMS);
                time2 = date2.getTime();
            } catch (Exception e) {
                System.out.println("Error param 2:"+e.getMessage());
            }

            long freshTime = time2 - time1;
            int passedHours = (int) (freshTime / (1000));
            return passedHours;
        }
        /**
         * 计算已过去几天
         * @param lastDayWithYMDHMS "2018-08-08 18:04:01"
         * @return 1
         */
        public static int getPassedDays(String lastDayWithYMDHMS) {
            SimpleDateFormat format = getFormatStr(lastDayWithYMDHMS);
            try {
                Date date = format.parse(lastDayWithYMDHMS);
                long freshTime = System.currentTimeMillis() - date.getTime();
                int freshDays = (int) (freshTime / (24 * 3600 * 1000));
                return freshDays;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }

        public static long getMillis(String ymdhms) {
            if (ymdhms == null) {
                ymdhms = "2019-01-01 16:09:01";
            }
            SimpleDateFormat format = getFormatStr(ymdhms);
            Date date = null;
            try {
                date = format.parse(ymdhms);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long time1 = date.getTime();
            return time1;
        }

        private static SimpleDateFormat getFormatStr(String targetString) {

            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
            if (targetString != null &&targetString.contains("年")) {
                format =  new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss",Locale.getDefault());
            }
            return format;
        }


        public static final long ONE_MINUTE_MILLI_SECONDS = 60000L;
        public static final long ONE_HOUR_MILLI_SECONDS = 3600000L;
        public static final long ONE_DAY_MILLI_SECONDS = 86400000L;
        public static final long ONE_WEEK_MILLI_SECONDS = 604800000L;

        private static final String ONE_SECOND_AGO = "秒前";
        private static final String ONE_MINUTE_AGO = "分钟前";
        private static final String ONE_HOUR_AGO = "小时前";
        private static final String ONE_DAY_AGO = "天前";
        private static final String ONE_MONTH_AGO = "月前";
        private static final String ONE_YEAR_AGO = "年前";

        public static String getPassedTime(String lastDayWithYMDHMS) {
            if (lastDayWithYMDHMS == null) {
                return "";
            }
            SimpleDateFormat simpleDateFormat = getFormatStr(lastDayWithYMDHMS);
            Date date = null;
            try {
                date = simpleDateFormat.parse(lastDayWithYMDHMS);
                return getPassedTime(date);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        private static String getPassedTime (Date date){
            if (date == null) {
                return "";
            }
            long delta = new Date().getTime() - date.getTime();
            if (delta < 1L * ONE_MINUTE_MILLI_SECONDS) {
                long seconds = toSeconds(delta);
                return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
            }
            if (delta < 45L * ONE_MINUTE_MILLI_SECONDS) {
                long minutes = toMinutes(delta);
                return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
            }
            if (delta < 24L * ONE_HOUR_MILLI_SECONDS) {
                long hours = toHours(delta);
                return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
            }
            if (delta < 48L * ONE_HOUR_MILLI_SECONDS) {
                return "昨天";
            }
            if (delta < 30L * ONE_DAY_MILLI_SECONDS) {
                long days = toDays(delta);
                return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
            }
            if (delta < 12L * 4L * ONE_WEEK_MILLI_SECONDS) {
                long months = toMonths(delta);
                return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
            } else {
                long years = toYears(delta);
                return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
            }
        }
        /**
         * 将秒数转换为天时分秒，
         * @param second
         * @return
         */
        public static String secondToDayTime(long second){
            long days = second / 86400;            //转换天数
            second = second % 86400;            //剩余秒数
            long hours = second / 3600;            //转换小时
            second = second % 3600;                //剩余秒数
            long minutes = second /60;            //转换分钟
            second = second % 60;                //剩余秒数
            if(days>0){
                return days + "天" + hours + "小时" + minutes + "分" + second + "秒";
            }else{
                return hours + "小时" + minutes + "分" + second + "秒";
            }
        }
        /**
         * 将秒数转换为HH:mm:ss，
         * @param second
         * @return
         */
        public static String secondToTime(long second){
            long hours = second / 3600;            //转换小时
            second = second % 3600;                //剩余秒数
            long minutes = second /60;            //转换分钟
            second = second % 60;                //剩余秒数

            String h = hours + "";
            if (hours < 10) {
                h = "0" + h;
            }
            String m = minutes + "";
            if (minutes < 10) {
                m = "0" + m;
            }

            String s = second + "";
            if (second < 10) {
                s = "0" + s;
            }
            return h + ":" + m + ":" + s ;
        }

        public static long toSeconds ( long date){
            return date / 1000L;
        }

        public static long toMinutes ( long date){
            return toSeconds(date) / 60L;
        }

        public static long toHours ( long date){
            return toMinutes(date) / 60L;
        }

        public static long toDays ( long date){
            return toHours(date) / 24L;
        }

        private static long toMonths ( long date){
            return toDays(date) / 30L;
        }

        private static long toYears ( long date){
            return toMonths(date) / 365L;
        }

        public static boolean isOneDay(Calendar calendarOne, Calendar calendarTwo) {
            if (calendarOne == null || calendarTwo == null) {
                throw new IllegalArgumentException("Parms may not be null");
            }
            return calendarOne.get(Calendar.YEAR) == calendarTwo.get(Calendar.YEAR)
                    && calendarOne.get(Calendar.DAY_OF_MONTH) == calendarTwo.get(Calendar.DAY_OF_MONTH)
                    && calendarOne.get(Calendar.MONTH) == calendarTwo.get(Calendar.MONTH);
        }
    }
