package forms.requisito;

import dao.RequisitoDAO;
import model.Requisito;
import utils.ProjectManagerUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class NovoRequisito {
    private JFrame frameNovoRequisito;
    private JPanel panelNovoRequisito;
    private JTextField inputNome;
    private JTextField inputComplexidade;
    private JTextField inputDescricao;
    private JTextField inputPrioridade;
    private JTextField inputModulo;
    private JTextField inputVersao;
    private JTextField inputFuncionalidade;
    private JTextField inputEsforco;
    private JLabel labelNome;
    private JLabel labelDescricao;
    private JLabel labelModulo;
    private JLabel labelFuncionalidade;
    private JLabel labelFase;
    private JLabel labelComplexidade;
    private JLabel labelPrioridade;
    private JLabel labelVersao;
    private JLabel labelEsforco;
    private JLabel labelEstado;
    private JComboBox comboEstado;
    private JTextField inputFase;
    private JButton salvarButton;
    private JButton voltarButton;

    NovoRequisito(String id, String nome, String descricao){
        frameNovoRequisito = new JFrame("GerenciarRequisito");
        frameNovoRequisito.setContentPane(panelNovoRequisito);
        frameNovoRequisito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNovoRequisito.setVisible(true);
        frameNovoRequisito.setSize(1280, 720);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameNovoRequisito.dispose();
                new GerenciarRequisito(id, nome, descricao);
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Requisito requisito = new Requisito();
                requisito.setIdProjeto(Integer.parseInt(id));
                requisito.setIdAutor(ProjectManagerUtils.idLoggedUser);
                requisito.setNome(inputNome.getText());
                requisito.setDescricao(inputDescricao.getText());
                requisito.setModulo(inputModulo.getText());
                requisito.setFuncionalidade(inputFuncionalidade.getText());
                requisito.setFase(inputFase.getText());
                requisito.setComplexidade(inputComplexidade.getText());
                requisito.setPrioridade(inputPrioridade.getText());
                requisito.setVersao(inputVersao.getText());
                requisito.setEsforco(Integer.parseInt(inputEsforco.getText()));
                requisito.setEstado(comboEstado.getSelectedIndex());
                requisito.setDatacriacao(new Date().toString());
                requisito.setDataultimacriacao(new Date().toString());
                RequisitoDAO.salvar(requisito);
                frameNovoRequisito.dispose();
                new GerenciarRequisito(id, nome, descricao);
            }
        });
    }
}
