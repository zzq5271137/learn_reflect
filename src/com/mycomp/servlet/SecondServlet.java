package com.mycomp.servlet;

public class SecondServlet implements IServlet {

    @Override
    public void init() {
        System.out.println("init second...");
    }

}
