package org.example.secondTask.ParsingStrategy;

import org.example.secondTask.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface StrategyOfParsing {
    public List<Student> getStudentFromFile(File file) throws IOException;
}
