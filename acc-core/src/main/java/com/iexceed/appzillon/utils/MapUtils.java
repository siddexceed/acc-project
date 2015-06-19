/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iexceed.appzillon.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class MapUtils {

    public static Map<String, String> convertObjectToMap(Object p_object) throws
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {
        Class<?> l_pomclass = p_object.getClass();
        l_pomclass = p_object.getClass();
       // System.out.println("l_pomclass::" + l_pomclass);
        Method[] methods = p_object.getClass().getMethods();
       // System.out.println("Methods::" + methods);

        Map<String, String> map = new HashMap<String, String>();
        for (Method m : methods) {
            if (m.getName().startsWith("get") && !m.getName().startsWith("getClass")) {
               // System.out.println("Method Name::" + m.getName());
               // System.out.println("Invoke::" + m.invoke(p_object));
                if (m.invoke(p_object) != null) {
                    Object value = (Object) m.invoke(p_object);
                    map.put(m.getName().substring(3), value.toString());
                }
            }
        }
        return map;
    }
    
   
}
