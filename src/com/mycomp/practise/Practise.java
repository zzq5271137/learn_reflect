package com.mycomp.practise;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mycomp.reflect.Person;

public class Practise {
    public static void main(String[] args) throws NoSuchMethodException,
            SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class<?> clazz = Person.class;
        Constructor<?> constructor = clazz.getConstructor(String.class,
                Integer.class);
        Person person = (Person) constructor.newInstance("乔瑟夫", 20);
        Method showMethod = clazz.getMethod("show");
        showMethod.invoke(person);
        
        Field nameField = clazz.getField("name");
        nameField.set(person, "迪奥");
        Field ageField = clazz.getField("age");
        ageField.set(person, 200);
        Field genderField = clazz.getDeclaredField("gender");
        genderField.setAccessible(true);
        genderField.set(person, "男");
        
        showMethod.invoke(person);
        
        Method myStr = clazz.getDeclaredMethod("myStr", String.class);
        myStr.setAccessible(true);
        System.out.println(myStr.invoke(person, "friday"));
        
    }
}
