--DROP TABLE EMPLOYEE;
--
CREATE TABLE EMPLOYEE (
    emp_id INTEGER,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    salary INTEGER,
    dept_id INTEGER
);

INSERT INTO EMPLOYEE (emp_id, first_name, last_name, salary, dept_id) values (123, 'Naveen1', 'Sridhar', 456, 45);
INSERT INTO EMPLOYEE (emp_id, first_name, last_name, salary, dept_id) values (124, 'Matt', 'turner', 567, 105);