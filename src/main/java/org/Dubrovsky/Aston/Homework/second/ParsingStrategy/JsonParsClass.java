package org.Dubrovsky.Aston.Homework.second.ParsingStrategy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.Dubrovsky.Aston.Homework.second.Student;


import java.io.InputStream;
import java.util.List;
import java.io.IOException;

public class JsonParsClass implements StrategyOfParsing {

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public List<Student> getStudentFromFile(InputStream file) throws IOException {
        return mapper.readValue(file, new TypeReference<List<Student>>() {
        });
    }

}