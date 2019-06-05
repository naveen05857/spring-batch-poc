package com.springpoc.springpoc.batch;

import com.springpoc.springpoc.mapper.EmployeeMapper;
import com.springpoc.springpoc.model.Employee;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ItemReader {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcCursorItemReader<Employee> reader() {

        JdbcCursorItemReader<Employee> reader = new JdbcCursorItemReader<>();

        reader.setDataSource(dataSource);
        reader.setSql("SELECT * FROM EMPLOYEE;");
        reader.setCurrentItemCount(100);
        reader.setRowMapper(new EmployeeMapper());

        return reader;
    }

}
