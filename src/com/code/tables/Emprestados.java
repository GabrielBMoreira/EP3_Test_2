package com.code.tables;

import javax.xml.transform.Result;
import java.sql.*;

public class Emprestados {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Emprestados(Connection connection) {
        setConnection(connection);
    }

    public ResultSet getAll() {

        String sql = "SELECT * FROM emprestados";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos emprestimos!");
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getByDateAndColectionWithCount() {
        String sql = "SELECT nome_colecao, data_emprestimo, COUNT(*) as contagem FROM emprestados GROUP BY nome_colecao, data_emprestimo ORDER BY count(*) DESC";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos emprestados!");
            e.printStackTrace();
        }

        return result;

    }

    public int createEmprestado(Integer objetosArteId, String data_devolucao, String data_emprestimo, String nome_colecao) {
        String sql = "INSERT INTO emprestados (objetosarte_id, data_devolucao, data_emprestimo, nome_colecao) VALUES (?, ?, ?, ?)";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(objetosArteId));
            statement.setString(2, data_devolucao);
            statement.setString(3, data_emprestimo);
            statement.setString(4, nome_colecao);


            rows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir emprestimo!");
            e.printStackTrace();
        }

        return rows;

    }
}
