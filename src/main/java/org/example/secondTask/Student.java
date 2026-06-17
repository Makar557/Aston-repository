package org.example.secondTask;

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

    public void setName(String name) {
        this.name = name;
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
}