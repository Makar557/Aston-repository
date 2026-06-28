package org.Dubrovsky.Aston.Homework.second;

import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.Context;
import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.JsonParsClass;
import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.TxtParsClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String JSON = "json";
    private static final String TXT = "txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу:");

        String path = scanner.nextLine();

        String extension = getExtension(path);

        Context context = new Context();

        if (extension.equals(JSON)) {
            context.setStrategy(new JsonParsClass());
        } else if (extension.equals(TXT)) {
            context.setStrategy(new TxtParsClass());
        } else {
            throw new IllegalArgumentException("Неподдерживаемое расширение файла: " + extension);
        }

        List<Student> students;

        try (InputStream inputStream = new FileInputStream(new File(path))) {
            students = context.executeParsing(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла", e);
        }

        StreamTask service = new StreamTask();
        service.resultOfFourthTask(students);
    }

    private static String getExtension(String path) {
        int dotIndex = path.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == path.length() - 1) {
            throw new IllegalArgumentException("Файл должен иметь расширение");
        }
        return path.substring(dotIndex + 1).toLowerCase();
    }
}