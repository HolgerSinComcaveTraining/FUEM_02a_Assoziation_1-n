package com.cc.java;

public class App {
    
    public static void main(String[] args) {

      Customer customer = new Customer(1, "Maxine Mütze", "Mützenhausen");  
      customer.addOrder(1, "Reparatur",3);
      customer.addOrder(2, "Einkauf", 1);

    }

}
