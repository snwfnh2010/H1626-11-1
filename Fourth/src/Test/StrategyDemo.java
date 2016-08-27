package Test;

/**
 * Created by snwfnh on 2016/7/29.
 */
public class StrategyDemo {
    public static void main(String[] args) {
        int[] array={1,23,44,11,3,45,6,46,22,};
        ISort bubbleSort=new BubbleSort();
        Context context=new Context(bubbleSort);
        context.sort(array);
        context.PrintArray(array);

        ISort selectSort=new SelectSort();
        Context context1=new Context(selectSort);
        context1.sort(array);
        context1.PrintArray(array);


    }
}

class Context{
    private ISort iSort=null;

    public Context(ISort iSort) {
        this.iSort = iSort;
    }
    public void sort(int[] array){
        iSort.sort(array);

    }
    public void PrintArray(int[] array){
        for (int i:array){
            System.out.print(i+"  ");
        }

    }
}

interface ISort{
    public void sort(int[] array);
}

class BubbleSort implements ISort{
    public void sort(int[] array){
        System.out.println("冒泡排序法");
        for(int i=0;i<array.length-1;i++){
            for (int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

}

class SelectSort implements ISort{
    public void sort(int[] array){
        System.out.println("\n选择排序法");
        int min=0;
        for(int i=0;i<array.length;i++){
            min=i;
            for(int j=i+1;j<array.length;j++){
                if(array[min]>array[j]){
                    min=j;
                }
            }
            if(i!=min){
                int temp=array[i];
                array[i]=array[min];
                array[min]=temp;
            }

        }
    }

}