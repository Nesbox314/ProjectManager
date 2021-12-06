package forms.relatorio.requisito;

import forms.relatorio.RelatorioMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatorioRequisito {
    private JFrame frameRelatorioRequisito;
    private JTextField inputNome;
    private JButton gerarRelatórioButton;
    private JButton voltarButton;
    private JPanel panelRelatorioRequisito;

    public RelatorioRequisito() {
        frameRelatorioRequisito = new JFrame("RelatorioRequisito");
        frameRelatorioRequisito.setContentPane(panelRelatorioRequisito);
        frameRelatorioRequisito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRelatorioRequisito.setVisible(true);
        frameRelatorioRequisito.setSize(1280, 720);

        gerarRelatórioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRelatorioRequisito.dispose();
                new RelatorioMenu();
            }
        });
    }
}
