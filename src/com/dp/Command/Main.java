package com.dp.Command;
import java.util.ArrayList;
import java.util.List;

class Stock {
    private String name;
    private int quantity;
    public Stock(String x, int y) { name=x; quantity=y; }
    public void buy(){
        System.out.println("Stock [ Name: "+name+",Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+",Quantity: " + quantity +" ] sold");
    }
}

interface Order {
    void execute();
}

class SellStock implements Order {
    private Stock stock;
    public SellStock(Stock stock){
        this.stock = stock;
    }
    @Override
    public void execute() {
        stock.sell();
    }
}

class BuyStock implements Order {
    private Stock stock;
    public BuyStock(Stock stock){
        this.stock = stock;
    }
    @Override
    public void execute() {
        stock.buy();
    }
}

class Broker {
    private List<Order> orderList = new ArrayList<Order>();
    public void takeOrder(Order order){
        orderList.add(order);
    }
    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}

public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();
        broker.takeOrder(new BuyStock(new Stock("Guns", 100)));
        broker.takeOrder(new SellStock(new Stock("Books", 50)));
        broker.placeOrders();
    }
}
