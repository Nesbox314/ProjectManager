package forms.projeto;

import dao.ProjetoDAO;
import model.Projeto;
import utils.ProjectManagerUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarProjeto {
    private JFrame frameEditarProjeto;
    private JLabel labelDescricao;
    private JLabel labelNome;
    private JTextField fieldNome;
    private JButton salvarButton;
    private JTextField fieldDescricao;
    private JButton voltarButton;
    private JPanel panelEditarProjeto;

    EditarProjeto(String id) {
        frameEditarProjeto = new JFrame("EditarProjeto");
        frameEditarProjeto.setContentPane(panelEditarProjeto);
        frameEditarProjeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEditarProjeto.setVisible(true);
        frameEditarProjeto.setSize(1280, 720);

        Projeto projeto = ProjetoDAO.pegarPeloId(id);
        fieldNome.setText(projeto.getNome());
        fieldDescricao.setText(projeto.getDescricao());

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GerenciarProjeto();
                frameEditarProjeto.dispose();
            }
        });

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projeto projeto = new Projeto();
                projeto.setNome(fieldNome.getText());
                projeto.setDescricao(fieldDescricao.getText());

                if (ProjectManagerUtils.validaCampoProjeto(projeto.getNome())) {
                    ProjetoDAO.editar(id, projeto);
                    new GerenciarProjeto();
                    frameEditarProjeto.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "O campo nome é obrigatório!");
                }

            }
        });
    }
}
