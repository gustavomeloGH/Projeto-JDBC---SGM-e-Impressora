package projetoProgramacaoAvancada.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionUtilJDBC {

    public static Connection getConnection() {

        Properties properties = new Properties();
        try {

            ResourceBundle resources = ResourceBundle.getBundle("projetoProgramacaoAvancada.Utils.DatabaseProperties");
            for (@SuppressWarnings("rawtypes") Enumeration keys = resources.getKeys(); keys.hasMoreElements();) {
                final String key = (String) keys.nextElement();
                final String value = resources.getString(key);
                properties.put(key, value);
            }
            Class.forName(properties.getProperty("jdbcDriver")).newInstance();
            return (Connection) DriverManager.getConnection(properties.getProperty("url"));
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            System.err.println("Houve um erro no banco de dados: "+ e.getMessage());
        }
        return null;
    }

}
