package org.Dubrovsky.Aston.Homework.third.CoR;

public class Main {

    public static void main(String[] args) {

        Car car = new Car(true, false, true);

        Inspection engine = new EngineInspection();
        Inspection brakes = new BrakesInspection();
        Inspection documents = new DocumentsInspection();

        engine.setNext(brakes);
        brakes.setNext(documents);

        engine.inspect(car);
    }
}