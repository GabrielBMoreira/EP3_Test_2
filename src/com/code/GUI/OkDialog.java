package com.code.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkDialog {
    private JPanel okPanel;
    private JButton okButton;

    public JPanel getOkPanel() {
        return okPanel;
    }
    public OkDialog() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Acerto");
        frame.setContentPane(new OkDialog().okPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
