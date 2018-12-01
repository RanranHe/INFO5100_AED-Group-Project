/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import UserInterface.Manager.RestaurantMainJPanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ranranhe
 */
public class BossRole extends Role {

    public BossRole(RoleType type) {
        super(type);
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise en, JFrame frame) {
        RestaurantMainJPanel cp = new RestaurantMainJPanel(system, container, net, en, userAccount, frame, this);
        container.add(cp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
    
}
