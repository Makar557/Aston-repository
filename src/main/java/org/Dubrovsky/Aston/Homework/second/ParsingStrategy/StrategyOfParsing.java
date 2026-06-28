package org.Dubrovsky.Aston.Homework.second.ParsingStrategy;

import org.Dubrovsky.Aston.Homework.second.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface StrategyOfParsing {
    public List<Student> getStudentFromFile(InputStream file) throws IOException;
}
