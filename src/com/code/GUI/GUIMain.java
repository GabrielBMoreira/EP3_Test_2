package com.code.GUI;

import com.code.GUI.cadastros.CadastroMain;
import com.code.GUI.consultas.ConsultasMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class GUIMain {
    private JButton cadastroButton;
    private JLabel label1;
    private JButton consultasButton;
    public JPanel main;

    public GUIMain(Connection connection) {
        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cadastro = new JFrame("Cadastro");
                cadastro.setContentPane(new CadastroMain(connection).getCadastroMain());
                cadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cadastro.pack();
                cadastro.setVisible(true);
            }
        });

        consultasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cadastro = new JFrame("Consulta");
                cadastro.setContentPane(new ConsultasMain(connection).getConsultasPanel());
                cadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cadastro.pack();
                cadastro.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
    }
}
