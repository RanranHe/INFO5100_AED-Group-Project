/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.SystemManager.SystemManagerMainJPanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ranranhe
 */
public class SystemManagerRole extends Role {

    public SystemManagerRole() {
        super(Role.RoleType.SystemManager);
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise en, JFrame frame) {
        SystemManagerMainJPanel cp = new SystemManagerMainJPanel(system, container, userAccount, frame);
        container.add(cp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }

    @Override
    public String toString() {
        return Role.RoleType.SystemManager.getValue();
    }
}
