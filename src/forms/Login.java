package forms;

import factory.ConnectionFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame {
    private JTextField emailInput;
    private JTextField passwordInput;
    private JPanel loginPanel;
    private JLabel loginLabel;
    private JButton submit;
    private JLabel passwordLabel;
    private static JFrame jFrameLogin;

    public static void main(String[] args)
    {
        jFrameLogin = new JFrame("Login");
        jFrameLogin.setContentPane(new Login().loginPanel);
        jFrameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameLogin.pack();
        jFrameLogin.setVisible(true);
        jFrameLogin.setSize(640, 480);
    }

    public Login()
    {
        submit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Boolean autenticado = autenticar(emailInput.getText(), passwordInput.getText());
                if(autenticado == true)
                {
                    JOptionPane.showMessageDialog(null, "Você logou com sucesso");
                    new PrimeiroMenu();
                    jFrameLogin.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Verifique o seu usuário e senha");
                }
            }
        });
    }

    public Boolean autenticar(String email, String senha)
    {
        try {
            Connection conn = ConnectionFactory.criaConexao();
            String sql = "select * from usuario where email = ? and senha = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }
}
