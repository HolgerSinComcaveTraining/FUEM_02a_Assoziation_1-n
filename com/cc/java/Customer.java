package com.cc.java;

import java.util.ArrayList;

public class Customer {
   
    private int id;
    private String name;
    private String city;

    private ArrayList<Order> orders = new ArrayList<>();

    public Customer(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

     /** Assoziation */

    public void addOrder(int id, String type, int delay){
        Order order = new Order(id, type , delay, this);
        orders.add(order);
        Logger.ausgabe(orders);
        checkOrder(order);
    }

    public void removeOrder(Order order){
        orders.remove(order);
        Logger.ausgabe(orders);
    }

    public void checkOrder(Order order){
        if (orders.size() == 0) {  // gibt es das Objekt ???
            Logger.ausgabe("Kein Auftrag vorhanden!");
        } else {
            Logger.ausgabe(getOrderDetails("#status",order));
            Logger.ausgabe(getOrderDetails("#type",order));
            Logger.ausgabe(getOrderDetails("#date",order));
            Logger.ausgabe("--------------"); 
        }
    }

    private String getOrderDetails(String flag, Order oder){
        switch (flag) {
            case "#type": // ordertype 
                return oder.getOrderType();
            case "#date": // orderdate
                return String.valueOf(oder.getOrderDate());
            case "#status": // orderstatus
                return checkOrderStatus(oder);
            default:
                return "Irgendwas ging schief!";
        }
    }

    private String checkOrderStatus(Order order){

        boolean flag    = order.isFinished();
        String orderID  = String.valueOf(order.getOrderID());

        if (flag) {
            return "Order " + orderID + " finished!";
        } else {
            return "Order " + orderID + " still pending!";
        }
    }

    public void actOnOrderFinished(Order order){;
        checkOrder(order);
        removeOrder(order);
    }

    /** Getter */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

  

  
    




}
