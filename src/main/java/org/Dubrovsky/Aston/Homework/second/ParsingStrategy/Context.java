package org.Dubrovsky.Aston.Homework.secondTask.ParsingStrategy;

import org.Dubrovsky.Aston.Homework.secondTask.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Context {
    private StrategyOfParsing strategy;

    public List<Student> executeParsing(File file) throws IOException {
        return strategy.getStudentFromFile(file);
    }

    public void setStrategy(StrategyOfParsing strategy) {
        this.strategy = strategy;
    }
}
