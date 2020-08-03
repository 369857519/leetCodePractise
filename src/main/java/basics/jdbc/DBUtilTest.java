package basics.jdbc;

import basics.reflect.dao.DBUtil;
import basics.reflect.model.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtilTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = PoolTest.getDBCP().getConnection();
        String sql = "select name,age,grade,email from student";
        QueryRunner queryRunner = new QueryRunner();
        Student student = queryRunner.query(connection,sql, new BeanHandler<Student>(Student.class));
        List<Object[]> objects = queryRunner.query(connection,sql,new ArrayListHandler());
    }
}
