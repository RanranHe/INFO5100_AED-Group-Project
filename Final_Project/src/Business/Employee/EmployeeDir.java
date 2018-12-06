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

    public boolean isEmployeeExist(Employee emp) {
        if (!this.employeeList.isEmpty()) {
            for (Employee em : this.employeeList) {
                if (em.getId() == emp.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Employee createEmployee(String firstName, String lastName, String phone, String email) {
        Employee employee = new Employee(firstName, lastName, phone, email);
        employeeList.add(employee);
        return employee;
    }
}
