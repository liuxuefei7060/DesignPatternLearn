package com.viewhigh.example.easydp.dpcreate.factorymethod;

public abstract class Coffee {

    public abstract String getName();

    /**
     * 加糖
     */
    public void addSugar() {
        System.out.println("Coffee  加糖");
    }

    /**
     * 加奶
     */
    public void addMilk() {
        System.out.println("Coffee  加奶");
    }

}
