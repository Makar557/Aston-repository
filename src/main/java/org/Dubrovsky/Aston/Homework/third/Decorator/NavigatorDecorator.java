package org.Dubrovsky.Aston.Homework.third.Decorator;

public class NavigatorDecorator extends CarDecorator {

    public NavigatorDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + " + навигатор";
    }

    @Override
    public int getPrice() {
        return car.getPrice() + 20_000;
    }
}