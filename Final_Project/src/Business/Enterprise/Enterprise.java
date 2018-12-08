 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Employee.Employee;
import Business.Organization.Organization;
import Business.Organization.OrganizationDir;
import Business.Role.Role;
import Business.UserAccount.EmployeeAccount;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public abstract class Enterprise extends Organization {

    private OrganizationDir organizations;
    private static int idCounter = 0;

    public Enterprise(String name) {
        super(name);
        this.organizations = new OrganizationDir();
    }

    public OrganizationDir getOrganizationDirectory() {
        return organizations;
    }

    public void removeEmployeeAccount(UserAccount account) {
        EmployeeAccount ac = (EmployeeAccount) account;
        Employee em = ac.getEmployee();

        UserAccount ac1 = null;
        for (UserAccount ua : this.getUserAccountDirectory().getUserAccountList()) {
            if (ua.getUsername().equalsIgnoreCase(account.getUsername())) {
                ac1 = ua;
            }
        }
        if (ac1 != null) {
            this.getUserAccountDirectory().getUserAccountList().remove(ac1);
            return;
        }
        for (Organization or : organizations.getOrganizationList()) {
            for (UserAccount ua : or.getUserAccountDirectory().getUserAccountList()) {
                if (ua.getUsername().equalsIgnoreCase(ac.getUsername())) {
                    ac1 = ua;
                }
            }
            if (ac1 != null) {
                or.getUserAccountDirectory().getUserAccountList().remove(ac1);
                return;
            }
        }
    }

    public void removeEmployee(Employee employee) {

        Employee em = null;
        for (Employee e : this.getEmployeeDirectory().getEmployeeList()) {
            if (e.getId() == employee.getId()) {
                em = e;
            }
        }
        if (em != null) {
            this.getEmployeeDirectory().getEmployeeList().remove(em);
            return;
        }
        for (Organization or : organizations.getOrganizationList()) {
            for (Employee e : or.getEmployeeDirectory().getEmployeeList()) {
                if (e.getId() == employee.getId()) {
                    em = e;
                }
            }
            if (em != null) {
                or.getEmployeeDirectory().getEmployeeList().remove(em);
                return;
            }
        }
    }

    public abstract String getId();

    public abstract void createOrganizations();

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
