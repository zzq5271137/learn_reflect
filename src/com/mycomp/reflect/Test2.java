package com.mycomp.reflect;

import java.lang.reflect.Field;

/*
 * 1. 通过反射获取public字段
 * 2. 通过反射获取private字段
 */

public class Test2 {
    public static void main(String[] args) throws NoSuchFieldException,
            SecurityException, IllegalArgumentException,
            IllegalAccessException, InstantiationException {
        Class<?> clazz = Person.class;
        Person person = (Person) clazz.newInstance();
        person.name = "乔鲁诺";
        person.age = 20;
        person.show();
        System.out.println();

        // 通过字节码获取public字段
        Field nameField = clazz.getField("name");
        nameField.set(person, "乔瑟夫");
        Field ageField = clazz.getField("age");
        ageField.set(person, 27);
        person.show();
        System.out.println();

        // 通过字节码获取private字段 (暴力反射)
        Field genderField = clazz.getDeclaredField("gender");
        genderField.setAccessible(true); // 去除私有权限
        genderField.set(person, "男");
        person.show();
        System.out.println();
    }
}
