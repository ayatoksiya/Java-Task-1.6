package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilePrinter {

    public static void printTesterProperties() throws IOException {

        Properties mapData = FileHandler.getProperties();

        Map<String, String> testerProperties = new HashMap<>();
        testerProperties.put("login", mapData.getProperty("1"));
        testerProperties.put("password", mapData.getProperty("2"));
        testerProperties.put("title", mapData.getProperty("3"));
        testerProperties.put("url", mapData.getProperty("4"));
        testerProperties.put("errorMessage", mapData.getProperty("5"));

        for (Map.Entry<String, String> property : testerProperties.entrySet())
            if (setSensitiveProperties().contains(property.getKey())) {
                System.out.println(property.getKey() + " *******");
            } else
                System.out.println(property.getKey() + ": " + property.getValue());
    }

    public static String setSensitiveProperties() {
        String[] sensitiveKeys = {"login", "password", "url"};
        return Stream.of(sensitiveKeys).collect(Collectors.joining(","));
    }
}

