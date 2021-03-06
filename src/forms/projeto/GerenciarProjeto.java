package forms.projeto;

import dao.ProjetoDAO;
import dao.UsuarioDAO;
import forms.PrimeiroMenu;
import forms.requisito.GerenciarRequisito;
import model.Usuario;
import utils.ProjectManagerUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class GerenciarProjeto {
    private JFrame frameGerenciarProjeto;
    private JPanel panelGerenciarProjeto;
    private JTable tableProjetos;
    private JButton buttonNovoProjeto;
    private JButton buttonDeletarProjeto;
    private JButton buttonEditarProjeto;
    private JButton voltarButton;
    private JButton abrirProjetoButton;

    public GerenciarProjeto() {
        frameGerenciarProjeto = new JFrame("GerenciarProjeto");
        frameGerenciarProjeto.setContentPane(panelGerenciarProjeto);
        frameGerenciarProjeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGerenciarProjeto.setVisible(true);
        frameGerenciarProjeto.setSize(1280, 720);
        criarTabela();

        buttonNovoProjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovoProjeto();
                frameGerenciarProjeto.dispose();
            }
        });

        buttonDeletarProjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) tableProjetos.getModel();
                if (tableProjetos.getSelectedRowCount() == 1) {
                    String id = tableModel.getValueAt(tableProjetos.getSelectedRow(), 0).toString();
                    Boolean sucesso = ProjetoDAO.deletar(id);
                    if (sucesso == true) {
                        tableModel.removeRow(tableProjetos.getSelectedRow());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione ao menos/apenas um registro!");
                }
            }
        });

        buttonEditarProjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) tableProjetos.getModel();
                if (tableProjetos.getSelectedRowCount() == 1) {
                    String id = tableModel.getValueAt(tableProjetos.getSelectedRow(), 0).toString();
                    new EditarProjeto(id);
                    frameGerenciarProjeto.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione ao menos/apenas um registro!");
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrimeiroMenu();
                frameGerenciarProjeto.dispose();
            }
        });

        abrirProjetoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) tableProjetos.getModel();
                if (tableProjetos.getSelectedRowCount() == 1) {
                    String id = tableModel.getValueAt(tableProjetos.getSelectedRow(), 0).toString();
                    String nome = tableModel.getValueAt(tableProjetos.getSelectedRow(), 1).toString();
                    String descricao = tableModel.getValueAt(tableProjetos.getSelectedRow(), 2).toString();
                    new GerenciarRequisito(id, nome, descricao);
                    frameGerenciarProjeto.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione ao menos/apenas um registro!");
                }

            }
        });
    }

    private void criarTabela() {
        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);

        String[] columnNames = new String[]{"ID", "Nome", "Descri????o", "Usu??rio Propriet??rio"};
        defaultTableModel.setColumnIdentifiers(columnNames);

        ResultSet resultSet = ProjetoDAO.pegarTodos();
        try {
            while (resultSet.next()) {
                defaultTableModel.addRow(new Object[]{
                        resultSet.getObject("id"),
                        resultSet.getObject("nome"),
                        resultSet.getObject("descricao"),
                        resultSet.getObject("id_usuario")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tableProjetos.setModel(defaultTableModel);
    }
}
