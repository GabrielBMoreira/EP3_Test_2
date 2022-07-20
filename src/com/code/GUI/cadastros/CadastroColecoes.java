package com.code.GUI.cadastros;

import com.code.GUI.ErrorDialog;
import com.code.GUI.OkDialog;
import com.code.tables.Colection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroColecoes {
    private JTextField textField1;
    private JPanel colecoesPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton cancelarButton;
    private JButton criarButton;
    private Colection colectionInstance;

    public CadastroColecoes(Colection colectionInstance) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regustrarColecao();
            }
        });
    }

    private void regustrarColecao() {
        String id = textField1.getText();
        String descricao = textField2.getText();
        String endereco = textField3.getText();
        String pessoa = textField4.getText();
        String telefone = textField5.getText();
        String tipo = textField6.getText();


        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(colecoesPanel,
                    "Por favor preencha o campo obrigatorio ID",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resp = colectionInstance.createColection(id, descricao, endereco, pessoa, telefone, tipo);

        if (resp > 0){
            JFrame ok = new JFrame("Instancia criada com sucecsso!");
            ok.setContentPane(new OkDialog().getOkPanel());
            ok.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ok.pack();
            ok.setVisible(true);
        } else {
            JFrame erro = new JFrame("Erro!");
            erro.setContentPane(new ErrorDialog().getErrorPanel());
            erro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            erro.pack();
            erro.setVisible(true);
        }

    }

    public Container getCadastroColecoes() { return colecoesPanel;
    }
}
