package Composite;

/**
 *
 * @author OSCAR
 */
public abstract class OrderComponent {

    public OrderComponent() {

    }

    public void addComponent(OrderComponent component) throws CompositeException {
        throw new CompositeException("Invalid Operation. Not Supported add component");
    }

    public OrderComponent getComponent(int componentNum) throws CompositeException {
        throw new CompositeException("Invalid Operation. Not Supported get component");
    }

    public abstract double getTotal();

}
