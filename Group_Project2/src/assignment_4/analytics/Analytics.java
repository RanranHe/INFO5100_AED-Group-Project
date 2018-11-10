/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.analytics;

import assignment_4.entities.Customer;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Ranran
 */
public class Analytics {

    Comparator<Map.Entry<Integer, Integer>> descendingComp = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    };

    // 1.Our top 3 most popular product sorted from high to low.
    public void getThreeMostPopularProduct() {
        Map<Integer, Item> items = DataStore.getInstance().getItems();
        // Key: Product Id  Value: Number of saled
        Map<Integer, Integer> productNum = new HashMap<>();

        Iterator<Item> it = items.values().iterator();
        while (it.hasNext()) {
            Item next = it.next();
            int productId = next.getProductId();
            if (productNum.containsKey(productId)) {
                int update = productNum.get(productId) + next.getQuantity();
                productNum.remove(productId);
                productNum.put(productId, update);
            } else {
                productNum.put(productId, next.getQuantity());
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(productNum.entrySet());
        Collections.sort(list, descendingComp);

        System.out.println("--------------------------------------------");
        System.out.println("1. Our top 3 most popular product: ");
        for (int i = 0; i < list.size(); i++) {
            if (i < 3) {
                System.out.println("  Product Id: " + list.get(i).getKey() + "  # of sold: " + list.get(i).getValue());
            } else {
                if (list.get(2).getValue().equals(list.get(i).getValue())) {
                    System.out.println("  Product Id: " + list.get(i).getKey() + " tied the third place.");
                } else {
                    return;
                }
            }
        }
    }
}
