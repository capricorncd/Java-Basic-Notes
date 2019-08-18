package com.jspcommands.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jspcommands.entity.JspCookieItem;
import com.jspcommands.util.DBHelper;

// ��Ʒҵ���߼���
public class JspCookieItemDAO {
  // ��ȡ������Ʒ�б�
  public ArrayList<JspCookieItem> getAllItems() {
    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    ArrayList<JspCookieItem> list = new ArrayList<JspCookieItem>();
    
    // System.out.println("=============ArrayList���波�Ի�ȡ����");
    
    try {
      conn = DBHelper.getConnection();
      String sql = "select * from jsp_cookie_items";
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      // System.out.println("=============ִ��try");
      while(rs.next()) {
        JspCookieItem item = new JspCookieItem();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setCity(rs.getString("city"));
        item.setPrice(rs.getDouble("price"));
        item.setStock(rs.getInt("stock"));
        item.setCover(rs.getString("cover"));
        System.out.println("=========whileѭ����: " + rs.getString("name"));
        list.add(item);
      }
      return list;
    } catch(Exception ex) {
      ex.printStackTrace();
    } finally {
      // �ͷ����ݼ�����
      if (rs != null) {
        try {
          rs.close();
          rs = null;
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
      // �ͷ�������
      if (stat != null) {
        try {
          stat.close();
          stat = null;
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
    }
    
    return null;
  }
  
  /**
   * ��ȡ��Ʒ����
   * @param id
   * @return
   */
  public JspCookieItem getDetailById(int id) {
    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet rs = null;
    try {
      conn = DBHelper.getConnection();
      String sql = "select * from jsp_cookie_items where id=?";
      stat = conn.prepareStatement(sql);
      stat.setInt(1, id);
      rs = stat.executeQuery();
      // System.out.println("=============ִ��try");
      if(rs.next()) {
        JspCookieItem item = new JspCookieItem();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setCity(rs.getString("city"));
        item.setPrice(rs.getDouble("price"));
        item.setStock(rs.getInt("stock"));
        item.setCover(rs.getString("cover"));
        return item;
      }
    } catch(Exception ex) {
      ex.printStackTrace();
    } finally {
      // �ͷ����ݼ�����
      if (rs != null) {
        try {
          rs.close();
          rs = null;
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
      // �ͷ�������
      if (stat != null) {
        try {
          stat.close();
          stat = null;
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
    }
    
    return null;
  }
  
  /**
   * get ��ȡ��������5����¼
   * @param records
   * @return
   */
  public ArrayList<JspCookieItem> getViewList(String records) {
    ArrayList<JspCookieItem> list = new ArrayList<JspCookieItem>();
    if (records != null && records.length() > 0) {
      String[] arr = records.split("#");
      int id;
      for (int i = arr.length - 1; i >= 0; i--) {
        id = arr[i] != "" ? Integer.parseInt(arr[i]) : 0;
        if (id > 0) list.add(getDetailById(id));
      }
    }
    return list;
  }
}
