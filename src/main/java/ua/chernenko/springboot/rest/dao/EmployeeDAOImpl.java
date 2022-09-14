package ua.chernenko.springboot.rest.dao;

import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.chernenko.springboot.rest.entity.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        Query query = entityManager.createQuery("from Employee"); 
        List<Employee> allEmployees = query.getResultList();
                
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

}
