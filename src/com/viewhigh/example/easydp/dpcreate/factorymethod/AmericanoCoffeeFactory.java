package com.viewhigh.example.easydp.dpcreate.factorymethod;

/**
 * 美式咖啡工厂
 */
public class AmericanoCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanoCoffee();
    }
}
