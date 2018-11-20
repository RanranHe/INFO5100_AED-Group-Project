/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;

/**
 *
 * @author ranranhe
 */
public class EmployeeAccount extends UserAccount {
    private Employee employee;
    
    public EmployeeAccount(String username, String password, Role role, Employee employee) {
        super(username, password, role);
        this.employee = employee;
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
            
    public void setEmployee(Employee em) {
        this.employee = em;
    }
}
