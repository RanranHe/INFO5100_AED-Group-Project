/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Restaurant.Restaurant;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.UserAccount.UserAccount;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ranranhe
 */
public abstract class Role {
    private RoleType type;
    
    public enum RoleType{
        Boss("Boss"),
        Manager("Manager"),
        Customer("Customer"),
        DeliveryMan("Delivery Man"),
        SystemManager("System Manager");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        public Type getOrganizationType() {
            if (this.value.equals(Manager.getValue())) {
                return Type.Manager;
            }
            if (this.value.equals(DeliveryMan.getValue())) {
                return Type.DeliveryMan;
            }
            else {
                return null;
            }
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public Role(RoleType type) {
        this.type = type;
    }
    
    public RoleType getRoleType() {
        return this.type;
    }
    
    @Override
    public abstract String toString();
    
    public abstract void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise en, JFrame frame);
}
