package com.viewhigh.example.easydp.dbstructure.decoration;

class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    private void operationFirst() {
        System.out.println("operationFirst say");
    }

    private void operationLast() {
        System.out.println("operationLast say");
    }

    public void operation() {
        operationFirst();
        super.operation();
        operationLast();
    }

    //新功能
    public void anotherOperation() {
        System.out.println("another operation");
    }
}