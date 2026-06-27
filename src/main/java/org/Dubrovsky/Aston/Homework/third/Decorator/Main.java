package org.Dubrovsky.Aston.Homework.third.Decorator;

public class Main {

    public static void main(String[] args) {

        Car car = new BasicCar();

        System.out.println(car.getDescription());
        System.out.println(car.getPrice());

        System.out.println();

        car = new AirConditionerDecorator(car);
        car = new NavigatorDecorator(car);

        System.out.println(car.getDescription());
        System.out.println(car.getPrice());
    }
}