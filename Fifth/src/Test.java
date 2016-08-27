import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;

public class Test
{
    Date now;
    SimpleDateFormat h;

    public Test()
    {
        now = new Date();
        //h = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //hh是以12制//HH是以24制
        h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String n = h.format(now);
        System.out.println ("第一种方式："+n);
        System.out.println ("=========================");

        String myString = DateFormat.getDateInstance().format(now);
        System.out.println ("第二种方式:"+myString);
        System.out.println("==========================");

        Timestamp time = Timestamp.valueOf(n);
        System.out.println("今天是星期："+time.getDay());
        System.out.println("==========================");

        //在天数上加14天
        long l = time.getTime()+24*60*60*20*1000;
        time.setTime(l);
        System.out.println("14天后的日期："+time);
    }
    public static void main(String args[])
    {
        new Test();
    }
}