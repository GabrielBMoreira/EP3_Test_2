package com.code.tables;

import java.sql.*;

public class Esculturas {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Esculturas(Connection connection) {
        setConnection(connection);
    }

    public ResultSet getAll() {

        String sql = "SELECT * FROM esculturas";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todas esculturas!");
            e.printStackTrace();
        }

        return result;
    }

    public int createEsculturas(Integer objetosArteId, String altura, String material, String peso) {
        String sql = "INSERT INTO esculturas (objetosarte_id, altura, material, peso) VALUES (?, ?, ?, ?)";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(objetosArteId));
            statement.setString(2, altura);
            statement.setString(3, material);
            statement.setString(4, peso);


            rows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir escultura!");
            e.printStackTrace();
        }

        return rows;

    }
}
