package ua.chernenko.springboot.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.chernenko.springboot.rest.dao.EmployeeDAO;
import ua.chernenko.springboot.rest.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;
    
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
  
    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
        
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

}
