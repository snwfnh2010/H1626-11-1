package Test;

import java.util.Arrays;

/**
 * Created by snwfnh on 2016/7/31.
 */
public class EntryDemo {
    public static void main(String[] args) {
        MyContainer myContainer=new MyContainer();
        myContainer.put("jack","陈豪");
        myContainer.put("jay","周杰伦");
        myContainer.put("jack","成龙");
        myContainer.put("rose","玫瑰");
        myContainer.put("john","小明");
        myContainer.put("jack","陈豪");
        MyContainer.Entry[] entrys=myContainer.entryArray();
        for (int i=0;i<entrys.length;i++){
            MyContainer.Entry entry=entrys[i];
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }

    }
}

class MyContainer{
    private Entry[] entrys=new Entry[5];
    private int count=0;
    public void put(String key,String value){
        Entry entry=new Entry();
        entry.setKey(key);
        entry.setValue(value);
        entrys[count++]=entry;
        if(count>=entrys.length){
            int newCapcity=entrys.length*2;
            entrys=Arrays.copyOf(entrys,newCapcity);
        }

    }

    public Entry[] entryArray(){
        return Arrays.copyOfRange(entrys,0,count);
    }

    public static class Entry{
        private String key;
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
