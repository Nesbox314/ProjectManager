package forms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciarUsuario {
    private JFrame frameGerenciarUsuario;
    private JPanel panelGerenciarUsuario;
    private JTable tableGerenciarUsuario;
    private JButton buttonNovoUsuario;

    GerenciarUsuario(){
        frameGerenciarUsuario = new JFrame("GerenciarUsuario");
        frameGerenciarUsuario.setContentPane(panelGerenciarUsuario);
        frameGerenciarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGerenciarUsuario.setVisible(true);
        frameGerenciarUsuario.setSize(640, 480);
        criarTabela();

        buttonNovoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovoUsuario();
            }
        });
    }

    private void criarTabela(){
        DefaultTableModel daDefaultTableModel = new DefaultTableModel(0, 0);

        String[] columnNames = new String[] {"Nome Completo", "Nome de Usuário", "E-mail", "Senha", "Telefone"};

        daDefaultTableModel.setColumnIdentifiers(columnNames);
        daDefaultTableModel.addRow(new Object[] {"Test1","Test2","Test3","Test3","Test3"});

        tableGerenciarUsuario.setModel(daDefaultTableModel);
    }
}
