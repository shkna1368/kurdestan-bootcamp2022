package saone;

import java.lang.reflect.*;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c=Class.forName("saone.Dog");

        System.out.println(c.getName());
        System.out.println(c.getConstructor());
        
        Dog d1=new Dog();

        Class obj=d1.getClass();

        String name= obj.getName();
        System.out.println("name:"+name);

        int modifier= obj.getModifiers();
        String mod= Modifier.toString(modifier);
        System.out.println("Modifier:"+mod);

        Class superCalss=obj.getSuperclass();
        System.out.println("SupperClass:"+superCalss.getName());

        Method[] methods=obj.getDeclaredMethods();

        for(Method m:methods){
            System.out.println("Method name:"+m.getName());

            int methodModifier=m.getModifiers();
            System.out.println("Method modifier:"+Modifier.toString(methodModifier));
            System.out.println("Return type:"+m.getReturnType());
            System.out.println("--------");

        }
        
  Field[] fields=obj.getDeclaredFields();

        for(Field field:fields){
            System.out.println("Field name:"+field.getName());

            int methodModifier=field.getModifiers();
            System.out.println("Field modifier:"+Modifier.toString(methodModifier));
            System.out.println("-----------");
        }

 Constructor[] constructors=obj.getConstructors();

        for(Constructor constructor:constructors){
            System.out.println("Constructor name:"+constructor.getName());

            int methodModifier=constructor.getModifiers();
            System.out.println("Constructor modifier:"+Modifier.toString(methodModifier));
            System.out.println("Constructor Parameters:"+constructor.getParameterCount());


            System.out.println("-----------");
        }


        Method m1=obj.getDeclaredMethod("display",null);
        m1.invoke(d1,null);


        Method m2=obj.getDeclaredMethod("makeSound",null);
       m2.setAccessible(true);
        m2.invoke(d1,null);


        Method m3=obj.getDeclaredMethod("print",String.class);
       m2.setAccessible(true);
        m3.invoke(d1,new Object[]{"Type"});




    }
}
