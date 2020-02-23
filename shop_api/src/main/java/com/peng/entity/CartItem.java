package com.peng.entity;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Product product;
    private Integer mount;
    private Double totlePrice;

    public CartItem(Product product, Integer mount, Double totlePrice) {
        super();
        this.product = product;
        this.mount = mount;
        this.totlePrice = totlePrice;
    }

    public CartItem() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getMount() {
        return mount;
    }

    public void setMount(Integer mount) {
        this.mount = mount;
    }

    public Double getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(Double totlePrice) {
        this.totlePrice = totlePrice;
    }

    @Override
    public String toString() {
        return "CartItem [product=" + product + ", mount=" + mount
                + ", totlePrice=" + totlePrice + "]";
    }


}
