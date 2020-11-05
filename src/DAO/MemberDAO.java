/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Member;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pujayana
 */
public class MemberDAO {
    
    public static Connection CON;
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "D:\\Belajar KSP Java\\7 Materi 7 - Java - Object Persistance 1\\GuidedOP_0088\\"+File.separator+"gdOP.accdb";
    
    public void makeConnection(){
        System.out.println("Opening Database...");
        
        try{
            CON = DriverManager.getConnection(url+path);
            System.out.println("Success !");
        } catch(Exception e){
            System.out.println("Error Opening Database..."+e);
        }
    }
    
    public void closeConnection(){
        System.out.println("Clossing Database...");
        
        try {
            CON.close();
            System.out.println("Success !");
        } catch (Exception e) {
            System.out.println("Error Closing Database..."+e);
        }
    }
    
    public void insert(Member m){
        String sql = "INSERT INTO Member(nama, noTelp, jmlBeli) VALUES('"+m.getNama()+"', '"+m.getNoTelp()+"', '"+m.getJmlBeli()+"')";
        
        System.out.println("Adding Member...");
        System.out.println(sql);
        
        try {
            Statement s = CON.createStatement();
            int result = s.executeUpdate(sql);
            System.out.println("Added"+result+"Member\n");
            s.close();
        } catch (Exception e) {
            System.out.println("Error Insert Member...");
            System.out.println(e);
        }
    }
    
    public List<Member> showMember(){
        String sql = "SELECT * FROM Member";
        System.out.println("Mengambil Data Member...");
        
        List<Member> list = new ArrayList<>();
        
        try {
            Statement s = CON.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            if( rs != null ){
                while( rs.next() ){
                    Member m = new Member(rs.getString("noMember"), rs.getString("nama"), rs.getString("noTelp"), Integer.parseInt(rs.getString("jmlBeli")));
                    list.add(m);
                }
            }
            
            rs.close();
            s.close();
            
        } catch (Exception e) {
            System.out.println("Error Reading Database...");
            System.out.println(e);
        }
        
        return list;
    }
    
    public Member searchData(String key){
        String sql = "SELECT * FROM Member WHERE (noMember LIKE '%"+key+"%') OR (nama LIKE '%"+key+"%') OR (noTelp LIKE '%"+key+"%') OR (jmlBeli LIKE '%"+key+"%')";
        System.out.println("Searching Data Member...");
        
        Member m = null;
        
        try {
            Statement s = CON.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            if( rs != null ){
                while( rs.next() ){
                    m = new Member(rs.getString("noMember"), rs.getString("nama"), rs.getString("noTelp"), Integer.parseInt(rs.getString("jmlBeli")));
                }
            }
            
            rs.close();
            s.close();
            
        } catch (Exception e) {
            System.out.println("Error Reading Database...");
            System.out.println(e);
        }
        
        return m;
    }
    
    public void updateMember(Member m, String noMember){
        String sql = "UPDATE Member SET nama = '"+m.getNama()+"', noTelp = '"+m.getNoTelp()+"', jmlBeli = '"+m.getJmlBeli()+"' WHERE noMember = '"+noMember+"'";
        
        System.out.println("Editing Member...");
        
        try {
            Statement s = CON.createStatement();
            int result = s.executeUpdate(sql);
            System.out.println("Edit "+result+"Member\n"+noMember);
            s.close();
        } catch (Exception e) {
            System.out.println("Error Editing Member...");
            System.out.println(e);
        }
    }
    
    public void deleteMember(String noMember){
        String sql = "DELETE FROM Member WHERE noMember = '"+noMember+"'";
        
        System.out.println("Deleting Member...");
        
        try {
            Statement s = CON.createStatement();
            int result = s.executeUpdate(sql);
            System.out.println("Delete "+result+"Member\n");
            s.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Member...");
            System.out.println(e);
        }
    }
    
}
