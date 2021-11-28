package forms;

import forms.projeto.GerenciarProjeto;
import forms.usuario.GerenciarUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeiroMenu {
    private JFrame jFramePrimeiroMenu;
    private JPanel menuPanel;
    private JButton buttonUsuarios;
    private JButton buttonGerenciarProjetos;
    private JButton sairButton;

    public PrimeiroMenu() {
        jFramePrimeiroMenu = new JFrame("PrimeiroMenu");
        jFramePrimeiroMenu.setContentPane(menuPanel);
        jFramePrimeiroMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFramePrimeiroMenu.setVisible(true);
        jFramePrimeiroMenu.setSize(1280, 720);

        buttonUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GerenciarUsuario();
                jFramePrimeiroMenu.dispose();
            }
        });

        buttonGerenciarProjetos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GerenciarProjeto();
                jFramePrimeiroMenu.dispose();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFramePrimeiroMenu.dispose();
            }
        });
    }


}
