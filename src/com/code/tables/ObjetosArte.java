package com.code.tables;

import java.sql.*;

public class ObjetosArte {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ObjetosArte(Connection connection) {
        setConnection(connection);
    }

    public ResultSet getAll() {

        String sql = "SELECT * FROM objetos_arte";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos objetos de arte!");
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet getByTypeAndClassification() {

        String sql = "SELECT objetosarte_id, cat_obj_art, ano_criacao, descricao, estilo, pais_cultura, periodo_obj, tipo_objart, titulo, artist_id"
                    + " FROM objetos_arte ORDER BY tipo_objart, cat_obj_art ASC";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos objetos de arte!");
            e.printStackTrace();
        }

        return result;

    }

    public int createExposicao(
            Integer objetosarte_id,
            String cat_obj_art,
            String ano_criacao,
            String descricao,
            String estilo,
            String pais_cultura,
            String periodo_obj,
            String tipo_objart,
            String titulo,
            String artist_id
    ) {
        String sql = "INSERT INTO objetos_arte (objetosarte_id, cat_obj_art, ano_criacao, descricao, estilo, pais_cultura, periodo_obj, tipo_objart, titulo, artist_id)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(objetosarte_id));
            statement.setString(2, cat_obj_art);
            statement.setString(3, ano_criacao);
            statement.setString(4, descricao);
            statement.setString(5, estilo);
            statement.setString(6, pais_cultura);
            statement.setString(7, periodo_obj);
            statement.setString(8, tipo_objart);
            statement.setString(9, titulo);
            statement.setString(10, artist_id);

            rows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir objeto de arte!");
            e.printStackTrace();
        }

        return rows;

    }
}
