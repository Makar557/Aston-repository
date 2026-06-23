package org.Dubrovsky.Aston.Homework.second;

import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.Context;
import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.JsonParsClass;
import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.TxtParsClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String JSON = "json";
    private static final String TXT = "txt";

    public static void main(String[] args) {


        Context context = new Context();

        Scanner scanner = new Scanner(System.in);

        StreamTask service = new StreamTask();

        System.out.println("Введите путь к файлу:");

        String path = scanner.nextLine();

        File file = new File(path);

        String[] fileExtensionParts = file.getName().split("\\.");

        if (fileExtensionParts.length == 1) {
            throw new IllegalArgumentException("Файл должен иметь расширение");
        }

        List<Student> students = new ArrayList<>();

        if (fileExtensionParts[fileExtensionParts.length - 1].equals(JSON)) {

            context.setStrategy(new JsonParsClass());
            try {
                students = context.executeParsing(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (fileExtensionParts[fileExtensionParts.length - 1].equals(TXT)) {

            context.setStrategy(new TxtParsClass());
            try {
                students = context.executeParsing(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        service.resultOfFourthTask(students);
    }
}