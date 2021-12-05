package utils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class ProjectManagerUtils {

    public static int idLoggedUser;

    public static Boolean autenticar(String nomeUsuario, String senha) {
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select * from usuario where nomeusuario = ? and senha = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, nomeUsuario);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idLoggedUser = (int) resultSet.getObject("id");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public static Boolean validaCampoUsuario(String nomeUsuario, String senha) {
        if (nomeUsuario == null || senha == null) {
            return false;
        } else if (nomeUsuario.equals("") || senha.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public static Boolean validaCampoProjeto(String nomeProjeto) {
        if (nomeProjeto == null) {
            return false;
        } else if (nomeProjeto.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public static Boolean validaCampoRequisito(String nome, String descricao) {
        if (nome == null || descricao == null) {
            return false;
        } else if (nome.equals("") || descricao.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public static void createTables() {
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "CREATE TABLE IF NOT EXISTS usuario (\n" +
                    "            id int NOT NULL PRIMARY KEY auto_increment,\n" +
                    "            nomecompleto VARCHAR(60),\n" +
                    "            nomeusuario VARCHAR(20),\n" +
                    "            email VARCHAR(20),\n" +
                    "            senha VARCHAR(20),\n" +
                    "            telefone VARCHAR(20)\n" +
                    "        );";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.execute();

            Connection conn2 = ConnectionFactory.criaConexao();
            String sql2 = "CREATE TABLE IF NOT EXISTS projeto (\n" +
                    "                id int NOT NULL PRIMARY KEY auto_increment,\n" +
                    "        nome VARCHAR(50),\n" +
                    "                descricao VARCHAR(60),\n" +
                    "                id_usuario int,\n" +
                    "        FOREIGN KEY (id_usuario) REFERENCES usuario(id)\n" +
                    "        );";
            PreparedStatement preparedStatement2 = (PreparedStatement) conn2.prepareStatement(sql2);
            preparedStatement2.execute();

            Connection conn3 = ConnectionFactory.criaConexao();
            String sql3 = "CREATE TABLE IF NOT EXISTS requisito (\n" +
                    "            id int NOT NULL PRIMARY KEY auto_increment,\n" +
                    "            id_projeto int,\n" +
                    "            nome VARCHAR(40),\n" +
                    "            descricao VARCHAR(60),\n" +
                    "            modulo VARCHAR(50),\n" +
                    "            funcionalidade VARCHAR(50),\n" +
                    "            datacriacao VARCHAR(50),\n" +
                    "            id_autor int,\n" +
                    "            fase VARCHAR(50),\n" +
                    "            complexidade VARCHAR(20),\n" +
                    "            prioridade VARCHAR(30),\n" +
                    "            versao VARCHAR(10),\n" +
                    "            ultimoautor VARCHAR(20),\n" +
                    "            dataultimaalteracao VARCHAR(40),\n" +
                    "            esforco int,\n" +
                    "            estado VARCHAR(15),\n" +
                    "            FOREIGN KEY (id_projeto) REFERENCES projeto(id),\n" +
                    "            FOREIGN KEY (id_autor) REFERENCES usuario(id)\n" +
                    "        );";
            PreparedStatement preparedStatement3 = (PreparedStatement) conn3.prepareStatement(sql3);
            preparedStatement3.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
