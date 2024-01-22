package com.product.shopping.entity;

import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

public class main {
    List<Order> orders = new ArrayList<>();
    List<Medicine> products = new ArrayList<>();
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public List<Medicine> getProducts() {
        return products;
    }
    public void setProducts(List<Medicine> products) {
        this.products = products;
    }
}
