package forms.relatorio.requisito;

import dao.ProjetoDAO;
import dao.RequisitoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RelatorioRequisitoGerado {
    private JFrame frameRelatorioRequisitoGerado;
    private JTable tableRequisitoGerado;
    private JButton voltarButton;
    private JPanel panelRelatorioRequisitoGerado;

    RelatorioRequisitoGerado(String filtroNome) {
        frameRelatorioRequisitoGerado = new JFrame("RelatorioProjetoGerado");
        frameRelatorioRequisitoGerado.setContentPane(panelRelatorioRequisitoGerado);
        frameRelatorioRequisitoGerado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRelatorioRequisitoGerado.setVisible(true);
        frameRelatorioRequisitoGerado.setSize(1280, 720);
        criarTabela(filtroNome);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRelatorioRequisitoGerado.dispose();
                new RelatorioRequisito();
            }
        });
    }

    private void criarTabela(String filtroNome) {
        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);

        String[] columnNames = new String[]{"ID", "Projeto", "Nome", "Descrição", "Módulo", "Funcionalidades",
                "Data de Criação", "Autor", "Esforço estimado em horas", "Estado"};
        defaultTableModel.setColumnIdentifiers(columnNames);

        ResultSet resultSet = RequisitoDAO.pegarPeloNome(filtroNome);
        try {
            while (resultSet.next()) {
                defaultTableModel.addRow(new Object[]{
                        resultSet.getObject("id"),
                        resultSet.getObject("id_projeto"),
                        resultSet.getObject("nome"),
                        resultSet.getObject("descricao"),
                        resultSet.getObject("modulo"),
                        resultSet.getObject("funcionalidade"),
                        resultSet.getObject("datacriacao"),
                        resultSet.getObject("id_autor"),
                        resultSet.getObject("esforco"),
                        resultSet.getObject("estado")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tableRequisitoGerado.setModel(defaultTableModel);
    }
}
