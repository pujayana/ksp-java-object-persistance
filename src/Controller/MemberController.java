/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MemberDAO;
import Model.Member;
import java.util.List;

/**
 *
 * @author pujayana
 */
public class MemberController {
    
    MemberDAO mDAO;
    
    public MemberController(){
        mDAO = new MemberDAO();
    }
    
    public void insertMember(Member M){
        mDAO.makeConnection();
        mDAO.insert(M);
        mDAO.closeConnection();
    }
    
    public void updateMember(Member M, String noMember){
        mDAO.makeConnection();
        mDAO.updateMember(M, noMember);
        mDAO.closeConnection();
    }
    
    public void deleteMember(String noMember){
        mDAO.makeConnection();
        mDAO.deleteMember(noMember);
        mDAO.closeConnection();
    }
    
    public Member findMember(String noMember){
        Member m;
        mDAO.makeConnection();
        m = mDAO.searchData(noMember);
        mDAO.closeConnection();
        return m;
    }
    
    public List<Member> showMember(){
        mDAO.makeConnection();
        List<Member> listMember = mDAO.showMember();
        return listMember;
    }
    
}
