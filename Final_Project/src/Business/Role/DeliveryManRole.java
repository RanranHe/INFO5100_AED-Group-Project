/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

/**
 *
 * @author ranranhe
 */
public class DeliveryManRole extends Role {

    public DeliveryManRole() {
        super(Role.RoleType.DeliveryMan);
    }
    
    @Override
    public String toString() {
        return Role.RoleType.DeliveryMan.getValue();
    }
}
