package forms;

import dao.UsuarioDAO;
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
                UsuarioDAO.salvar(usuario);
                new GerenciarUsuario();
                frameNovoUsuario.dispose();
            }
        });
    }
}
