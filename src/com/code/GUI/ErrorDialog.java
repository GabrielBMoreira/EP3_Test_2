package com.code.GUI;

import com.code.GUI.cadastros.CadastroMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorDialog {
    private JPanel errorPanel;
    private JButton okButton;


    public JPanel getErrorPanel() {
        return errorPanel;
    }
    public ErrorDialog() {
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
        JFrame frame = new JFrame("Erro");
        frame.setContentPane(new ErrorDialog().errorPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
