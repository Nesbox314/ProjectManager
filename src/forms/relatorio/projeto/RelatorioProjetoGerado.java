package forms.relatorio.projeto;

import dao.ProjetoDAO;
import dao.UsuarioDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RelatorioProjetoGerado {
    private JFrame frameRelatorioProjetoGerado;
    private JTable tableProjetoGerado;
    private JPanel relatorioProjetoGeradoPanel;
    private JButton voltarButton;

    public RelatorioProjetoGerado(String filtroNome) {
        frameRelatorioProjetoGerado = new JFrame("RelatorioProjetoGerado");
        frameRelatorioProjetoGerado.setContentPane(relatorioProjetoGeradoPanel);
        frameRelatorioProjetoGerado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRelatorioProjetoGerado.setVisible(true);
        frameRelatorioProjetoGerado.setSize(1280, 720);
        criarTabela(filtroNome);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRelatorioProjetoGerado.dispose();
                new RelatorioProjeto();
            }
        });
    }

    private void criarTabela(String filtroNome) {
        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);

        String[] columnNames = new String[]{"ID", "Nome", "Descrição", "Usuário Proprietário"};
        defaultTableModel.setColumnIdentifiers(columnNames);

        ResultSet resultSet = ProjetoDAO.pegarPeloNome(filtroNome);
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

        tableProjetoGerado.setModel(defaultTableModel);
    }
}
