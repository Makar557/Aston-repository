package org.Dubrovsky.Aston.Homework.second.ParsingStrategy;

import org.Dubrovsky.Aston.Homework.second.Student;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Context {
    private StrategyOfParsing strategy;

    public List<Student> executeParsing(InputStream inputStream) throws IOException {
        return strategy.getStudentFromFile(inputStream);
    }

    public void setStrategy(StrategyOfParsing strategy) {
        this.strategy = strategy;
    }
}
