package com.springpoc.springpoc.batch;

import com.springpoc.springpoc.model.Employee;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<Employee, Employee> {

    @Override
    public Employee process(Employee employee) throws Exception {
        return employee;
    }
}
