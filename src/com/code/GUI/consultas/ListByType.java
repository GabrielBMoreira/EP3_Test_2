package com.code.GUI.consultas;

import com.code.tables.ObjetosArte;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class ListByType {
    private JButton fazerConsultaButton;
    private JPanel panel1;
    private JTextPane textPane1;
    private Connection connection;

    public JPanel getPanel1() {
        return panel1;
    }
    public ListByType(Connection connection) {
        fazerConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               consultar(connection);
            }
        });

    }

    private void consultar(Connection connection) {
        ObjetosArte obj = new ObjetosArte(connection);
        ResultSet resultado =  obj.getByTypeAndClassification();

        StyledDocument doc = textPane1.getStyledDocument();
        SimpleAttributeSet keyWord = new SimpleAttributeSet();

        try
        {
            while (resultado.next()){
                doc.insertString(0, String.format("%s %s %s %s %s %s %s %s %s %s \n", resultado.getString("objetosarte_id"), resultado.getString("cat_obj_art"), resultado.getString("ano_criacao"), resultado.getString("descricao"), resultado.getString("estilo"), resultado.getString("pais_cultura"), resultado.getString("periodo_obj"), resultado.getString("tipo_objart"), resultado.getString("titulo"), resultado.getString("artist_id")), null );
                doc.insertString(doc.getLength(), "\nEnd of text", keyWord );
            }
        }
        catch(Exception e) { System.out.println(e); }
    }
}
