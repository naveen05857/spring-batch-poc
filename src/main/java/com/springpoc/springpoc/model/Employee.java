package com.springpoc.springpoc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    private Integer empId;
    private String firstName;
    private String lastName;
    private Long salary;
    private Integer deptId;
}
