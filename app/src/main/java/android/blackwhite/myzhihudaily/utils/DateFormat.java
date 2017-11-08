package android.blackwhite.myzhihudaily.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by awzy1 on 2017/9/17.
 */

public class DateFormat {
    public static String format(String dateString) {
        String formatDate;
        //获得今天的日期
        String todayDate = new SimpleDateFormat("yyyyMMdd").format(new Date());

        if (dateString.equals(todayDate)) {
            formatDate = "今日新闻";
        } else {
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyyMMdd").parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            formatDate = new SimpleDateFormat("MM月dd日 EEEE").format(date);
        }

        return formatDate;
    }
}
