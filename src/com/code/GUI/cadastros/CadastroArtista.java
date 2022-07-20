package com.code.GUI.cadastros;

import com.code.GUI.ErrorDialog;
import com.code.GUI.OkDialog;
import com.code.tables.Artists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroArtista {
    private JButton cancelButton;
    private JButton cadastrarButton;
    private JTextField nomeField;
    private JTextField descField;
    private JTextField deathField;
    private JTextField styleField;
    private JTextField originField;
    private JTextField periodField;
    private JPanel artistPanel;
    private Artists artistInstance;

    public JPanel getArtistPanel() {
        return artistPanel;
    }

    public CadastroArtista(Artists artistInstance) {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarArtista();
            }
        });
    }

    private void registrarArtista() {
        String nome = nomeField.getText();
        String dataMorte = deathField.getText();
        String descricao = descField.getText();
        String estiloPrincipal = styleField.getText();
        String paisOrigem = originField.getText();
        String periodo = periodField.getText();


        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(artistPanel,
                    "Por favor preencha o campo obrigatorio Nome",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resp = artistInstance.createArtist(nome, dataMorte, descricao, estiloPrincipal, paisOrigem, periodo);

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

    public static void main(String[] args) {
    }
}
