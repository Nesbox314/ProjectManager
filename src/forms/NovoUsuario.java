package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameNovoUsuario.dispose();
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
