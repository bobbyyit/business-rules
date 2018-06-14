package com.yit.business.pojo;

public class Payment {
    private Product product;
    private String from;

    public Payment(Product product, String from) {
        this.product = product;
        this.from = from;
    }

    public Product getProduct() {
        return product;
    }

    public String getFrom() {
        return from;
    }
}
