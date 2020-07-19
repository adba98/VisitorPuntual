package Visitor;

import Composite.OrderComponent;


public class NonCaliforniaOrder extends OrderComponent implements Order {

    private double orderAmount;

    public NonCaliforniaOrder() {
    }

    public NonCaliforniaOrder(double inp_orderAmount) {
        orderAmount = inp_orderAmount;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void accept(OrderVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
