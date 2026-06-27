package org.Dubrovsky.Aston.Homework.third.Decorator;

public class BasicCar implements Car {

    @Override
    public String getDescription() {
        return "Автомобиль";
    }

    @Override
    public int getPrice() {
        return 1000000;
    }
}