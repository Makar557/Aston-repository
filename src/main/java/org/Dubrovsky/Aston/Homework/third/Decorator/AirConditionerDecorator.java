package org.Dubrovsky.Aston.Homework.third.Decorator;

public class AirConditionerDecorator extends CarDecorator {

    public AirConditionerDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + " + кондиционер";
    }

    @Override
    public int getPrice() {
        return car.getPrice() + 50_000;
    }
}