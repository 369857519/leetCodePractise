package basics.jdbc;

import com.mysql.cj.jdbc.JdbcConnection;

import javax.swing.plaf.IconUIResource;
import java.sql.*;

public class JdbcTest {
    /*
    Java Databasse Connectivity
    JDBC设计了一套访问接口，有数据库厂商对这些接口进行实现
    java.sql包提供访问数据库基本功能
    javax.sql包提供扩展功能

    java.sql.Driver 驱动
    java.sql.Connection 连接
    java.sql.Statement 静态处理块
    java.sql.PreparedStatement 预处理块
    java.sql.ResultSet 结果集
    java.sql.ResultSetMetaData 元数据
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con= PoolTest.getDBCP().getConnection();
        String sql = "select * from student";
        Statement statement=con.createStatement();
        Statement statement1=con.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString("name"));
        }
        statement.close();
        con.close();
    }
}
