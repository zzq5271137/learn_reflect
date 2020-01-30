package com.mycomp.servlet;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 模拟Servlet加载和运行方式
 */

public class ParseServlet {
    public static void main(String[] args) throws DocumentException,
            ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, SecurityException,
            IllegalArgumentException, InvocationTargetException {
        // 模拟用户访问了 /first
        String path = "/first";

        /*
         * 1. 加载并解析 web.xml
         */
        SAXReader reader = new SAXReader();
        Document doc = reader.read("src/web.xml");
        Element rootElement = doc.getRootElement();

        String targetServletName = null;
        List<Element> servletMappingList = rootElement
                .elements("servlet-mapping");
        for (Element servletMappingElem : servletMappingList) {
            String urlPattern = servletMappingElem.elementText("url-pattern");
            if (urlPattern.equals(path)) {
                targetServletName = servletMappingElem
                        .elementText("servlet-name");
            }
        }

        String targetServletClass = null;
        List<Element> servletList = rootElement.elements("servlet");
        for (Element servletElem : servletList) {
            String servletName = servletElem.elementText("servlet-name");
            if (servletName.equals(targetServletName)) {
                targetServletClass = servletElem.elementText("servlet-class");

            }
        }

        /*
         * 2. 根据解析结果创建字节码
         */
        Class<?> clazz = Class.forName(targetServletClass);
        Object obj = clazz.newInstance();
        Method initMethod = clazz.getMethod("init"); // 这个init方法名称,我们提前应该是知道的,因为遵守了规范
        initMethod.invoke(obj);
    }
}
