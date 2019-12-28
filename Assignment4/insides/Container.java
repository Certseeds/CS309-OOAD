package insides;

import java.lang.reflect.InvocationTargetException;

public interface Container {
    <T> void register(Class<T> serviceType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
    <T> void register(Class<T> serviceType, Class<? extends T> implementationType);
    <T> T resolve(Class<T> serviceType);
}
