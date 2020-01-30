package com.mycomp.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 1. 通过反射获取public方法
 * 2. 通过反射获取private方法
 */

public class Test3 {
    public static void main(String[] args) throws NoSuchMethodException,
            SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Class<?> clazz = Person.class;
        Constructor<?> constructor = clazz.getConstructor(String.class,
                Integer.class);
        Person person = (Person) constructor.newInstance("乔瑟夫", 27);

        // 通过字节码获取public方法
        Method showMethod = clazz.getMethod("show");
        System.out.println(showMethod.getName());
        showMethod.invoke(person);

        // 通过字节码获取private方法
        Method myStrMethod = clazz.getDeclaredMethod("myStr", String.class);
        myStrMethod.setAccessible(true);
        System.out.println(myStrMethod);
        System.out.println(myStrMethod.invoke(person, "sunday"));
    }
}
