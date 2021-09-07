package com.lh.rpc.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 *
 */

public class ReflectionUtils {

    /**
     * 根据clazz创建对象
     *
     * @param clazz 待创建对象的类
     * @param <T> 对象的类型
     * @return 返回创建好的对象
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("create instance error");
        }
        return null;
    }

    /**
     * to get public class
     *
     * @param clazz clazz
     * @return return methods array
     */
    public static Method[] getPublicMethods(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        return Arrays.stream(methods).filter(o -> Modifier.isPublic(o.getModifiers())).toArray(Method[]::new);
    }


    /**
     * in one object to use the method which args is args
     * @param obj the method class
     * @param method the class method
     * @param args the method's args
     * @return return the method's return
     */
    public static Object invoke(Object obj, Method method, Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}