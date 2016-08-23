package test0821;

import java.io.File;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class FileDelete {
    public static void deleteALL(File file){
        File[] files = file.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].isDirectory()){
                deleteALL(files[i]);
            }else {
                files[i].delete();
            }
        }
       file.delete();
    }
}
