package org.Dubrovsky.Aston.Homework.third.Decorator;

public abstract class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }
}