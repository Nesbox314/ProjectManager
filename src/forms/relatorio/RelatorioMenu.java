package forms.relatorio;

import forms.PrimeiroMenu;
import forms.relatorio.projeto.RelatorioProjeto;
import forms.relatorio.requisito.RelatorioRequisito;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatorioMenu {
    private JFrame jFrameRelatorioMenu;
    private JButton sairButton;
    private JButton projetosButton;
    private JButton requisitosButton;
    private JPanel jPanelRelatorioMenu;

    public RelatorioMenu(){
        jFrameRelatorioMenu = new JFrame("RelatorioMenu");
        jFrameRelatorioMenu.setContentPane(jPanelRelatorioMenu);
        jFrameRelatorioMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameRelatorioMenu.setVisible(true);
        jFrameRelatorioMenu.setSize(1280, 720);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrameRelatorioMenu.dispose();
                new PrimeiroMenu();
            }
        });

        projetosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrameRelatorioMenu.dispose();
                new RelatorioProjeto();
            }
        });

        requisitosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrameRelatorioMenu.dispose();
                new RelatorioRequisito();
            }
        });
    }
}
