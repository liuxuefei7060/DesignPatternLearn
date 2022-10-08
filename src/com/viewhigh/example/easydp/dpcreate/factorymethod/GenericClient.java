package com.viewhigh.example.easydp.dpcreate.factorymethod;

public class GenericClient {
    public static void main(String[] args) {

        GenericCoffeeFactory factory = new ConcreteGenericCoffeeFactory();
        Coffee coffee = factory.createCoffee(AmericanoCoffee.class);

        System.out.println(coffee.getName());

    }
}
