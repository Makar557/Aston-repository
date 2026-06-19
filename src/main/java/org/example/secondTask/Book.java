package org.example.secondTask;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private String name;

    private int numberOfPages;

    private String author;

    private LocalDate date;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Book() {
    }


    public Book(int numberOfPages, String name, String author, LocalDate date) {
        this.numberOfPages = numberOfPages;
        this.name = name;
        this.author = author;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return numberOfPages == book.numberOfPages && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(date, book.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPages, author, date);
    }
}
