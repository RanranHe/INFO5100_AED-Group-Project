/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Restaurant;

import Business.Enterprise.Item;
import Business.Enterprise.ShopModel;
import Business.Organization.ManagerOrganization;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author ranranhe
 */
public class Restaurant extends ShopModel {

    private int photoId;
    private RestaurantCategory category;
    private String id;
    private static int counter = 0;
    private String photoPath;

    @Override
    public ShopType getType() {
        return ShopType.Restaurant;
    }

    public enum RestaurantCategory {

        Seafood("Seafood"), Chinese("Chinese"),
        Japanese("Japanese"), Korean("Korean"),
        American("American"), Mexicon("Mexicon");

        private String value;

        private RestaurantCategory(String value) {
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

    public Restaurant(String name, String address, String phone) {
        super(name, address, phone);
        this.photoId = counter;
        this.id = "Restaurant" + counter;
        counter++;
        this.setType(ShopType.Restaurant);

        String path = "Images/RestaurantCut/default.png";
        String fileName = "default.png";

        File f = new File("Images/RestaurantCut");
        if (f.isDirectory()) {
            File[] F1 = f.listFiles();
            for (File f2 : F1) {
                if (f2.getName().equalsIgnoreCase(this.photoId + ".png")) {
                    fileName = this.photoId + ".png";
                    path = "Images/RestaurantCut/" + fileName;
                }
            }
        }
        this.photoPath = path;
    }

    @Override
    public void createOrganizations() {
        this.getOrganizationDirectory().getOrganizationList().add(new ManagerOrganization());
    }

    public int getPhotoId() {
        return this.photoId;
    }

    public RestaurantCategory getCategory() {
        return this.category;
    }

    public void setCategory(RestaurantCategory cat) {
        this.category = cat;
    }

    public ArrayList<Dash> getMenu() {
        ArrayList<Dash> result = new ArrayList<>();
        for (Item item : this.getItems()) {
            Dash dash = (Dash) item;
            result.add(dash);
        }
        return result;
    }

    public void addDashToMenu(Dash dash) {
        this.getItems().add(dash);
    }

//    public ArrayList<OrderRequest> getOrders() {
//        return this.orders;
//    }
//
//    public ArrayList<ReviewRequest> getReviews() {
//        return this.reviews;
//    }
    @Override
    public double getRate() {
        double totalRate = 0;
        double num = 0;
        for (WorkRequest wr : this.getWorkQueue().getWorkRequestList()) {
            OrderRequest order = (OrderRequest) wr;
            if (order.isReviewed()) {
                totalRate = totalRate + order.getReview().getRate();
                num++;
            }
        }
        if (num == 0) {
            return -1;
        }
        BigDecimal bd = new BigDecimal(totalRate/num);
        return bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

//    public void updateRate() {
//        int sum = 0;
//        if (reviews.isEmpty()) {
//            this.rate = -1;
//        } else {
//            for (ReviewRequest review : reviews) {
//                sum = sum + review.getRate();
//            }
//            BigDecimal bd = new BigDecimal(sum / reviews.size());
//            this.rate = bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
//        }
//    }
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
            newPath = "Images/RestaurantCut/" + fileName;
            ImageIO.write(buffImg, "png", new File(newPath));
        } catch (IOException e) {

        }
        this.photoPath = newPath;
    }
//
//    @Override
//    public String toString() {
//        return this.name;
//    }

    @Override
    public String getId() {
        return this.id;
    }
}
