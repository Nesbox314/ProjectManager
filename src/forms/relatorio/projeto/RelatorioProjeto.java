package forms.relatorio.projeto;

import forms.relatorio.RelatorioMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatorioProjeto {
    private JFrame frameRelatorioProjeto;
    private JTextField inputNome;
    private JButton gerarRelatórioButton;
    private JButton voltarButton;
    private JPanel jPanelRelatorioProjeto;

    public RelatorioProjeto() {
        frameRelatorioProjeto = new JFrame("RelatorioMenu");
        frameRelatorioProjeto.setContentPane(jPanelRelatorioProjeto);
        frameRelatorioProjeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRelatorioProjeto.setVisible(true);
        frameRelatorioProjeto.setSize(1280, 720);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRelatorioProjeto.dispose();
                new RelatorioMenu();
            }
        });

        gerarRelatórioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRelatorioProjeto.dispose();
                new RelatorioProjetoGerado(inputNome.getText());
            }
        });
    }
}
