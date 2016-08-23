package test0819;

/**
 * Created by snwfnh on 2016/8/19.
 */
public class ClassDemo {
    public static void main(String[] args) {
        Employee employee=new Employee("zhangsan",30);
      /*  Class<? extends Employee> aClass = employee.getClass();
        System.out.println(aClass.getName());
        System.out.println(aClass.getSuperclass().getName());
        System.out.println("*********************");
        Class<Employee> employeeClass = Employee.class;
        System.out.println(employeeClass.getName());
        System.out.println(employeeClass.getSuperclass().getName());
        System.out.println("*********************");
        try {
            Class<?> aClass1 = Class.forName("test0819.Employee");
            System.out.println( aClass1.getName());
            System.out.println( aClass1.getSuperclass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        Class<Integer> integerClass = int.class;
        System.out.println( integerClass .getName());
        Class<Double> type = Double.TYPE;
        System.out.println(type.getName());



    }
}
