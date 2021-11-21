package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionFactory {

    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ProjectManager";

    public static Connection criaConexao()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void fechaConexao(Connection connection, PreparedStatement preparedStatement)
    {
        try {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
