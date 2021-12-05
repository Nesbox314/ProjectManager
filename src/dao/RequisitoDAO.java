package dao;

import model.Requisito;
import utils.ConnectionFactory;
import utils.ProjectManagerUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

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
            preparedStatement.setString(15, requisito.getEstado());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Requisito cadastrado com sucesso");
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
            JOptionPane.showMessageDialog(null, "Requisito deletado com sucesso");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Houve algum problema na sua deleção");
            e.printStackTrace();
        }
    }

    public static void editar(String id, Requisito requisito)
    {
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "UPDATE requisito set nome = ?, descricao = ?, modulo = ?, funcionalidade = ?," +
                    "fase = ?, complexidade = ?, prioridade = ?, versao = ?, ultimoautor = ?, dataultimaalteracao = ?, " +
                    "esforco = ?, estado = ? WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, requisito.getNome());
            preparedStatement.setString(2, requisito.getDescricao());
            preparedStatement.setString(3, requisito.getModulo());
            preparedStatement.setString(4, requisito.getFuncionalidade());
            preparedStatement.setString(5, requisito.getFase());
            preparedStatement.setString(6, requisito.getFuncionalidade());
            preparedStatement.setString(7, requisito.getPrioridade());
            preparedStatement.setString(8, requisito.getVersao());
            preparedStatement.setInt(9, ProjectManagerUtils.idLoggedUser);
            preparedStatement.setString(10, new Date().toString());
            preparedStatement.setInt(11, requisito.getEsforco());
            preparedStatement.setString(12, requisito.getEstado());
            preparedStatement.setString(13, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Requisito editado com sucesso");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro na sua edição");
            e.printStackTrace();
        }
    }

    public static Requisito pegarPeloId(String id)
    {
        Requisito requisito = new Requisito();
        try
        {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select * from requisito where id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                requisito.setId((Integer) resultSet.getObject("id"));
                requisito.setIdProjeto((Integer) resultSet.getObject("id_projeto"));
                requisito.setNome((String) resultSet.getObject("nome"));
                requisito.setDescricao((String) resultSet.getObject("descricao"));
                requisito.setModulo((String) resultSet.getObject("modulo"));
                requisito.setFuncionalidade((String) resultSet.getObject("funcionalidade"));
                requisito.setDatacriacao((String) resultSet.getObject("datacriacao"));
                requisito.setIdAutor((Integer) resultSet.getObject("id_autor"));
                requisito.setFase((String) resultSet.getObject("fase"));
                requisito.setComplexidade((String) resultSet.getObject("complexidade"));
                requisito.setPrioridade((String) resultSet.getObject("prioridade"));
                requisito.setVersao((String) resultSet.getObject("versao"));
                requisito.setUltimoautor((String) resultSet.getObject("ultimoautor"));
                requisito.setDataultimacriacao((String) resultSet.getObject("dataultimaalteracao"));
                requisito.setEsforco((Integer) resultSet.getObject("esforco"));
                requisito.setEstado((String) resultSet.getObject("estado"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return requisito;
    }
}
