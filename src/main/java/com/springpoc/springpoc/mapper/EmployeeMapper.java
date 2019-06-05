package com.springpoc.springpoc.mapper;

import com.springpoc.springpoc.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

        Employee employee = new Employee();

        employee.setEmpId(resultSet.getInt("emp_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setSalary(resultSet.getLong("salary"));
        employee.setDeptId(resultSet.getInt("dept_id"));
        return employee;
    }
}

