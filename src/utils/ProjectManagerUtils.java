package utils;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProjectManagerUtils {

    public static Boolean autenticar(String nomeUsuario, String senha)
    {
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select * from usuario where nomeusuario = ? and senha = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, nomeUsuario);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public static void createTables(){

    }
}