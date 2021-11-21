package dao;

import factory.ConnectionFactory;
import model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PessoaDAO {

    public void save(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa(nome, email) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.criaConexao();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getEmail());
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fechaConexao(conn, pstm);
        }
    }
}
