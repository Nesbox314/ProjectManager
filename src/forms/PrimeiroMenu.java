package forms;

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

    public PrimeiroMenu(){
        jFramePrimeiroMenu = new JFrame("PrimeiroMenu");
        jFramePrimeiroMenu.setContentPane(menuPanel);
        jFramePrimeiroMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFramePrimeiroMenu.setVisible(true);
        jFramePrimeiroMenu.setSize(640, 480);

        buttonUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GerenciarUsuario();
                jFramePrimeiroMenu.setVisible(false);
            }
        });

        buttonGerenciarProjetos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
