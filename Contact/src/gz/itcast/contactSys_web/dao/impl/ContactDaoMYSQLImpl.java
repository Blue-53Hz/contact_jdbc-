package gz.itcast.contactSys_web.dao.impl;

import gz.itcast.contactSys_web.dao.ContactDao;
import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author huoyueyang
 * @date 2019/8/1 15:28
 * @email mataszhang@163.com
 */
public class ContactDaoMYSQLImpl implements ContactDao {

    Statement stmt=null;


    @Override
    public void addContact(Contact contact) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "insert into contact_list(id,name,gender,phone,email,address) values(?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, UUID.randomUUID().toString());
            stmt.setString(2, contact.getName());
            stmt.setString(3, contact.getGender());
            stmt.setString(4, contact.getPhone());
            stmt.setString(5, contact.getEmail());
            stmt.setString(6, contact.getAddress());
            //执行
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.close(stmt, conn);
        }
    }

    @Override
    public void updateContact(Contact contact) {


        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "update contact_list set name=?,gender=?,phone=?,email=?,address=? where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getGender());
            stmt.setString(3, contact.getPhone());
            stmt.setString(4, contact.getEmail());
            stmt.setString(5, contact.getAddress());
            stmt.setString(6, contact.getId());
            //执行
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.close(stmt, conn);
        }


    }

    @Override
    public List<Contact> findAll() {

        List<Contact> list=new ArrayList<Contact>();
        Contact contact=new Contact();
        //获取连接
        Connection conn= JdbcUtil.getConnection();

        try {
            stmt=conn.createStatement();
            String sql="select *from contact_list";
            ResultSet rs=stmt.executeQuery(sql);

          while (rs.next()){
              Contact con = new Contact();
              con.setId(rs.getString("id"));
              con.setName(rs.getString("name"));
              con.setGender(rs.getString("gender"));
              con.setPhone(rs.getString("phone"));
              con.setEmail(rs.getString("email"));
              con.setAddress(rs.getString("address"));

              list.add(con);
          }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    @Override
    public Contact findById(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from contact_list where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            //执行
            rs = stmt.executeQuery();

            Contact con = null;
            if(rs.next()){
                con = new Contact();
                con.setId(rs.getString("id"));
                con.setName(rs.getString("name"));
                con.setGender(rs.getString("gender"));
                con.setPhone(rs.getString("phone"));
                con.setEmail(rs.getString("email"));
                con.setAddress(rs.getString("address"));
            }
            return con;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.close(rs,stmt, conn);
        }
    }

    @Override
    public void deleteContact(String id) {


        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "delete from contact_list where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            //执行
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.close(stmt, conn);
        }

    }

    @Override
    public boolean checkNameExist(String name) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select * from contact_list where name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            //执行
            rs = stmt.executeQuery();

            return rs.next();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.close(rs,stmt, conn);
        }



    }
}