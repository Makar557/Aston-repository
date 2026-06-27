package org.Dubrovsky.Aston.Homework.third.CoR;

public class Car {

    private boolean engineOk;
    private boolean brakesOk;
    private boolean documentsOk;

    public Car(boolean engineOk, boolean brakesOk, boolean documentsOk) {
        this.engineOk = engineOk;
        this.brakesOk = brakesOk;
        this.documentsOk = documentsOk;
    }

    public boolean isEngineOk() {
        return engineOk;
    }

    public boolean isBrakesOk() {
        return brakesOk;
    }

    public boolean isDocumentsOk() {
        return documentsOk;
    }
}