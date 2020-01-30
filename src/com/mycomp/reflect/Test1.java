package com.mycomp.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 1. 获取字节码的三种方式
 * 2. 通过字节码创建对象的两种方式
 */

public class Test1 {
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, SecurityException,
            IllegalArgumentException, InvocationTargetException {

        /*
         * 获取字节码
         */
        Class<?> clazz1 = Class.forName("com.mycomp.reflect.Person");

        Class<?> clazz2 = Person.class;

        Person person = new Person();
        Class<?> clazz3 = person.getClass();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        /*
         * 创建对象
         */
        Person person1 = (Person) clazz1.newInstance();
        person1.name = "迪奥";
        person1.age = 130;
        person1.show();

        Constructor<?> constructor = clazz1.getConstructor(String.class,
                Integer.class);
        Person person2 = (Person) constructor.newInstance("乔瑟夫", 27);
        person2.show();
    }
}
