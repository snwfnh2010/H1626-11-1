package test0823;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by snwfnh on 2016/8/24.
 */
public class TestDate {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();

       String str= calendar.get(calendar.YEAR)+"-"+
               (calendar.get(calendar.MONTH)+1) +"-"+
               calendar.get(calendar.DATE);
        System.out.println(str);
    }
}
