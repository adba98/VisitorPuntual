package Builder;

import Visitor.CaliforniaOrder;
import Visitor.Order;
import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author OSCAR
 */
public class CABuilder extends UIBuilder {

    private JTextField txtOrderAmount = new JTextField(10);
    private JTextField txtAdditionalTax = new JTextField(10);

    @Override
    public void addUIControls() {
        searchUI = new JPanel();
        JLabel lblOrderAmount = new JLabel("Order Amount:");
        JLabel lblAdditionalTax = new JLabel("Additional Tax:");

        GridBagLayout gridbag = new GridBagLayout();
        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        searchUI.add(lblOrderAmount);
        searchUI.add(txtOrderAmount);
        searchUI.add(lblAdditionalTax);
        searchUI.add(txtAdditionalTax);

        gbc.anchor = GridBagConstraints.WEST;

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmount, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblAdditionalTax, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmount, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtAdditionalTax, gbc);

    }

    @Override
    public void initialize() {
        txtOrderAmount.setText("Enter Amount");
        txtAdditionalTax.setText("Enter Add Tax");
    }

    @Override
    public Order createOrder() {
        
        // ¿porque combina la vista con la creacion de un objeto del modelo de negocio 
    
        String strOrderAmount = txtOrderAmount.getText();
        String strTax = txtAdditionalTax.getText();

        Double dblOrderAmount = new Double(strOrderAmount).doubleValue();
        Double dblTax = new Double(strTax).doubleValue();

        return new CaliforniaOrder(dblOrderAmount,dblTax);
    
    }

}
