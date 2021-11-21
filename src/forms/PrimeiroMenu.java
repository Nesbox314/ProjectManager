package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeiroMenu {
    private static JFrame jFramePrimeiroMenu;
    private JPanel menuPanel;
    private JButton buttonUsuarios;
    private JButton buttonGerenciarProjetos;

    PrimeiroMenu(){
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
    }


}
