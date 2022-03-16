package com.company.task6;

public class Check extends Buy {


    public Check(String name, double price, double weight) {
        super(name, price, weight);
    }

    public static void main(String[] args) {
        Product product = new Product("lemon", 3, 1);
        Buy buy = new Buy("lemon", 3, 20);
        System.out.println(buy);
    }
}
