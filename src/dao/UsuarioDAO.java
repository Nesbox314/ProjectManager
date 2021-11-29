package dao;

import utils.ConnectionFactory;
import model.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public static Usuario pegarPeloId(String id)
    {
        Usuario usuario = new Usuario();
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select * from usuario where id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                usuario.setId((Integer) resultSet.getObject("id"));
                usuario.setNomeCompleto((String) resultSet.getObject("nomecompleto"));
                usuario.setNomeUsuario((String) resultSet.getObject("nomeusuario"));
                usuario.setEmail((String) resultSet.getObject("email"));
                usuario.setSenha((String) resultSet.getObject("senha"));
                usuario.setTelefone((String) resultSet.getObject("telefone"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return usuario;
    }

    public static ResultSet pegarTodos()
    {
        ResultSet resultSet = null;
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select * from usuario";
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

    public static void salvar(Usuario usuario)
    {
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "INSERT INTO usuario (nomecompleto, nomeusuario, email, senha, telefone) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNomeCompleto());
            preparedStatement.setString(2, usuario.getNomeUsuario());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setString(5, usuario.getTelefone());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Houve algum erro no seu cadastro");
            e.printStackTrace();
        }
    }

    public static void editar(String id, Usuario usuario)
    {
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "UPDATE usuario set nomecompleto = ?, nomeusuario = ?, email = ?," +
                    " senha = ?, telefone = ? WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNomeCompleto());
            preparedStatement.setString(2, usuario.getNomeUsuario());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setString(5, usuario.getTelefone());
            preparedStatement.setString(6, id);
            preparedStatement.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletar(String id)
    {
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "DELETE FROM usuario WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
