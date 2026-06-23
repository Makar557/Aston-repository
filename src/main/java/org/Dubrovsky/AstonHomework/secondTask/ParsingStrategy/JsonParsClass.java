package org.Dubrovsky.AstonHomework.secondTask.ParsingStrategy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.Dubrovsky.AstonHomework.secondTask.Student;


import java.util.List;
import java.io.File;
import java.io.IOException;

public class JsonParsClass implements StrategyOfParsing {

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public List<Student> getStudentFromFile(File file) throws IOException{
        return mapper.readValue(file, new TypeReference<List<Student>>() {});
    }

}