package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Admin on 29.05.2018.
 */
public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods someInterfaceWithMethods;
    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods){
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object ghg = (String) method.invoke(someInterfaceWithMethods, args);
        System.out.println(method.getName() + " out");

        return ghg;
    }
}
