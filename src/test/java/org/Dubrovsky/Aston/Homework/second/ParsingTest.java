package org.Dubrovsky.Aston.Homework.second;

import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.JsonParsClass;
import org.Dubrovsky.Aston.Homework.second.ParsingStrategy.TxtParsClass;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParsingTest {

    @Test
    void compareTwoParsingMethods() throws IOException {
        JsonParsClass jsonParsClass = new JsonParsClass();
        TxtParsClass txtParsClass = new TxtParsClass();

        InputStream jsonStream =
                getClass().getClassLoader()
                        .getResourceAsStream("Student.json");

        InputStream txtStream =
                getClass().getClassLoader()
                        .getResourceAsStream("StudentsAndBooks.txt");

        List<Student> listFromJson = jsonParsClass.getStudentFromFile(jsonStream);
        List<Student> listFromTxt = txtParsClass.getStudentFromFile(txtStream);


        System.out.println("JSON:");
        listFromJson.forEach(System.out::println);

        System.out.println("TXT:");
        listFromTxt.forEach(System.out::println);

        assertTrue(listFromJson.equals(listFromTxt));
    }


}
