package com.code.tables;

import java.sql.*;

public class Permanentes {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Permanentes(Connection connection) {
        setConnection(connection);
    }

    public ResultSet getAll() {

        String sql = "SELECT * FROM permanentes";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos permanentes!");
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getAllByDate(){
        String sql = "SELECT objetosarte_id, data_aquisicao, custo FROM permanentes ORDER BY data_aquisicao ASC";
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

    public int createPermanente(Integer objetosArteId, String custo, String data_aquisicao, String em_expo) {
        String sql = "INSERT INTO permanentes (objetosarte_id, custo, data_aquisicao, em_expo) VALUES (?, ?, ?, ?)";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(objetosArteId));
            statement.setString(2, custo);
            statement.setString(3, data_aquisicao);
            statement.setString(4, em_expo);


            rows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir permanente!");
            e.printStackTrace();
        }

        return rows;

    }
}
