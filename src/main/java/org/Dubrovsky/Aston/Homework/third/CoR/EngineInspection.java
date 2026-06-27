package org.Dubrovsky.Aston.Homework.third.CoR;

public class EngineInspection extends Inspection {

    @Override
    public void inspect(Car car) {

        if (!car.isEngineOk()) {
            System.out.println("Двигатель неисправен");
            return;
        }

        System.out.println("Двигатель исправен");

        if (next != null) {
            next.inspect(car);
        }
    }
}