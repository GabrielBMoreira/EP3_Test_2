package com.code.GUI.cadastros;

import com.code.GUI.GUIMain;
import com.code.tables.Artists;
import com.code.tables.Colection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class CadastroMain {
    private JPanel cadastroMain;
    private JButton pinturaButton;
    private JButton emprestadosButton;
    private JButton colecoesButton;
    private JButton esculturaButton;
    private JButton outrosButton;
    private JButton permanentesButton;
    private JButton exposicoesButton;
    private JButton artistaButton;

    private Connection connection;

    public JPanel getCadastroMain() {
        return cadastroMain;
    }

    public CadastroMain(Connection connection) {
        artistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame artista = new JFrame("Cadastro artista");
                Artists artists = new Artists(connection);
                artista.setContentPane(new CadastroArtista(artists).getArtistPanel());
                artista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                artista.pack();
                artista.setVisible(true);
            }
        });
        pinturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pintura = new JFrame("Cadastro pintura");
                pintura.setContentPane(new CadastroPintura().getCadastroPintura());
                pintura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                pintura.pack();
                pintura.setVisible(true);
            }
        });
        emprestadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame emprestado = new JFrame("Cadastro artista");
                emprestado.setContentPane(new CadastroEmprestado().getCadastroEmprestado());
                emprestado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                emprestado.pack();
                emprestado.setVisible(true);
            }
        });
        colecoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame colecoes = new JFrame("Cadastro colecoes");
                Colection colection = new Colection(connection);
                colecoes.setContentPane(new CadastroColecoes(colection).getCadastroColecoes());
                colecoes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                colecoes.pack();
                colecoes.setVisible(true);
            }
        });
        esculturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame escultura = new JFrame("Cadastro artista");
                escultura.setContentPane(new CadastroEscultura().getCadastroEscultura());
                escultura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                escultura.pack();
                escultura.setVisible(true);
            }
        });
        permanentesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame permanentes = new JFrame("Cadastro artista");
                permanentes.setContentPane(new CadastroPermanentes().getCadastroPermanentes());
                permanentes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                permanentes.pack();
                permanentes.setVisible(true);
            }
        });
        exposicoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame exposicoes = new JFrame("Cadastro artista");
                exposicoes.setContentPane(new CadastroExposicoes().getCadastroExposicoes());
                exposicoes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                exposicoes.pack();
                exposicoes.setVisible(true);
            }
        });
        outrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame outros = new JFrame("Cadastro artista");
                outros.setContentPane(new CadastroOutos().getCadastroOutros());
                outros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                outros.pack();
                outros.setVisible(true);
            }
        });

    }

    public static void main(String[] args) {

    }
}
