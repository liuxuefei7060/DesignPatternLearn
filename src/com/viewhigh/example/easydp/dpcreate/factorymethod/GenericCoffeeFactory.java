package com.viewhigh.example.easydp.dpcreate.factorymethod;

/**
 * 泛型咖啡工厂
 */
public abstract class GenericCoffeeFactory {

    public abstract  <T> T createCoffee(Class<T> tClass);
}
