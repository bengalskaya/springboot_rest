package ua.chernenko.springboot.rest.service;

import java.util.List;

import ua.chernenko.springboot.rest.entity.Employee;



public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
}
