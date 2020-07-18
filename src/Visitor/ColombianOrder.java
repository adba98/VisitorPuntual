package Visitor;


/**
 *
 * @author OSCAR
 */
public class ColombianOrder implements Order {

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
}
