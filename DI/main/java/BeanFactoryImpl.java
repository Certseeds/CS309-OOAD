package main.java;

import java.io.File;

public class BeanFactoryImpl implements BeanFactory{
    @Override
    public void loadInjectProperties(File file) {

    }

    @Override
    public void loadValueProperties(File file) {

    }

    @Override
    public <T> T createInstance(Class<T> clazz) {
        return null;
    }
}
