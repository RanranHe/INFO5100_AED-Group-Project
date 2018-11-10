/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4;

import assignment_4.analytics.Analytics;
import assignment_4.analytics.DataStore;
import assignment_4.entities.Customer;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Wu Yunyi
 */
public class GateWay1 {

    DataReader orderReader;
    DataReader productReader;
    Analytics analytics = new Analytics();

    public GateWay1() throws IOException {
        DataGenerator generator = DataGenerator.getInstance();
        orderReader = new DataReader(generator.getOrderFilePath());
        productReader = new DataReader(generator.getProductCataloguePath());
    }

    public static void main(String args[]) throws IOException {
        GateWay1 inst = new GateWay1();
        inst.readData();
    }

    private void readData() throws IOException {
        String[] row;
        while ((row = productReader.getNextRow()) != null) {
            generateProduct(row);
        }
        while ((row = orderReader.getNextRow()) != null) {
            Item item = generateItem(row);
            Order order = generateOrder(row, item);
            generateCustomer(row, order);
            generateSalesPerson(row, order);
        }
        runAnalysis();
    }

    private void generateProduct(String[] row) {
        try {
            int productId = Integer.parseInt(row[0]);
            int minPrice = Integer.parseInt(row[1]);
            int maxPrice = Integer.parseInt(row[2]);
            int targetPrice = Integer.parseInt(row[3]);
            Product product = new Product(productId, minPrice, maxPrice, targetPrice);
            DataStore.getInstance().getProducts().put(productId, product);
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    private Item generateItem(String[] row) {
        Item item = null;
        try {
            int itemId = Integer.parseInt(row[1]);
            int productId = Integer.parseInt(row[2]);
            int salesPrice = Integer.parseInt(row[6]);
            int quantity = Integer.parseInt(row[3]);
            item = new Item(itemId, productId, salesPrice, quantity);
            DataStore.getInstance().getItems().put(itemId, item);
        } catch (Exception e) {
            throw new NullPointerException();
        }
        return item;
    }

    private Order generateOrder(String[] row, Item item) {
        Order order = null;
        try {
            int orderId = Integer.parseInt(row[0]);
            int supplierId = Integer.parseInt(row[4]);
            int customerId = Integer.parseInt(row[5]);
            Map<Integer, Order> orders = DataStore.getInstance().getOrders();
            if (orders.containsKey(orderId)) {
                orders.get(orderId).getItem().add(item);
            } else {
                order = new Order(orderId, supplierId, customerId);
                order.getItem().add(item);
                DataStore.getInstance().getOrders().put(orderId, order);
            }
        } catch (Exception e) {
            throw new NullPointerException();
        }
        return order;
    }

    private void generateCustomer(String[] row, Order order) {
        try {
            int customerId = Integer.parseInt(row[5]);
            Map<Integer, Customer> customers = DataStore.getInstance().getCustomers();
            if (customers.containsKey(customerId)) {
                customers.get(customerId).getCustomerOrders().add(order);
            } else {
                Customer customer = new Customer(customerId);
                customer.getCustomerOrders().add(order);
                customers.put(customerId, customer);
            }
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    private void generateSalesPerson(String[] row, Order order) {
        try {
            int salesId = Integer.parseInt(row[4]);
            Map<Integer, SalesPerson> salesPersons = DataStore.getInstance().getSalesPersons();
            if (salesPersons.containsKey(salesId)) {
                salesPersons.get(salesId).getSalesOrders().add(order);
            } else {
                SalesPerson salesPerson = new SalesPerson(salesId);
                salesPerson.getSalesOrders().add(order);
                salesPersons.put(salesId, salesPerson);
            }
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    private void runAnalysis() {
        
    }
}
