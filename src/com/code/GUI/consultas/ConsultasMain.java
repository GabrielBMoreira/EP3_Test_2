package com.code.GUI.consultas;

import com.code.GUI.cadastros.CadastroMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ConsultasMain {
    private JButton consultarButton;
    private JPanel consultasPanel;

    public ConsultasMain(Connection connection) {
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cadastro = new JFrame("Consultar objetos");
                cadastro.setContentPane(new ListByType(connection).getPanel1());
                cadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cadastro.pack();
                cadastro.setVisible(true);
            }
        });
    }

    public Container getConsultasPanel() {return consultasPanel;
    }
}
