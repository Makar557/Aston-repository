package org.Dubrovsky.Aston.Homework.second;

import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.JsonParsClass;
import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.TxtParsClass;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParsingTest {

    @Test
    void compareTwoParsingMethods() throws IOException {
        JsonParsClass jsonParsClass = new JsonParsClass();
        TxtParsClass txtParsClass = new TxtParsClass();

        File jsonFile = new File("D:\\Aston\\Dubrovsky\\Homework\\src\\main\\resources\\Student.json");
        File txtFile = new File("D:\\Aston\\Dubrovsky\\Homework\\src\\main\\resources\\StudentsAndBooks.txt");


        List<Student> listFromJson = jsonParsClass.getStudentFromFile(jsonFile);
        List<Student> listFromTxt = txtParsClass.getStudentFromFile(txtFile);


        System.out.println("JSON:");
        listFromJson.forEach(System.out::println);

        System.out.println("TXT:");
        listFromTxt.forEach(System.out::println);

        assertTrue(listFromJson.equals(listFromTxt));
    }


}
