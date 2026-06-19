package org.Dubrovsky.AstonHomework.secondTask.ParsingStrategy;

import org.Dubrovsky.AstonHomework.secondTask.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface StrategyOfParsing {
    public List<Student> getStudentFromFile(File file) throws IOException;
}
