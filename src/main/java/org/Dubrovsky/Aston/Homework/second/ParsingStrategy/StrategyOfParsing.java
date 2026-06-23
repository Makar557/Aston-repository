package org.Dubrovsky.Aston.Homework.second.ParsingStrategy;

import org.Dubrovsky.Aston.Homework.second.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface StrategyOfParsing {
    public List<Student> getStudentFromFile(File file) throws IOException;
}
