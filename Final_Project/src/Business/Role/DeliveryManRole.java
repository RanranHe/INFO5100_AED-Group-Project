/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization.Type;
import Business.UserAccount.UserAccount;
import UserInterface.DeliveryMan.DeliveryManMainJPanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise en, JFrame frame) {
        DeliveryManMainJPanel cp = new DeliveryManMainJPanel(system, container, en, userAccount, frame, this);
        container.add(cp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
}
