package com.viewhigh.example.easydp.dbstructure.decoration;

abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation(){
        component.operation();
    }
}
