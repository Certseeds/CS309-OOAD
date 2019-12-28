package insides;// package cn.edu.sustech;

import insides.test.Inject;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class ContainerImpl implements Container {
    Map<Class<?>, Class<?>> map = new HashMap<>();
    
    public <T> void register(Class<T> serviceType) {
        boolean judgeNull = (serviceType == null);
        if (judgeNull) {
            throw new IllegalArgumentException();
        }
        boolean judgeCan = (Modifier.isAbstract(serviceType.getModifiers())) ||
                (Modifier.isInterface(serviceType.getModifiers())) ||
                (serviceType.getDeclaredConstructors().length > 1);
        if (judgeCan) {
            throw new IllegalArgumentException();
        }
        
        //Class<T> temp = serviceType.newInstance();
        map.put(serviceType, serviceType);
    }
    
    public <T> void register(Class<T> serviceType, Class<? extends T> implementationType) {
        /*boolean judge1 = (serviceType == null) ||
                (!Modifier.isInterface(serviceType.getModifiers()));
        boolean judge2 = (implementationType == null) ||
                (Modifier.isAbstract(implementationType.getModifiers())) ||
                (Modifier.isInterface(implementationType.getModifiers())) ||
                (implementationType.getDeclaredConstructors().length > 1);
        */
        
        boolean judgeNull = (serviceType == null) || (implementationType == null);
        if (judgeNull) {
            throw new IllegalArgumentException();
        }
        boolean judgeserviceType = !(Modifier.isInterface(serviceType.getModifiers()) ||
                Modifier.isAbstract(serviceType.getModifiers()));
        boolean judgeimPlementation = (Modifier.isAbstract(implementationType.getModifiers())) ||
                (Modifier.isInterface(implementationType.getModifiers())) ||
                (implementationType.getDeclaredConstructors().length > 1);
        //System.out.println(judgeserviceType);
        //System.out.println(judgeimPlementation);
        if (judgeserviceType || judgeimPlementation) {
            throw new IllegalArgumentException();
        }
        map.put(serviceType, implementationType);
    }
    
    public <T> T resolve(Class<T> serviceType) {
        //System.out.println("begin");
        //System.out.println("begin"+serviceType.getTypeName());
        boolean judgeNull = (serviceType == null);
        if (judgeNull) {
            throw new IllegalArgumentException();
        }
        boolean judge2 = !map.containsKey(serviceType);
        if (judge2) {
            throw new ServiceNotFoundException();
        }
        
        
        T willreturn = null;
        try {
            T[] temp1 = (T[]) map.get(serviceType).getConstructors();
            /*for (int i = 0; i < temp1.length; i++) {
                System.out.println(temp1[i]);
            }*/
            Object[] objects_array = new Object[map.get(serviceType).getConstructors()[0].getParameters().length];
            for (Constructor<?> con : map.get(serviceType).getConstructors()) {
                //System.out.println(con.getName());
                int count = 0;
                for (Parameter p : con.getParameters()) {
                    //System.out.println(" " + p.getType());
                    objects_array[count] = resolve(p.getType());
                    //System.out.println(objects_array[count]);
                    count++;
                    //System.out.println(count);
                }
            }
            willreturn = (T) map.get(serviceType).getDeclaredConstructors()[0].newInstance(objects_array);
            Field[] fields = serviceType.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                //System.out.println(fields[i].isAnnotationPresent(Inject.class));
                //for (int j = 0;j<fields[i].getAnnotations().length;j++){
                //    System.out.println(fields[i].getAnnotations()[j]);
                //}
                if (fields[i].isAnnotationPresent(Inject.class)) {
                    //System.out.println("additon");
                    // Object temp3 = resolve(fields[i].getType());
                    //System.out.println(temp3.toString());
                    fields[i].set(willreturn, resolve(fields[i].getType()));
                    //System.out.println("addition finish");
                }
            }
            //System.out.println("break?");
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
        return willreturn;
    }
}
