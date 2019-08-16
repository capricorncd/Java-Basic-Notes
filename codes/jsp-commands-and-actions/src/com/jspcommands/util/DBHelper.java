package com.jspcommands.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
  // ���ݿ�����
  // private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
  private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver"; //����
  // �������ݿ��URL��ַ
  // private static final String DB_URL = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&charaterEncoding=UTF-8";
  private static final String DB_URL = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
  // ���ݿ��û���
  private static final String USER_NAME = "system";
  // ���ݿ�����
  private static final String PASSWORD = "admin";
  // 
  private static Connection conn = null;
  
  // ��̬����鸺���������
  static
  {
    try {
      Class.forName(ORACLE_DRIVER);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  // ����ģʽ�������ݿ����Ӷ���
  public static Connection getConnection() {
    if (conn == null) {
      try {
        conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return conn;
  }
  
  public static void main(String[] args) {
    try {
      Connection conn = DBHelper.getConnection();
      if (conn != null) {
        System.out.println("���ݿ����ӳɹ�!");
      } else {
        System.out.println("���ݿ�����ʧ��!");
      }
    } catch(Exception e) {
      System.out.println("���ݿ�����ʧ�ܣ������쳣��");
      e.printStackTrace();
    }
  }
}
