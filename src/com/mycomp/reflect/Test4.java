package com.mycomp.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 * 通过反射绕过集合泛型检测
 */

public class Test4 {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        // list.add("zzq");

        Class<?> clazz = Class.forName("java.util.ArrayList");
        Method addMethod = clazz.getMethod("add", Object.class);
        addMethod.invoke(list, "zzq");
        
        System.out.println(list);
    }
}
