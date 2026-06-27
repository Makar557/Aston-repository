package org.Dubrovsky.Aston.Homework.third.CoR;

public class DocumentsInspection extends Inspection {

    @Override
    public void inspect(Car car) {

        if (!car.isDocumentsOk()) {
            System.out.println("Документы отсутствуют");
            return;
        }

        System.out.println("Документы проверены");
        System.out.println("Автомобиль готов к продаже");
    }
}