package Practice.Task5;

import java.lang.reflect.Method;

public class DeprecationHandler {
    public static void inspectClass(Class<?> clazz) {
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.printf("Внимание: класс '%s' устарел. Альтернатива: '%s'%n",
                    clazz.getSimpleName(), annotation.message());
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.printf("Внимание: метод '%s' устарел. Альтернатива: '%s'%n",
                        method.getName(), annotation.message());
            }
        }
    }
}