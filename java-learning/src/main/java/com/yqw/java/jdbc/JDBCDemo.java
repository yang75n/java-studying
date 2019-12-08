package com.yqw.java.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCDemo {

    /**
     * create table user(
     * id int NOT NULL PRIMARY KEY auto_increment,
     * name VARCHAR(50) ,
     * age int
     * ) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
     *
     * @throws ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @Test
    public void testPreparedStatement() throws ClassNotFoundException, SQLException {


        //3.操作数据库，实现增删改查
        //获取连接
        Connection conn = getConnection();

        String sql = "INSERT INTO user (name, age) VALUES ('qiwen', 22)";
        //预编译SQL，减少sql执行
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int ret = pstmt.executeUpdate(sql);
        System.out.printf("影响了%d条数据\n", ret);

        //执行SQL
        ResultSet rs2 = pstmt.executeQuery("SELECT * FROM user");
        //如果有数据，rs.next()返回true
        while (rs2.next()) {
            System.out.println(rs2.getString("name") + " 年龄：" + rs2.getInt("age"));
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3307/yqw?serverTimezone=Asia/Shanghai&characterEncoding=utf8";
        String username = "root";
        String password = "admin";
        //1. 加载驱动
        Class.forName(className);
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    /**
     * create table user(
     * id int NOT NULL PRIMARY KEY auto_increment,
     * name VARCHAR(50) ,
     * age int
     * ) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
     *
     * @throws ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @Test
    public void testStatement() throws ClassNotFoundException, SQLException {


        Connection conn = getConnection();
        //3.操作数据库，实现增删改查

        String sql = "INSERT INTO user (name, age) VALUES ('qiwen', 23)";
        //创建Statement
        Statement stmt = conn.createStatement();
        int ret = stmt.executeUpdate(sql);
        System.out.printf("影响了%d条数据\n", ret);
        //执行SQL
        ResultSet rs2 = stmt.executeQuery("SELECT * FROM user");

        //如果有数据，rs.next()返回true
        while (rs2.next()) {
            System.out.println(rs2.getString("name") + " 年龄：" + rs2.getInt("age"));
        }
    }

    /**
     * 事务
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void testJDBCTransaction() throws ClassNotFoundException, SQLException {
        //获取连接
        Connection conn = getConnection();
        System.out.println(conn.getAutoCommit() + " 级别:" + conn.getTransactionIsolation());
        //关闭自动提交模式
        conn.setAutoCommit(false);
        String sql = "INSERT INTO user (name, age) VALUES ('qiwen', 24)";
        //预编译SQL，减少sql执行
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int ret = pstmt.executeUpdate(sql);
        //提交事务
        conn.commit();
        System.out.printf("影响了%d条数据\n", ret);


        //执行SQL
        ResultSet rs2 = pstmt.executeQuery("SELECT * FROM user");
        //如果有数据，rs.next()返回true
        while (rs2.next()) {
            System.out.println(rs2.getString("name") + " 年龄：" + rs2.getInt("age"));
        }
    }
}
