package forms;

import dao.UsuarioDAO;
import factory.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GerenciarUsuario {
    private JFrame frameGerenciarUsuario;
    private JPanel panelGerenciarUsuario;
    private JTable tableGerenciarUsuario;
    private JButton buttonNovoUsuario;
    private JButton deletarUsuárioButton;
    private JButton editarUsuárioButton;

    GerenciarUsuario()
    {
        frameGerenciarUsuario = new JFrame("GerenciarUsuario");
        frameGerenciarUsuario.setContentPane(panelGerenciarUsuario);
        frameGerenciarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGerenciarUsuario.setVisible(true);
        frameGerenciarUsuario.setSize(640, 480);
        criarTabela();

        buttonNovoUsuario.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new NovoUsuario();
                frameGerenciarUsuario.dispose();
            }
        });

        deletarUsuárioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) tableGerenciarUsuario.getModel();
                if(tableGerenciarUsuario.getSelectedRowCount() == 1)
                {
                    String id = tableModel.getValueAt(tableGerenciarUsuario.getSelectedRow(), 0).toString();
                    UsuarioDAO.deletar(id);
                    tableModel.removeRow(tableGerenciarUsuario.getSelectedRow());
                }
            }
        });

        editarUsuárioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) tableGerenciarUsuario.getModel();
                if(tableGerenciarUsuario.getSelectedRowCount() == 1)
                {
                    String id = tableModel.getValueAt(tableGerenciarUsuario.getSelectedRow(), 0).toString();
                    new EditarUsuario(id);
                    frameGerenciarUsuario.dispose();;
                }
            }
        });
    }

    private void criarTabela()
    {
        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);

        String[] columnNames = new String[] {"ID", "Nome Completo", "Nome de Usuário", "E-mail", "Senha", "Telefone"};
        defaultTableModel.setColumnIdentifiers(columnNames);

        ResultSet resultSet = UsuarioDAO.pegarTodos();
        try
        {
            while(resultSet.next())
            {
                defaultTableModel.addRow(new Object[] {
                        resultSet.getObject("id"),
                        resultSet.getObject("nomecompleto"),
                        resultSet.getObject("nomeusuario"),
                        resultSet.getObject("email"),
                        resultSet.getObject("senha"),
                        resultSet.getObject("telefone")});
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        tableGerenciarUsuario.setModel(defaultTableModel);
    }
}
