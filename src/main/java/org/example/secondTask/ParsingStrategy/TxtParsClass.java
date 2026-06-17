package org.example.secondTask.ParsingStrategy;

import org.example.secondTask.Book;
import org.example.secondTask.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TxtParsClass implements StrategyOfParsing {


    @Override
    public List<Student> getStudentFromFile(File file) throws IOException{

        return buildStudents(Files.readAllLines(file.toPath()));
    }

    private List<Student> buildStudents(List<String> lines) {

        List<Student> rezStudents = new ArrayList<>();

        String tempStudent = null;

        List<Book> tempBooks = new ArrayList<>();

        for (String str : lines){

            String[] strings = str.split(":");

            if (strings[0].equals("STUDENT")) {

                if(tempStudent != null){
                    addStudentIfValid(rezStudents, tempStudent, tempBooks);
                }

                tempBooks = new ArrayList<>();

                tempStudent = strings[1].trim();

            } else if (strings[0].equals("BOOK")) {
                tempBooks.add(parseBook(strings[1]));
            }

        }

        addStudentIfValid(rezStudents, tempStudent, tempBooks);

        return rezStudents;
    }

    private void addStudentIfValid(List<Student> students, String studentName, List<Book> books) {
        try {
            students.add(new Student(studentName, books));
        } catch (IllegalArgumentException e) {
            System.out.printf(
                    "The student with the name %s had less than 5 books and was therefore not added%n", studentName
            );
        }
    }

    private Book parseBook(String book) {

        String[] stringsBooks = book.split("\\|");

        return new Book(Integer.parseInt(stringsBooks[1].trim()), stringsBooks[0].trim(), stringsBooks[2].trim(), LocalDate.parse(stringsBooks[3].trim()));
    }
}