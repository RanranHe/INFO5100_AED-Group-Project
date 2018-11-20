package Business;

import Business.Employee.Employee;
import Business.Role.SystemManagerRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("Ranran", "He");
        
        UserAccount ua = system.getUserAccountDirectory().createEmployeeAccount("sysadmin", "sysadmin", new SystemManagerRole(), employee);
        
        return system;
    }
    
}
