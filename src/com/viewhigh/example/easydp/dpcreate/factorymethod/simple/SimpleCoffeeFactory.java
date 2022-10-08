package com.viewhigh.example.easydp.dpcreate.factorymethod.simple;


import com.viewhigh.example.easydp.dpcreate.factorymethod.AmericanoCoffee;
import com.viewhigh.example.easydp.dpcreate.factorymethod.Coffee;
import com.viewhigh.example.easydp.dpcreate.factorymethod.CoffeeType;
import com.viewhigh.example.easydp.dpcreate.factorymethod.LatteCoffee;

/**
 * 简单咖啡工厂
 */
public class SimpleCoffeeFactory {

    public static Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case AMERICANO:
                return new AmericanoCoffee();
            case LATTE:
                return new LatteCoffee();
            default:
                System.out.printf("类型错误，请核对");
                return null;
        }
    }

}
