package com.kibong.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {
    public ContainerService() {
    }

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach((field) -> {
            if (field.getAnnotation(Inject.class) != null) {
                Object o = createInstance(field.getType());
                field.setAccessible(true);

                try {
                    field.set(instance, o);
                } catch (IllegalAccessException var4) {
                    throw new RuntimeException(var4);
                }
            }

        });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor((Class)null).newInstance();
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | InstantiationException var2) {
            throw new RuntimeException(var2);
        }
    }
}
