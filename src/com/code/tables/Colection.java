package com.code.tables;

import java.sql.*;

public class Colection {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Colection(Connection connection) {
        setConnection(connection);
    }

    public ResultSet getAll() {

        String sql = "SELECT * FROM colecao";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todas colecoes!");
            e.printStackTrace();
        }

        return result;
    }

    public int createColection(String colecao_id, String desc_col, String endereco, String pessoa_contato, String telefone, String tipo_col) {
        String sql = "INSERT INTO colecao (colecao_id, desc_col, endereco, pessoa_contato, telefone, tipo_col) VALUES (?, ?, ?, ?, ?, ?)";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, colecao_id);
            statement.setString(2, desc_col);
            statement.setString(3, endereco);
            statement.setString(4, pessoa_contato);
            statement.setString(5, telefone);
            statement.setString(6, tipo_col);

            rows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir colecao!");
            e.printStackTrace();
        }

        return rows;

    }
}
