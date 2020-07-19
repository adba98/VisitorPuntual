package Visitor;

import Composite.OrderComponent;


public class CaliforniaOrder extends OrderComponent implements Order {

    private double orderAmount;
    private double additionalTax;

    public CaliforniaOrder() {
    }

    public CaliforniaOrder(double inp_orderAmount, double inp_additionalTax) {
        orderAmount = inp_orderAmount;
        additionalTax = inp_additionalTax;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getAdditionalTax() {
        return additionalTax;
    }

    public void accept(OrderVisitor v) {
        v.visit(this);
    }

    @Override
    public double getTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
