package com.mycomp.servlet;

public class FirstServlet implements IServlet {

    @Override
    public void init() {
        System.out.println("init first...");
    }

}
