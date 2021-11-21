package forms;

import factory.ConnectionFactory;
import model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NovoUsuario {
    private JFrame frameNovoUsuario;
    private JPanel panelNovoUsuario;
    private JTextField fieldNomeCompleto;
    private JTextField fieldNomeUsuario;
    private JTextField fieldEmail;
    private JTextField fieldTelefone;
    private JButton cadastrarButton;
    private JButton voltarButton;
    private JLabel labelNomeCompleto;
    private JLabel labelNomeUsuario;
    private JLabel labelEmail;
    private JLabel labelSenha;
    private JLabel labelTelefone;
    private JPasswordField fieldSenha;

    public NovoUsuario() {
        frameNovoUsuario = new JFrame("NovoUsuario");
        frameNovoUsuario.setContentPane(panelNovoUsuario);
        frameNovoUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNovoUsuario.setVisible(true);
        frameNovoUsuario.setSize(640, 480);

        voltarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new GerenciarUsuario();
                frameNovoUsuario.dispose();
            }
        });

        cadastrarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Usuario usuario = new Usuario();
                usuario.setNomeCompleto(fieldNomeCompleto.getText());
                usuario.setNomeUsuario(fieldNomeUsuario.getText());
                usuario.setEmail(fieldEmail.getText());
                usuario.setSenha(fieldSenha.getText());
                usuario.setTelefone(fieldTelefone.getText());
                Boolean sucesso = cadastrarUsuario(usuario);
                System.out.println(sucesso);
            }
        });
    }

    public Boolean cadastrarUsuario(Usuario usuario)
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
            new GerenciarUsuario();
            frameNovoUsuario.dispose();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Houve algum erro no seu cadastro");
            e.printStackTrace();
            return false;
        }

        return false;
    }
}
