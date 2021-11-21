package forms.usuario;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarUsuario {
    private JFrame frameEditarUsuario;
    private JTextField fieldNomeCompleto;
    private JTextField fieldNomeUsuario;
    private JTextField fieldEmail;
    private JTextField fieldTelefone;
    private JLabel labelNomeCompleto;
    private JLabel labelNomeUsuario;
    private JLabel labelEmail;
    private JLabel labelSenha;
    private JLabel labelTelefone;
    private JButton editarButton;
    private JButton voltarButton;
    private JPasswordField fieldSenha;
    private JPanel panelEditarUsuario;

    EditarUsuario(String id)
    {
        frameEditarUsuario = new JFrame("EditarUsuario");
        frameEditarUsuario.setContentPane(panelEditarUsuario);
        frameEditarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEditarUsuario.setVisible(true);
        frameEditarUsuario.setSize(640, 480);

        Usuario usuario = UsuarioDAO.pegarPeloId(id);
        fieldNomeCompleto.setText(usuario.getNomeCompleto());
        fieldEmail.setText(usuario.getEmail());
        fieldNomeUsuario.setText(usuario.getNomeUsuario());
        fieldSenha.setText(usuario.getSenha());
        fieldTelefone.setText(usuario.getTelefone());

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameEditarUsuario.dispose();
                new GerenciarUsuario();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioDAO.editar(id, getDadosEditados());
                frameEditarUsuario.dispose();
                new GerenciarUsuario();
            }
        });
    }

    private Usuario getDadosEditados()
    {
        Usuario usuario = new Usuario();
        usuario.setTelefone(fieldTelefone.getText());
        usuario.setNomeUsuario(fieldNomeUsuario.getText());
        usuario.setSenha(fieldSenha.getText());
        usuario.setEmail(fieldEmail.getText());
        usuario.setNomeCompleto(fieldNomeCompleto.getText());

        return usuario;
    }
}
