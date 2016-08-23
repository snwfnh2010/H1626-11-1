package test0821;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class IOStream {
    public static void main(String[] args)  {
        FileWriter fw=null;


        try {
            fw=new FileWriter("Test\\src\\test0821\\a.txt");
            fw.write("sa dsf dsf gdf gdf g");
            fw.flush();
            fw.write("\nadfs adsfsaf sa fsa g g gg g g g ");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
