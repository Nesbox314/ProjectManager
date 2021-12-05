package dao;

import model.Requisito;
import utils.ConnectionFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RequisitoDAO {

    public static void salvar(Requisito requisito) {
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "INSERT INTO requisito (id_projeto, nome, descricao, modulo, funcionalidade, " +
                    "datacriacao, id_autor, fase, complexidade, prioridade, versao, ultimoautor, dataultimaalteracao, " +
                    "esforco, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setInt(1, requisito.getIdProjeto());
            preparedStatement.setString(2, requisito.getNome());
            preparedStatement.setString(3, requisito.getDescricao());
            preparedStatement.setString(4, requisito.getModulo());
            preparedStatement.setString(5, requisito.getFuncionalidade());
            preparedStatement.setString(6, requisito.getDatacriacao());
            preparedStatement.setInt(7, requisito.getIdAutor());
            preparedStatement.setString(8, requisito.getFase());
            preparedStatement.setString(9, requisito.getComplexidade());
            preparedStatement.setString(10, requisito.getPrioridade());
            preparedStatement.setString(11, requisito.getVersao());
            preparedStatement.setString(12, requisito.getUltimoautor());
            preparedStatement.setString(13, requisito.getDataultimacriacao());
            preparedStatement.setInt(14, requisito.getEsforco());
            preparedStatement.setInt(15, requisito.getEstado());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Projeto cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro no seu cadastro");
            e.printStackTrace();
        }
    }

    public static ResultSet pegarTodos()
    {
        ResultSet resultSet = null;
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select id, id_projeto, nome, descricao, modulo, funcionalidade, datacriacao, " +
                    "id_autor, esforco, estado from requisito";
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

    public static void deletar(String id)
    {
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "DELETE FROM requisito WHERE id = ?";
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
