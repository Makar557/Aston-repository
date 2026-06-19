package org.example.secondTask;

import org.example.secondTask.ParsingStrategy.Context;
import org.example.secondTask.ParsingStrategy.JsonParsClass;
import org.example.secondTask.ParsingStrategy.TxtParsClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        Context context = new Context();

        StreamTask servise = new StreamTask();

        File someFile = new File("D:\\Aston\\Dubrovsky\\Homework\\src\\main\\java\\org\\example\\secondTask\\Files\\StudentsAndBooks.txt");

        String[] sss = someFile.getName().split("\\.");

        List<Student> students = new ArrayList<>();

        if(sss[1].equals("json")){

            context.setStrategy(new JsonParsClass());
            try {
                students = context.executeParsing(someFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (sss[1].equals("txt")) {

            context.setStrategy(new TxtParsClass());
            try {
                students = context.executeParsing(someFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        servise.resultOfFourthTask(students);
    }
}