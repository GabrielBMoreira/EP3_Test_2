package com.code.tables;

import java.sql.*;

public class Artists {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Artists(Connection connection) {
        setConnection(connection);
    }

    public ResultSet getAll() {

        String sql = "SELECT * FROM artist";
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos artistas!");
            e.printStackTrace();
        }

        return result;
    }

    public int createArtist(String nome, String dataMorte, String descricao, String estiloPrincipal, String paisOrigem, String periodo) {
        String sql = "INSERT INTO artist (artist_id, data_morte, desc_artista, estilo_principal, pais_de_origem, periodo_art) VALUES (?, ?, ?, ?, ?, ?)";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, dataMorte);
            statement.setString(3, descricao);
            statement.setString(4, estiloPrincipal);
            statement.setString(5, paisOrigem);
            statement.setString(6, periodo);

            rows = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir artista!");
            e.printStackTrace();
        }

        return rows;

    }
}
