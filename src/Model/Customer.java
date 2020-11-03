/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author pujayana
 */
public abstract class Customer {
    
    protected String nama;
    protected String noTelp;
    protected int jmlBeli;
    
    public Customer(String nama, String noTelp, int jmlBeli){
        this.nama = nama;
        this.noTelp = noTelp;
        this.jmlBeli = jmlBeli;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNoTelp(){
        return noTelp;
    }
    
    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }
    
    public int getJmlBeli(){
        return jmlBeli;
    }
    
    public void setJmlBeli(int jmlBeli){
        this.jmlBeli = jmlBeli;
    }
    
}
