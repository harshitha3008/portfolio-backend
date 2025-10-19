package com.harshitha.portfolio.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Map;
import java.util.List;

public class JsonReader {

    private static final ObjectMapper mapper = new ObjectMapper();

    // For JSON files that are structured as key-value pairs
    public static Map<String, Object> readJsonAsMap(String fileName) throws IOException {
        return mapper.readValue(
                new ClassPathResource("data/" + fileName).getInputStream(),
                Map.class
        );
    }

    // For JSON files that are arrays
    public static List<Object> readJsonAsList(String fileName) throws IOException {
        return mapper.readValue(
                new ClassPathResource("data/" + fileName).getInputStream(),
                List.class
        );
    }
}
