package forms.requisito;

import dao.ProjetoDAO;
import dao.RequisitoDAO;
import model.Requisito;
import utils.ProjectManagerUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarRequisito {
    private JFrame frameEditarRequisito;
    private JTextField inputNome;
    private JTextField inputComplexidade;
    private JTextField inputDescricao;
    private JTextField inputPrioridade;
    private JTextField inputModulo;
    private JTextField inputVersao;
    private JTextField inputFuncionalidade;
    private JTextField inputEsforco;
    private JTextField inputFase;
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
    private JButton salvarButton;
    private JButton voltarButton;
    private JPanel panelEditarRequisito;

    public EditarRequisito(String id, String nome, String descricao) {
        frameEditarRequisito = new JFrame("GerenciarRequisito");
        frameEditarRequisito.setContentPane(panelEditarRequisito);
        frameEditarRequisito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEditarRequisito.setVisible(true);
        frameEditarRequisito.setSize(1280, 720);
        preencherCampos(id);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameEditarRequisito.dispose();
                new GerenciarRequisito(id, nome, descricao);
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Requisito requisito = pegarValoresCampos();
                if (ProjectManagerUtils.validaCampoRequisito(requisito.getNome(), requisito.getDescricao())) {
                    RequisitoDAO.editar(id, requisito);
                    frameEditarRequisito.dispose();
                    new GerenciarRequisito(id, nome, descricao);
                } else {
                    JOptionPane.showMessageDialog(null, "O campo nome/descrição é obrigatório!");
                }
            }
        });
    }

    public void preencherCampos(String id) {
        Requisito requisito = RequisitoDAO.pegarPeloId(id);
        inputNome.setText(requisito.getNome());
        inputDescricao.setText(requisito.getDescricao());
        inputModulo.setText(requisito.getModulo());
        inputFuncionalidade.setText(requisito.getFuncionalidade());
        inputFase.setText(requisito.getFase());
        inputComplexidade.setText(requisito.getComplexidade());
        inputPrioridade.setText(requisito.getPrioridade());
        inputVersao.setText(requisito.getVersao());
        inputEsforco.setText("" + requisito.getEsforco());
        comboEstado.setSelectedItem(requisito.getEstado());
    }

    public Requisito pegarValoresCampos() {
        Requisito requisito = new Requisito();
        requisito.setNome(inputNome.getText());
        requisito.setDescricao(inputDescricao.getText());
        requisito.setModulo(inputModulo.getText());
        requisito.setFuncionalidade(inputFuncionalidade.getText());
        requisito.setFase(inputFase.getText());
        requisito.setComplexidade(inputComplexidade.getText());
        requisito.setVersao(inputVersao.getText());
        requisito.setEsforco(Integer.parseInt(inputEsforco.getText()));
        requisito.setEstado((String) comboEstado.getSelectedItem());
        return requisito;
    }
}
