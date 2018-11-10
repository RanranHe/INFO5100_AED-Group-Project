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

    // 2. Our 3 best customers 
    public void getThreeBestCustomers() {
        Map<Integer, Customer> customers = DataStore.getInstance().getCustomers();
        // Key: CustomerId  Value: Total revenue of orders placed by the customer
        Map<Integer, Integer> revenueFromCustomer = new HashMap<>();
        Map<Integer, Integer> turnOverFromCustomer = new HashMap<>();

        Iterator<Entry<Integer, Customer>> it = customers.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, Customer> next = it.next();
            ArrayList<Order> orders = next.getValue().getCustomerOrders();
            int customerId = next.getKey();
            int totalRevenue = 0;
            int turnOver = 0;
            for (Order order : orders) {
                for (Item item : order.getItem()) {
                    int minPrice = getMinPrice(item.getProductId());
                    totalRevenue = totalRevenue + (item.getSalesPrice() - minPrice) * item.getQuantity();
                    turnOver = turnOver + item.getSalesPrice() * item.getQuantity();
                }
            }
            revenueFromCustomer.put(customerId, totalRevenue);
            turnOverFromCustomer.put(customerId, turnOver);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(revenueFromCustomer.entrySet());
        Collections.sort(list, descendingComp);

        List<Map.Entry<Integer, Integer>> listTurnOver = new ArrayList<>(turnOverFromCustomer.entrySet());
        Collections.sort(listTurnOver, descendingComp);

        System.out.println("--------------------------------------------");
        System.out.println("2-1. Our 3 best customers based on revenue: ");
        for (int i = 0; i < list.size(); i++) {
            if (i < 3) {
                System.out.println("  Customer Id: " + list.get(i).getKey() + "  Total revenue brought: " + list.get(i).getValue());
            } else {
                if (list.get(2).getValue().equals(list.get(i).getValue())) {
                    System.out.println("  Customer Id: " + list.get(i).getKey() + " tied the third place.");
                } else {
                    break;
                }
            }
        }

        System.out.println("2-2. Our 3 best customers based on turnover: ");
        for (int i = 0; i < listTurnOver.size(); i++) {
            if (i < 3) {
                System.out.println("  Customer Id: " + listTurnOver.get(i).getKey() + "  Total turnover brought: " + listTurnOver.get(i).getValue());
            } else {
                if (listTurnOver.get(2).getValue().equals(listTurnOver.get(i).getValue())) {
                    System.out.println("  Customer Id: " + listTurnOver.get(i).getKey() + " tied the third place.");
                } else {
                    break;
                }
            }
        }
    }

    // helper function: get min price of a product
    private int getMinPrice(int id) {
        Map<Integer, Product> products = DataStore.getInstance().getProducts();

        if (products.containsKey(id)) {
            return products.get(id).getMinPrice();
        } else {
            throw new NullPointerException("Product doesn't exist!");
        }
    }

    // 3. Our top 3 best sales people
    public void getTopThreeBestSalesPeople() {
        Map<Integer, SalesPerson> salesPersons = DataStore.getInstance().getSalesPersons();
        // Key: SalesPersonId  Value: Total revenue of orders created by the sales person
        Map<Integer, Integer> revenueBySalesPerson = new HashMap<>();

        Iterator<Entry<Integer, SalesPerson>> it = salesPersons.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, SalesPerson> next = it.next();
            ArrayList<Order> orders = next.getValue().getSalesOrders();
            int salesId = next.getKey();
            int totalRevenue = 0;
            for (Order order : orders) {
                for (Item item : order.getItem()) {
                    int minPrice = getMinPrice(item.getProductId());
                    totalRevenue = totalRevenue + (item.getSalesPrice() - minPrice) * item.getQuantity();
                }
            }
            revenueBySalesPerson.put(salesId, totalRevenue);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(revenueBySalesPerson.entrySet());
        Collections.sort(list, descendingComp);

        System.out.println("--------------------------------------------");
        System.out.println("3. Our top 3 best sales people: ");
        for (int i = 0; i < list.size(); i++) {
            if (i < 3) {
                System.out.println("  Sales Person Id: " + list.get(i).getKey() + "  Total revenue: " + list.get(i).getValue());
            } else {
                if (list.get(2).getValue().equals(list.get(i).getValue())) {
                    System.out.println("  Customer Id: " + list.get(i).getKey() + " tied the third place.");
                } else {
                    return;
                }
            }
        }
    }

    // 4. Our total revenue for the year
    public void totalRevenueForTheYear() {
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        int totalRevenue = 0;

        Iterator<Order> it = orders.values().iterator();
        while (it.hasNext()) {
            Order next = it.next();
            for (Item item : next.getItem()) {
                totalRevenue = totalRevenue + (item.getSalesPrice() - getMinPrice(item.getProductId())) * item.getQuantity();
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("4. Our total revenue for the year is: " + totalRevenue);
    }
}
