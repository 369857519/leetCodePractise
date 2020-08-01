package basics.reflect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static class ConnectionHolder{
        private static Connection connection;
        static {
            try {
                connection = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/tran_test?serverTimezone=Asia/Shanghai",
                                "root",
                                "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection getConection(){
        return ConnectionHolder.connection;
    }
}
