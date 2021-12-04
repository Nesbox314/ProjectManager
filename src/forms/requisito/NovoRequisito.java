package forms.requisito;

import javax.swing.*;

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

    NovoRequisito(){
        frameNovoRequisito = new JFrame("GerenciarRequisito");
        frameNovoRequisito.setContentPane(panelNovoRequisito);
        frameNovoRequisito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameNovoRequisito.setVisible(true);
        frameNovoRequisito.setSize(1280, 720);
    }
}
