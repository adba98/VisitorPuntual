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

    @Override
    public double getTotal() {
        double sizeOfAllFiles = 0;
        Enumeration e = orderCol.elements();
        while (e.hasMoreElements()) {
            OrderComponent component = (OrderComponent) e.nextElement();
            sizeOfAllFiles = sizeOfAllFiles + (component.getTotal());

        }
        return sizeOfAllFiles;
    }

    public void addComponent(OrderComponent component) throws CompositeException {

        orderCol.add(component);
        System.out.println(orderCol);

    }

    public OrderComponent getComponent(int componentNum) throws CompositeException {
        System.out.println(orderCol);
        return (OrderComponent) orderCol.elementAt(componentNum);
    }

}
