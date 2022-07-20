package com.code.tables;

import java.sql.*;

public class Pinturas {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Pinturas(Connection connection) {
        setConnection(connection);
    }

    public ResultSet getAll() {

        String sql = "SELECT * FROM pinturas";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todas pinturas!");
            e.printStackTrace();
        }

        return result;
    }

    public int createEsculturas(Integer objetosArteId, String suporte, String tipo_tinta) {
        String sql = "INSERT INTO esculturas (objetosarte_id, suporte, tipo_tinta) VALUES (?, ?, ?)";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(objetosArteId));
            statement.setString(2, suporte);
            statement.setString(3, tipo_tinta);


            rows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir pintura!");
            e.printStackTrace();
        }

        return rows;

    }
}
