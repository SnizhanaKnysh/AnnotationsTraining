package app;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args)
        throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        System.out.println("\n   Checking MethodInfo annotation");
        MethodInfo methodInfo = ArrayUtils.class.getDeclaredMethod("processData").getAnnotation(MethodInfo.class);

        System.out.println("methodInfo: " + methodInfo.methodName());
        System.out.println("methodInfo: " + methodInfo.returnType());
        System.out.println("methodInfo: " + methodInfo.description());

        System.out.println("\n   Get annotations via Reflection");

        Class<?> clazz = Class.forName("app.ArrayUtils");
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("\n  For Method: " + method.getName());
            Annotation[] annotations = method.getAnnotations();

            for (Annotation annotation : annotations) {
                System.out.println("Annotation: " + annotation.annotationType().getName());
                Method[] annotationMethods = annotation.annotationType().getDeclaredMethods();

                for (Method annotationMethod : annotationMethods) {
                    Object value = annotationMethod.invoke(annotation);
                    System.out.println("Field: " + annotationMethod.getName() + ", Value: " + value);

                }
            }

        }

    }

}
