package basics.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PoolTest {
    /**
     * 连接池为了减少频繁开关连接，提高系统相应能力
     * 1、初始大小
     * 2、每次扩容的大小
     * 3、连接池的最大个数
     * 4、空闲连接的死亡时间
     * <p>
     * 常用连接池
     * DBCP
     * C3P0
     * Druid(常用)
     * hikariCP(常用)
     */
    public static String url = "jdbc:mysql://localhost:3306/tran_test?serverTimezone=Asia/Shanghai";
    public static String username = "root";
    public static String password = "root";

    public static DataSource getDBCP() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    public static DataSource getC3P0() throws PropertyVetoException {
        ComboPooledDataSource basicDataSource = new ComboPooledDataSource();
        basicDataSource.setDriverClass("com.mysql.jdbc.Driver");
        basicDataSource.setJdbcUrl(url);
        basicDataSource.setUser(username);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    public static DataSource getDruid() throws IOException {
        DataSource dataSource = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("application.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    public static DataSource getDataSrouce(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/simpsons");
        config.setUsername("bart");
        config.setPassword("51mp50n");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }
}
