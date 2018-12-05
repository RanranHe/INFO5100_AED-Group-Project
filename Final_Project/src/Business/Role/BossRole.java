/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.DeliveryCompany.DeliveryCompany;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Restaurant.Restaurant;
import Business.Enterprise.Store.Store;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import UserInterface.DeliveryCompany.Manager.DeliveryCompanyManagerMainJPanel;
import UserInterface.Restaurant.Manager.RestaurantManagerMainJPanel;
import UserInterface.StoreManagerMainJPanel.StoreManagerMainJPanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ranranhe
 */
public class BossRole extends Role {

    public BossRole() {
        super(RoleType.Boss);
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise en, JFrame frame) {
        if (en instanceof Restaurant) {
            RestaurantManagerMainJPanel cp = new RestaurantManagerMainJPanel(system, container, net, en, userAccount, frame, this);
            container.add(cp);
        }
        if (en instanceof DeliveryCompany) {
            DeliveryCompanyManagerMainJPanel cp = new DeliveryCompanyManagerMainJPanel(system, container, net, en, userAccount, frame, this);
            container.add(cp);
        }
        if (en instanceof Store) {
            StoreManagerMainJPanel cp = new StoreManagerMainJPanel(system, container, net, en, userAccount, frame, this);
            container.add(cp);
        }
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }

    @Override
    public String toString() {
        return RoleType.Boss.getValue();
    }
}
