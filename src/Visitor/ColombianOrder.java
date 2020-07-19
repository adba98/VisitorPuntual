package Visitor;

import Composite.OrderComponent;

/**
 *
 * @author OSCAR
 */
public class ColombianOrder extends OrderComponent implements Order {

    private double orderAmount;
    private double additionalSH;

    public ColombianOrder(double inp_orderAmount, double inp_additionalSH) {
        orderAmount = inp_orderAmount;
        additionalSH = inp_additionalSH;
    }

    @Override
    public void accept(OrderVisitor v) {
        v.visit(this);
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getAdditionalSH() {
        return additionalSH;

    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
