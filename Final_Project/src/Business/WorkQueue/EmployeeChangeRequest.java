/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;

/**
 *
 * @author ranranhe
 */
public class EmployeeChangeRequest extends WorkRequest {
    
    private Employee employee;
    
    public EmployeeChangeRequest(Enterprise enterprise, UserAccount account, Employee employee) {
        super(enterprise, account);
        this.employee = employee;
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee emp) {
        this.employee = emp;
    }
}
