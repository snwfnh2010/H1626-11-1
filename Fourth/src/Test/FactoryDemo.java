package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class FactoryDemo {
    public static void main(String[] args) {

        IFruit fruit=Factory.getFruit("橘");
        if(fruit!=null){
            System.out.println(fruit.get());
        }else {
            System.out.println("sorry");
        }

    }
}
interface IFruit{
    public String get();
}
class Factory{
    public static IFruit getFruit(String name){
        if(name.equals("苹果")){
            return new Apple();
        }else if(name.equals("橘子")){
            return new Orange();
        }else {
            return null;
        }

    }

}class Apple implements IFruit{
    public String get(){
        return "采摘苹果";
    }
}
class Orange implements IFruit{
    public String get(){
        return "采摘橘子";
    }
}
