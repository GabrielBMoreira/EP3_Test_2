package com.code.tables;

import java.sql.*;

public class Exposicoes {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Exposicoes(Connection connection) {
        setConnection(connection);
    }

    public ResultSet getAll() {

        String sql = "SELECT * FROM exposicoes";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todas exposicoes!");
            e.printStackTrace();
        }

        return result;
    }

    public int createExposicao(Integer id, String data_inicio, String data_final) {
        String sql = "INSERT INTO exposicoes (expo_id, data_inicio, data_final) VALUES (?, ?, ?)";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(id));
            statement.setString(2, data_inicio);
            statement.setString(3, data_final);

            rows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir emprestimo!");
            e.printStackTrace();
        }

        return rows;

    }
}
