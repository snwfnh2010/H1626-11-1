package Test;


import java.io.DataInputStream;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by snwfnh on 2016/8/26.
 */
public class Test25 {
    public static void main(String[] args) {
         Date now=new Date();
         SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String string=simpleDateFormat.format(now);
        System.out.println(string);
        System.out.println("************");
        Timestamp timestamp=Timestamp.valueOf(string);
        long l=timestamp.getTime()+20*24*60*60*1000;

        timestamp.setTime(l);

        System.out.println( timestamp);
    }
}
