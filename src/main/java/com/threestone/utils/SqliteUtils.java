package com.threestone.utils;

import org.sqlite.SQLiteConfig;

import java.io.File;
import java.sql.*;

/**
 * Created by admin on 2019/12/18.
 */
public class SqliteUtils {
    private static final String DRIVER_CLASS_NAME = "org.sqlite.JDBC";

    static {
        try {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建连接
     *
     * @param path 数据库文件绝对路径
     * @return
     */
    public static Connection getConn(String path) {
        Connection conn = null;
        SQLiteConfig config = new SQLiteConfig();
        config.enableLoadExtension(true);
        try {
            String url = "jdbc:sqlite:" + path;
            conn = DriverManager.getConnection(url, config.toProperties());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn, Statement stmt) {
        if (null != stmt) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean executeSQL(String sql, Connection conn) throws Exception {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setQueryTimeout(30);
        boolean result = pstmt.execute();
        return result;
    }

    public static boolean isExistTable(String tableName, Statement stmt) {
        if (tableName == null) {
            return false;
        }
        String sql = "select count(*) as c from Sqlite_master  where type ='table' and name ='" + tableName.trim() + "'";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            while (rs.next()){
                count = rs.getInt("c");
            }
            if(count > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
