package Builder;

import Visitor.NonCaliforniaOrder;
import Visitor.Order;
import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author OSCAR
 */
public class NONCABuilder extends UIBuilder {

    private JTextField txtOrderAmount = new JTextField(10);

    @Override
    public void addUIControls() {
        searchUI = new JPanel();
        JLabel lblOrderAmount = new JLabel("Order Amount:");

        GridBagLayout gridbag = new GridBagLayout();
        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        searchUI.add(lblOrderAmount);
        searchUI.add(txtOrderAmount);

        gbc.anchor = GridBagConstraints.WEST;

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmount, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmount, gbc);

    }

    @Override
    public void initialize() {
        txtOrderAmount.setText("Enter Amount");
    }

    @Override
    public ArrayList getValues() {
        ArrayList values = new ArrayList();
        String strOrderAmount = txtOrderAmount.getText();

        values.add(strOrderAmount);

        return values;
    }
}
