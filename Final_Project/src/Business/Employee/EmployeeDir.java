/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class EmployeeDir {
    private ArrayList<Employee> employeeList;

    public EmployeeDir() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        employeeList.add(employee);
        return employee;
    }
}
