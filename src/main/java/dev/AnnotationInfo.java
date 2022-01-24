package dev;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationInfo {

    public void printAnnotation(Class<?> clazz){
        MyAnnotation an = clazz.getAnnotation(MyAnnotation.class);
        if(an != null){
            int num = an.num();
            String name = an.name();
            System.out.println("num:"+num+",name:"+name);
        }
    }

    public void onCreate(){
        Class clazz = MyDataClass.class;

        printAnnotation(clazz);
        Method[] method = clazz.getMethods();
        for(Method m : method){
            printMethodInfo(m);
        }
        try{
            Method setMyInfoMethod = clazz.getMethod("setMyInfo", String.class);
            Object obj = clazz.newInstance();
            setMyInfoMethod.invoke(obj, "My Info");
        } catch(SecurityException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void printMethodInfo(Method m){
        if(m != null){
            String methodName = m.getName();
            MyAnnotation an = m.getAnnotation(MyAnnotation.class);
            if(an != null){
                int num = an.num();
                String name = an.name();
                System.out.println("method :" + methodName + "," + num + "," + name);
            }
        }
    }
}
