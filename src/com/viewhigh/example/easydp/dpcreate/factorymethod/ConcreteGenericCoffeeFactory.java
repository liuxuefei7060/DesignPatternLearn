package com.viewhigh.example.easydp.dpcreate.factorymethod;

/**
 * 具体泛型工厂
 */
public class ConcreteGenericCoffeeFactory extends GenericCoffeeFactory {
    @Override
    public <T> T createCoffee(Class<T> tClass) {
        Coffee coffee = null;
        try {
            coffee = (Coffee) tClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (T) coffee;
    }
}
