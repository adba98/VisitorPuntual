package Composite;

/**
 *
 * @author OSCAR
 */
public abstract class OrderComponent {

    private double total;

    public OrderComponent() {
        total = 0;
    }

    public void setTotal(double t) {
        total = t;
    }

    public double getTotal() {
        return total;
    }

    public void addComponent(OrderComponent component) throws CompositeException {
        throw new CompositeException("Invalid Operation. Not Supported add component");
    }

    public OrderComponent getComponent(int componentNum) throws CompositeException {
        throw new CompositeException("Invalid Operation. Not Supported get component");
    }

    public void setComponent(int componentNum,OrderComponent component) throws CompositeException {
        throw new CompositeException("Invalid Operation. Not Supported set component");
    }

    //   public abstract double getTotal();
    public abstract String toString();

}
