package com.paypal.pojo;

import java.util.ArrayList;

public class Item_List {

    private ArrayList<Object> items;
    private ShippingAddress shipping_address;

    public ArrayList<Object> getItems() {
        return items;
    }

    public void setItems(ArrayList<Object> items) {
        this.items = items;
    }

    public ShippingAddress getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(ShippingAddress shipping_address) {
        this.shipping_address = shipping_address;
    }

}
