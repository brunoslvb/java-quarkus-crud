package com.github.brunoslvb.api;

import org.testcontainers.containers.MySQLContainer;

import java.util.HashMap;
import java.util.Map;

public class DatabaseLifecycle implements io.quarkus.test.common.QuarkusTestResourceLifecycleManager {

    private static final MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql:latest");

    @Override
    public Map<String, String> start() {
        MYSQL.start();
        Map<String, String> properties = new HashMap<>();
        properties.put("quarkus.datasource.jdbc.url", MYSQL.getJdbcUrl());
        properties.put("quarkus.datasource.username", MYSQL.getUsername());
        properties.put("quarkus.datasource.password", MYSQL.getPassword());
        return properties;
    }

    @Override
    public void stop() {
        if(MYSQL != null){
            MYSQL.stop();
        }
    }
}
