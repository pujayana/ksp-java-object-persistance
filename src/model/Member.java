/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pujayana
 */
public class Member extends Customer{
    
    private String noMember;
    
    public Member(String noMember, String nama, String noTelp, int jmlBeli){
        super(nama, noTelp, jmlBeli);
        this.noMember = noMember;
    }
    
    public String getNoMember(){
        return noMember;
    }
    
    public void setNoMember(String noMember){
        this.noMember = noMember;
    }
    
    public double hitungTotal(){
        return getJmlBeli()*5000000*0.85;
    }
    
    public String tampilData(){
        return "\nNo. Member : "+getNoMember()+" || Nama : "+getNama()+" || No.Telp : "+getNoTelp()+" || Jumlah Beli : "+getJmlBeli()+" || Total : "+hitungTotal();
    }
}
