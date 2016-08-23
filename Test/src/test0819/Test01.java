package test0819;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by snwfnh on 2016/8/19.
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName("test0819.Employee");
       // Employee employee = (Employee) aClass.newInstance();
        Constructor<?> constructor = aClass.getConstructor(new Class[]{String.class,int.class});
        Employee employee1 = (Employee)constructor.newInstance(new Object[]{"张三",20});
        System.out.println(employee1);
        Method toString = aClass.getDeclaredMethod("toString", new Class[]{});
        System.out.println(toString.getName());

    }
}
