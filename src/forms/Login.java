package forms;

import utils.ProjectManagerUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                Boolean autenticado = ProjectManagerUtils.autenticar(emailInput.getText(), passwordInput.getText());
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
}
