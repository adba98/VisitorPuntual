package Composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author OSCAR
 */
public class OrderComposite extends OrderComponent {

    Vector orderCol = new Vector();

    public OrderComposite() {

    }

    public void addComponent(OrderComponent component) throws CompositeException {

        orderCol.add(component);
        System.out.println(orderCol);

    }

    public OrderComponent getComponent(int componentNum) throws CompositeException {
        System.out.println(orderCol);
        return (OrderComponent) orderCol.elementAt(componentNum);
    }

    @Override
    public double getTotal() {
        double totalOrders = 0;
        Enumeration e = orderCol.elements();
        while (e.hasMoreElements()) {
            OrderComponent component = (OrderComponent) e.nextElement();
            totalOrders = totalOrders + (component.getTotal());
        }
        return totalOrders;
    }

    @Override
    public String toString() {
        return "Pedido " + getTotal() ; 
    }

}
