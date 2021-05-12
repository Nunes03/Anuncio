package br.com.henrique.anuncio.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    public static Connection conector(){

        java.sql.Connection conexao = null;
        String url = "jdbc:mysql://localhost:3306/henrique";
        String user = "root";
        String password = "root";
        
        try {
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println("ASDA");
            System.out.println(e);
            return null;
        }
    }
}
