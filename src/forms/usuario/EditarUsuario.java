package forms.usuario;

import dao.UsuarioDAO;
import model.Usuario;
import utils.ProjectManagerUtils;

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

    public EditarUsuario(String id) {
        frameEditarUsuario = new JFrame("EditarUsuario");
        frameEditarUsuario.setContentPane(panelEditarUsuario);
        frameEditarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEditarUsuario.setVisible(true);
        frameEditarUsuario.setSize(1280, 720);
        preencherCampos(id);

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
                Usuario usuario = pegarValoresCampos();
                if (ProjectManagerUtils.validaCampoUsuario(usuario.getNomeUsuario(), usuario.getSenha())) {
                    UsuarioDAO.editar(id, usuario);
                    frameEditarUsuario.dispose();
                    new GerenciarUsuario();
                } else {
                    JOptionPane.showMessageDialog(null, "Os campos usuário/senha são obrigatórios");
                }
            }
        });
    }

    private void preencherCampos(String id) {
        Usuario usuario = UsuarioDAO.pegarPeloId(id);
        fieldNomeCompleto.setText(usuario.getNomeCompleto());
        fieldEmail.setText(usuario.getEmail());
        fieldNomeUsuario.setText(usuario.getNomeUsuario());
        fieldSenha.setText(usuario.getSenha());
        fieldTelefone.setText(usuario.getTelefone());
    }

    private Usuario pegarValoresCampos() {
        Usuario usuario = new Usuario();
        usuario.setTelefone(fieldTelefone.getText());
        usuario.setNomeUsuario(fieldNomeUsuario.getText());
        usuario.setSenha(fieldSenha.getText());
        usuario.setEmail(fieldEmail.getText());
        usuario.setNomeCompleto(fieldNomeCompleto.getText());

        return usuario;
    }
}
