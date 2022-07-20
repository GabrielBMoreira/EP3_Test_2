package com.code.tables;

import java.sql.*;

public class Outros {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Outros(Connection connection) {
        setConnection(connection);
    }

    public ResultSet getAll() {

        String sql = "SELECT * FROM outros";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todas outras obras de arte!");
            e.printStackTrace();
        }

        return result;
    }

    public int createOutros(Integer objetosArteId, String tipo) {
        String sql = "INSERT INTO esculturas (objetosarte_id, tipo) VALUES (?, ?)";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(objetosArteId));
            statement.setString(2, tipo);


            rows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir escultura!");
            e.printStackTrace();
        }

        return rows;

    }
}
