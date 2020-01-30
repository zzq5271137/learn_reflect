package com.mycomp.reflect;

public class Person {
    public String name;
    public Integer age;
    private String gender;

    public Person() {
        super();
    }

    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("姓名: " + this.name + ", 年龄: " + this.age + ", 性别: "
                + this.gender);
    }

    private String myStr(String date) {
        return "Hello " + name + ", today is " + date;
    }

}
