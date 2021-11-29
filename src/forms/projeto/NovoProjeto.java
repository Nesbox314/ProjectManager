package forms.projeto;

import dao.ProjetoDAO;
import model.Projeto;
import utils.ProjectManagerUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovoProjeto {
    private JFrame frameNovoProjeto;
    private JPanel panelNovoProjeto;
    private JTextField fieldNome;
    private JButton voltarButton;
    private JButton salvarButton;
    private JTextField fieldDescricao;
    private JLabel labelDescricao;
    private JLabel labelNome;

    NovoProjeto() {
        frameNovoProjeto = new JFrame("NovoProjeto");
        frameNovoProjeto.setContentPane(panelNovoProjeto);
        frameNovoProjeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNovoProjeto.setVisible(true);
        frameNovoProjeto.setSize(1280, 720);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GerenciarProjeto();
                frameNovoProjeto.dispose();
            }
        });

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projeto projeto = new Projeto();
                projeto.setNome(fieldNome.getText());
                projeto.setDescricao(fieldDescricao.getText());
                projeto.setIdUsuario(ProjectManagerUtils.idLoggedUser);
                ProjetoDAO.salvar(projeto);
                new GerenciarProjeto();
                frameNovoProjeto.dispose();
            }
        });
    }
}
