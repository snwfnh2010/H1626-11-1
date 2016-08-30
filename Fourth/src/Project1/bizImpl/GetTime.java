package Project1.bizImpl;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by snwfnh on 2016/8/26.
 */
public class GetTime {
    Date date1=new Date();
    Date date2=new Date();
    DateFormat d1=DateFormat.getDateInstance();

    private static GetTime ourInstance = new GetTime();

    public static GetTime getInstance() {
        return ourInstance;
    }

    private GetTime() {
    }

    public String getCurrTime(){
        String now=d1.format(date1);
        return now;
    }

    public String getAfterTime(){
        long l=date2.getTime()+20*24*60*60*1000;
        date2.setTime(l);
        String after=d1.format(date2);
        return after;
    }
}
