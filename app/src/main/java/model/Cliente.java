/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author gklei
 */
public class Cliente {
    private static int SEQUENTIAL = 1;
    private int id;
    protected String cpf, name, adress;
    protected Date birthday, signupAt;
    protected ContaPF cc, cp;
 
    public Cliente(){
        this.signupAt = new Date(System.currentTimeMillis());
        this.id = SEQUENTIAL++;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getSingupAt() {
        return signupAt;
    }

    public void setSingupAt(Date singupAt) {
        this.signupAt = singupAt;
    }
    
        public ContaPF getCc() {
        return cc;
    }

    public void setCc(ContaPF cc) {
        this.cc = cc;
    }

    public ContaPF getCp() {
        return cp;
    }

    public void setCp(ContaPF cp) {
        this.cp = cp;
    }
   
}
