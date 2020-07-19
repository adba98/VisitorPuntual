package Visitor;

import java.util.*;

class OrderVisitor implements VisitorInterface {

    //private Vector orderObjList;
    private double orderTotal;

    public OrderVisitor() {
        //   orderObjList = new Vector();
    }

    public void visit(NonCaliforniaOrder inp_order) {
        orderTotal = inp_order.getOrderAmount();

    }

    public void visit(CaliforniaOrder inp_order) {
        orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalTax();
        inp_order.setTotal( getOrderTotal());
    }

    public void visit(OverseasOrder inp_order) {
        orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalSH();
        //inp_order.total = getOrderTotal();
    }

    public void visit(ColombianOrder inp_order) {
        orderTotal = inp_order.getOrderAmount() + inp_order.getAdditionalSH();
        // inp_order.total = getOrderTotal();
    }

    public double getOrderTotal() {
        return orderTotal;
    }

}
