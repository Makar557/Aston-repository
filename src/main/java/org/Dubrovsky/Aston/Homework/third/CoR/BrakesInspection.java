package org.Dubrovsky.Aston.Homework.third.CoR;

public class BrakesInspection extends Inspection {

    @Override
    public void inspect(Car car) {

        if (!car.isBrakesOk()) {
            System.out.println("Тормоза неисправны");
            return;
        }

        System.out.println("Тормоза исправны");

        if (next != null) {
            next.inspect(car);
        }
    }
}