package org.Dubrovsky.AstonHomework.secondTask;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class StreamTask {

    public void resultOfFourthTask(List<Student> students) {
        students.stream()
                .peek(student -> System.out.println(student.toString()))
                .map(Student::getListOfBooks)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(Book::getNumberOfPages))
                .distinct()
                .filter(book -> book.getDate().getYear() > 2000)
                .limit(3)
                .map(book -> book.getDate().getYear())
                .findFirst()
                .ifPresentOrElse(dateOfBook -> System.out.printf("Год издания: %d", dateOfBook),
                        () -> System.out.println("Книга не найдена"));
    }
}