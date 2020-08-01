package basics.reflect.dao;

import basics.reflect.model.Person;
import basics.reflect.model.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl {
    public static void main(String[] args) {
        List list= getRows("select name,age,grade,email from student", new Object[]{}, Student.class);
        System.out.println((Student)list.get(0));
    }

    public static List getRows(String sql, Object[] params, Class clazz) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List list = new ArrayList();

        //建立连接
        connection = DBUtil.getConection();
        try {
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            //开始执行查询操作
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Object obj = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnName(i + 1);
                    Field field = getField(clazz, columnName);
                    Method method = getMethod(clazz, getSetterName(columnName),field.getType());
                    String filedType = field.getType().getName();
                    invokeSetterByFiledType(filedType, method, obj, columnValue);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList();
    }

    private static Method getMethod(Class clazz, String methodName, Class paramClazz) {
        if (clazz != null) {
            try {
                return clazz.getDeclaredMethod(methodName,paramClazz);
            } catch (NoSuchMethodException e) {
                return getMethod(clazz.getSuperclass(), methodName,paramClazz);
            }
        } else {
            return null;
        }
    }

    private static Field getField(Class clazz, String name) {
        if (clazz != null) {
            try {
                return clazz.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                return getField(clazz.getSuperclass(), name);
            }
        } else {
            return null;
        }
    }

    private static void invokeSetterByFiledType(String filedType, Method method, Object targetObj, Object columnValue) throws InvocationTargetException, IllegalAccessException {
        if (columnValue instanceof Number) {
            Number number = (Number) columnValue;
            switch (filedType) {
                case "int":
                case "java.lang.Integer":
                    method.invoke(targetObj, number.intValue());
                    break;
                case "short":
                case "java.lang.Short":
                    method.invoke(targetObj, number.shortValue());
                    break;
                case "long":
                case "java.lang.Long":
                    method.invoke(targetObj, number.longValue());
                    break;
                case "byte":
                case "java.lang.Byte":
                    method.invoke(targetObj, number.byteValue());
                    break;
                default:
                    method.invoke(targetObj, number);
            }
        } else {
            method.invoke(targetObj, columnValue);
        }

    }

    private static String getSetterName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
