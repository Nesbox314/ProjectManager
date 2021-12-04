package forms.requisito;

import forms.projeto.GerenciarProjeto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciarRequisito {
    private JFrame frameGerenciarRequisito;
    private JPanel panelGerenciarRequisito;
    private JButton novoRequisitoButton;
    private JButton editarRequisitoButton;
    private JButton deletarRequisitoButton;
    private JButton voltarButton;
    private JLabel labelIdProjeto;
    private JLabel labelNomeProjeto;
    private JLabel labelDescricaoProjeto;
    private JLabel labelDadosProjeto;
    private JTable tableGerenciarRequisito;

    public GerenciarRequisito(String id, String nome, String descricao) {
        labelIdProjeto.setText("ID: " + id);
        labelNomeProjeto.setText("Nome: " + nome);
        labelDescricaoProjeto.setText("Descrição: " + descricao);

        frameGerenciarRequisito = new JFrame("GerenciarRequisito");
        frameGerenciarRequisito.setContentPane(panelGerenciarRequisito);
        frameGerenciarRequisito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGerenciarRequisito.setVisible(true);
        frameGerenciarRequisito.setSize(1280, 720);
        criarTabela();

        novoRequisitoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovoRequisito(id, nome, descricao);
                frameGerenciarRequisito.dispose();
            }
        });
        editarRequisitoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deletarRequisitoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GerenciarProjeto();
                frameGerenciarRequisito.dispose();
            }
        });
    }

    private void criarTabela() {
        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);

        String[] columnNames = new String[]{"ID", "Projeto", "Nome", "Descrição", "Módulo", "Funcionalidades",
                "Data de Criação", "Autor", "Esforço estimado em horas", "Estado"};
        defaultTableModel.setColumnIdentifiers(columnNames);

        /*ResultSet resultSet = ProjetoDAO.pegarTodos();
        try
        {
            while(resultSet.next())
            {
                defaultTableModel.addRow(new Object[] {
                        resultSet.getObject("id"),
                        resultSet.getObject("nome"),
                        resultSet.getObject("descricao"),
                        resultSet.getObject("id_usuario")
                });
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/

        tableGerenciarRequisito.setModel(defaultTableModel);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
