/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gklei
 */
public class ContaCorrentePF extends ContaPF{
    private float creditTotal;
    
    public ContaCorrentePF(Cliente client){
        super(client);
        super.accountType = 1;
    }
    
    @Override
    public boolean withdraw(float cash) {
        if(this.balance + this.creditTotal >= cash){
            this.balance -= cash;
            this.printGeneralInfos();
            return true;
        }
        this.printGeneralInfos();
        return false;
    }
    
    @Override
    public void transfer(float cash, ContaPF account){
        if(this.withdraw(cash)) account.deposit(cash);
    }
    
    public float getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(float creditTotal) {
        this.creditTotal = creditTotal;
    }
    
    public float getCreditDisponible() {
        if(this.balance < 0) return creditTotal + this.balance;
        else return creditTotal;
    }
}