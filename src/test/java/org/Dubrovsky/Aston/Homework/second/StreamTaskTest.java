package testForSecondTask;

import org.Dubrovsky.AstonHomework.secondTask.Book;
import org.Dubrovsky.AstonHomework.secondTask.StreamTask;
import org.Dubrovsky.AstonHomework.secondTask.Student;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamTaskTest {

    @Test
    void shouldPrintYearWhenBookFound() {
        StreamTask streamTask = new StreamTask();

        Book book1 = new Book(100, "Java", "Author1",
                LocalDate.of(2021, 1, 1));
        Book book2 = new Book(200, "Spring", "Author2",
                LocalDate.of(2022, 1, 1));
        Book book3 = new Book(300, "Hibernate", "Author3",
                LocalDate.of(2023, 1, 1));
        Book book4 = new Book(400, "SQL", "Author4",
                LocalDate.of(1999, 1, 1));
        Book book5 = new Book(500, "Docker", "Author5",
                LocalDate.of(2024, 1, 1));

        Student student = new Student(
                "Ivan",
                List.of(book1, book2, book3, book4, book5)
        );

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        streamTask.resultOfFourthTask(List.of(student));

        String result = output.toString();

        assertTrue(result.contains("Год издания: 2021"));
    }

    @Test
    void shouldPrintBookNotFoundWhenNoBooksAfter2000() {
        StreamTask streamTask = new StreamTask();

        Book book1 = new Book(100, "Book1", "Author1",
                LocalDate.of(1990, 1, 1));
        Book book2 = new Book(200, "Book2", "Author2",
                LocalDate.of(1991, 1, 1));
        Book book3 = new Book(300, "Book3", "Author3",
                LocalDate.of(1992, 1, 1));
        Book book4 = new Book(400, "Book4", "Author4",
                LocalDate.of(1993, 1, 1));
        Book book5 = new Book(500, "Book5", "Author5",
                LocalDate.of(1994, 1, 1));

        Student student = new Student(
                "Ivan",
                List.of(book1, book2, book3, book4, book5)
        );

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        streamTask.resultOfFourthTask(List.of(student));

        String result = output.toString();

        assertTrue(result.contains("Книга не найдена"));
    }

    @Test
    void shouldThrowExceptionWhenStudentHasLessThanFiveBooks() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Student(
                        "Ivan",
                        List.of(
                                new Book(),
                                new Book(),
                                new Book(),
                                new Book()
                        )
                )
        );
    }
}