package org.Dubrovsky.AstonHomework.secondTask;

import java.util.*;

public class Student {

    private String name;

    private List<Book> listOfBooks;

    public String getName() {
        return name;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public Student(String name, List<Book> listOfBooks) {
        if (listOfBooks.size() < 5) {
            throw new IllegalArgumentException("There must be 5 or more books");
        }
        this.name = name;
        this.listOfBooks = List.copyOf(listOfBooks);
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", listOfBooks=" + listOfBooks +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return Objects.equals(name, student.name) && Objects.equals(listOfBooks, student.listOfBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, listOfBooks);
    }
}