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
public abstract class Role {
    private RoleType type;
    
    public enum RoleType{
        Manager("Manager"),
        Customer("Customer"),
        DeliveryMan("Delivery Man"),
        Restaurant("Restaurant");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public Role(RoleType type) {
        this.type = type;
    }
}
