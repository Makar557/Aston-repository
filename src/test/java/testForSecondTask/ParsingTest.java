package testForSecondTask;

import org.Dubrovsky.AstonHomework.secondTask.ParsingStrategy.JsonParsClass;
import org.Dubrovsky.AstonHomework.secondTask.ParsingStrategy.TxtParsClass;
import org.Dubrovsky.AstonHomework.secondTask.Student;
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

        File jsonFile = new File("D:\\Aston\\Dubrovsky\\Homework\\src\\main\\java\\org\\example\\secondTask\\Files\\Student.json");
        File txtFile = new File("D:\\Aston\\Dubrovsky\\Homework\\src\\main\\java\\org\\example\\secondTask\\Files\\StudentsAndBooks.txt");


        List<Student> listFromJson = jsonParsClass.getStudentFromFile(jsonFile);
        List<Student> listFromTxt = txtParsClass.getStudentFromFile(txtFile);


        System.out.println("JSON:");
        listFromJson.forEach(System.out::println);

        System.out.println("TXT:");
        listFromTxt.forEach(System.out::println);

        assertTrue(listFromJson.equals(listFromTxt));
    }


}
