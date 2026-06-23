package org.Dubrovsky.Aston.Homework.secondTask.ParsingStrategy;

import org.Dubrovsky.Aston.Homework.secondTask.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface StrategyOfParsing {
    public List<Student> getStudentFromFile(File file) throws IOException;
}
