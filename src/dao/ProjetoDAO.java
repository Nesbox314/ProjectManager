package dao;

import model.Projeto;
import model.Usuario;
import utils.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProjetoDAO {

    public static ResultSet pegarTodos()
    {
        ResultSet resultSet = null;
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select * from projeto";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return resultSet;
    }

    public static void salvar(Projeto projeto) {
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "INSERT INTO projeto (nome, descricao, id_usuario) " +
                    "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, projeto.getNome());
            preparedStatement.setString(2, projeto.getDescricao());
            preparedStatement.setInt(3, projeto.getIdUsuario());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Projeto cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro no seu cadastro");
            e.printStackTrace();
        }
    }

    public static ResultSet pegarTodosPorUsuario(int id)
    {
        ResultSet resultSet = null;
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "SELECT * FROM projeto WHERE id_usuario = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return resultSet;
    }

    public static void deletar(String id)
    {
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "DELETE FROM projeto WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void editar(String id, Projeto projeto)
    {
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "INSERT INTO projeto (nome, descricao) VALUES (?, ?)";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, projeto.getNome());
            preparedStatement.setString(2, projeto.getDescricao());
            preparedStatement.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
