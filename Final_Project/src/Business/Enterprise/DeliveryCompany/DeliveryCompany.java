/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.DeliveryCompany;

import Business.Enterprise.Enterprise;
import Business.Organization.DeliveryManOrganization;
import Business.Organization.ManagerOrganization;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ranranhe
 */
public class DeliveryCompany extends Enterprise {

    private int photoId;
    private String address;
    private String phone;
    private static int counter = 0;
    private String photoPath;
    private String description;
    private String id;
    
    public DeliveryCompany(String name,String address, String phone) {
        super(name);
        this.photoId = counter;
        this.id = "Delivery" + counter;
        counter++;
        this.address = address;
        this.phone = phone;
        
        String path = "Images/DeliveryCompanyCut/default.png";
        String fileName = "default.png";

        File f = new File("Images/DeliveryCompanyCut");
        if (f.isDirectory()) {
            File[] F1 = f.listFiles();
            for (File f2 : F1) {
                if (f2.getName().equalsIgnoreCase(this.photoId + ".png")) {
                    fileName = this.photoId + ".png";
                    path = "Images/DeliveryCompanyCut/" + fileName;
                }
            }
        }
        this.photoPath = path;
    }
    
    public int getPhotoId() {
        return this.photoId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String addr) {
        this.address = addr;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String des) {
        this.description = des;
    }
    
    public String getPath() {
        return this.photoPath;
    }

    public void setPath(String path) {
        String newPath = "";
        try {
            BufferedImage image = ImageIO.read(new File(path));

            int radio = 0;
            if (image.getWidth() / 250 < image.getHeight() / 180) {
                radio = image.getWidth() / 250;
            } else {
                radio = image.getHeight() / 180;
            }
            int x = 0, y = 0, cutW = 250 * radio, cutH = 180 * radio;

            Rectangle rect = new Rectangle(x, y, cutW, cutH);
            BufferedImage areaImage = image.getSubimage(rect.x, rect.y, rect.width, rect.height);

            BufferedImage buffImg = new BufferedImage(cutW, cutH, BufferedImage.TYPE_INT_RGB);
            buffImg.getGraphics().drawImage(areaImage.getScaledInstance(cutW, cutH, java.awt.Image.SCALE_SMOOTH), 0, 0, null);

            String fileName = this.photoId + ".png";
            newPath = "Images/DeliveryCompanyCut/" + fileName;
            ImageIO.write(buffImg, "png", new File(newPath));
        } catch (IOException e) {
            
        }
        this.photoPath = newPath;
    }

    @Override
    public void createOrganizations() {
        this.getOrganizationDirectory().getOrganizationList().add(new DeliveryManOrganization());
        this.getOrganizationDirectory().getOrganizationList().add(new ManagerOrganization());
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    
}
