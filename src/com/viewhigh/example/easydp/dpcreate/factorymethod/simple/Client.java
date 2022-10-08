package com.viewhigh.example.easydp.dpcreate.factorymethod.simple;

import com.viewhigh.example.easydp.dpcreate.factorymethod.Coffee;
import com.viewhigh.example.easydp.dpcreate.factorymethod.CoffeeType;

public class Client {

    public static void main(String[] args) {

        Coffee coffee = SimpleCoffeeFactory.createCoffee(CoffeeType.AMERICANO);

        System.out.println("-------------");
        System.out.println(coffee.getName());


        Coffee coffee2 = SimpleCoffeeFactory.createCoffee(CoffeeType.LATTE);

        System.out.println("-------------");
        System.out.println(coffee2.getName());

    }

}
