package test0820;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class Test01 {
    public static void main(String[] args) throws ParserConfigurationException{
        List<Phone> list=new ArrayList<>();
        Scanner in=new Scanner(System.in);
        boolean flag=true;
        try {
            File file=new File("F:"+File.separator+"a1.xml");
            file.createNewFile();
            String str="http://api.k780.com:88/?app=phone.get&phone=#&appkey=20688&sign=3a68c4fe44c3f5da374815b696e53fb8&format=xml";
           while (flag){

               System.out.println("请输入手机号：");
               String phone=in.next();


               str=str.replace("#",phone);
               URL url=new URL(str);
               InputStream is = url.openStream();

               OutputStream os=new FileOutputStream(file);
               byte[] bytes=new byte[1024];
               StringBuilder sb=new StringBuilder();
               int length=0;
               while (-1!=(length=is.read(bytes))){
                   os.write(bytes,0,length);
                   os.flush();
               }
               os.close();
               is.close();
               str=str.replace(phone,"#");
               try {
                   list=ParserTools.getInstance().pareXml(file);
               } catch (SAXException e) {
                   e.printStackTrace();
               }
               for(Phone p:list){
                   System.out.println(p);
               }
               System.out.println("选择继续或者退出：y/n");
               String ch=in.next();
               if (ch.equals("y")){
                   flag=true;
               }else if(ch.equals("n")){
                 flag=false;
               }
           }





        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
