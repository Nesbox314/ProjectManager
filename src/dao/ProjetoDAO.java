package dao;

import model.Projeto;
import utils.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class ProjetoDAO {

    public static ResultSet pegarTodos() {
        ResultSet resultSet = null;
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select * from projeto";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
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

    public static void deletar(String id) {
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "DELETE FROM projeto WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Projeto deletado com sucesso");
        }
        catch (SQLIntegrityConstraintViolationException e)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível deletar o Projeto, " +
                    "pois há requisitos vinculados a ele!");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum problema com a sua deleção");
            e.printStackTrace();
        }
    }

    public static void editar(String id, Projeto projeto) {
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "UPDATE projeto SET nome = ?, descricao = ? WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, projeto.getNome());
            preparedStatement.setString(2, projeto.getDescricao());
            preparedStatement.setString(3, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Projeto editado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum problema com a sua edição!");
            e.printStackTrace();
        }
    }

    public static Projeto pegarPeloId(String id) {
        Projeto projeto = new Projeto();
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select * from projeto where id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                projeto.setId((Integer) resultSet.getObject("id"));
                projeto.setNome((String) resultSet.getObject("nome"));
                projeto.setDescricao((String) resultSet.getObject("descricao"));
                projeto.setIdUsuario((int) resultSet.getObject("id_usuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projeto;
    }
}
