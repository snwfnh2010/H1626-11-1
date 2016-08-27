package Project1.bizImpl;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by snwfnh on 2016/8/26.
 */
public class GetTime {
    Date date=new Date();
    DateFormat d1=DateFormat.getDateInstance();

    private static GetTime ourInstance = new GetTime();

    public static GetTime getInstance() {
        return ourInstance;
    }

    private GetTime() {
    }

    public String getCurrTime(){
        String now=d1.format(date);
        return now;
    }

    public String getAfterTime(){
        long l=date.getTime()+20*24*60*60*1000;
        date.setTime(l);
        String after=d1.format(date);
        return after;
    }
}
