package com.viewhigh.example.easydp.dpcreate.factorymethod;

public class Client {

    public static void main(String[] args) {

        //美式咖啡工厂
        CoffeeFactory americanoFactory = new AmericanoCoffeeFactory();
        //拿铁工厂
        CoffeeFactory latteFactory = new LatteCoffeeFactory();

        Coffee coffee1 = americanoFactory.createCoffee();
        Coffee latte = latteFactory.createCoffee();

        System.out.println(coffee1.getName());
        System.out.println(latte.getName());

    }

}
