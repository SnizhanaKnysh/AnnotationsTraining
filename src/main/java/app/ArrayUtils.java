package app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodInfo {
    String methodName();
    String returnType();
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AuthorInfo {
    String firstName();
    String lastName();
}

public class ArrayUtils {

    String book1 = "Book 1";
    String book2 = "Book 2";

    @MethodInfo(methodName = "processData", returnType = "void", description = "this is a method to check annotations functionality")
    public void processData() {
        System.out.println(book1);
        System.out.println(book2);
    }

    @AuthorInfo(firstName = "Snizhana", lastName = "Knysh")
    public void checkAnnotationForAuthor() {
        System.out.println("Printing some dummy values :)");
    }

}
