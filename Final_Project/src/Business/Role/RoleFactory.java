/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Role.Role.RoleType;

/**
 *
 * @author ranranhe
 */
public class RoleFactory {
    public static Role createRole(RoleType type) {
        if(type.equals(RoleType.DeliveryMan)) {
            return new DeliveryManRole();
        }
        if (type.equals(RoleType.Manager)) {
            return new ManagerRole();
        }
        if(type.equals(RoleType.Boss)) {
            return new BossRole();
        }
        if(type.equals(RoleType.SystemManager)) {
            return new SystemManagerRole();
        }
        return null;
    }
}
