package com;

import java.sql.*;


public class JDBCtest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //jdbc:mysql://主机名或IP抵制：端口号/数据库名?useUnicode=true&characterEncoding=UTF-8&useSSL=true
        String URL = "jdbc:sqlserver://localhost;databaseName=userdb;";
        String USER = "sa";
        String PASSWORD = "123456";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //1.加载驱动
        Class.forName(driver);
        //2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        //4.处理数据库的返回结果(使用ResultSet类)
        System.out.println(conn);
    }
}