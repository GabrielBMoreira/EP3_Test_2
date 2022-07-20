package com.code;

import com.code.GUI.GUIMain;
import com.code.GUI.GenericGraph;
import com.code.tables.*;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EP3 {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Art_Museum?stringtype=unspecified";
        String username = "postgres";
        String password = "VDC65@xp";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Conexao realizada com sucesso!");


//            Emprestados artists = new Emprestados(connection);
//
//            ResultSet resultado = artists.getByDateAndColectionWithCount();
//
//            List<String[]> resultadoSerializado = new ArrayList<String[]>();
//
//            while (resultado.next()){
//                String [] arranjo = new String[3];
//
//                arranjo[0] = resultado.getString("nome_colecao");
//                arranjo[1] = String.format("Colecao: %s %s", resultado.getString("nome_colecao"), resultado.getString("data_emprestimo")); ;
//                arranjo[2] = resultado.getString("contagem");
//
//                resultadoSerializado.add(arranjo);
//            }
//
//            GenericGraph chart = new GenericGraph(
//                    "Nakamura Chan Museum" ,
//                    "Aquisicao X Quantidade", resultadoSerializado, "emprestados");
//
//            chart.pack( );
//            chart.setVisible( true );

            JFrame frame = new JFrame("Nakamura Chan Museum");
            frame.setContentPane(new GUIMain(connection).main);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            connection.close();


        }catch (SQLException e){
            System.out.println("Erro ao conectar ao banco!");
            e.printStackTrace();
        }


    }
}
