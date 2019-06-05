package com.springpoc.springpoc.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

//    @Value("${h2.datasource.url}")
//    private String url;
//
//    @Value("${h2.datasource.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${h2.datasource.username}")
//    private String userName;
//
//    @Value("${h2.datasource.password}")
//    private String password;

    @Bean
    public DataSource dataSource() {

//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:userDb");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//        return dataSource;

        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new
                EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder.addScript("classpath:org/springframework/batch/core/" +
                "schema-drop-h2.sql")
                .addScript("classpath:org/springframework/batch/core/schema-h2.sql")
                .addScript("classpath:scripts/insert-query.sql")
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }

}
