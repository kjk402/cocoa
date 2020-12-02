package PersonalProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH)+1;
        int day = cal.get(cal.DATE);

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        String y = String.valueOf(year);
        String m = String.valueOf(month);
        String d = String.valueOf(day);
        System.out.println(y+m+d);

        SimpleDateFormat Format = new SimpleDateFormat("yyyyMMdd");
        Date time = new Date();
        String today = Format.format(time).toString();
        cal.add(Calendar.DATE, -1);
        String yesterday = Format.format(cal.getTime());
        System.out.println(today);
        System.out.println(yesterday);

    }
}
