package com.shitikov.task4_2.enumeration;

public enum SortingOrder {
    DECREASE(1),
    INCREASE(-1);

    private int order;

    SortingOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
