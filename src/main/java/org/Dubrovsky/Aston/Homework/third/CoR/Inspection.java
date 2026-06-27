package org.Dubrovsky.Aston.Homework.third.CoR;

public abstract class Inspection {

    protected Inspection next;

    public void setNext(Inspection next) {
        this.next = next;
    }

    public abstract void inspect(Car car);
}