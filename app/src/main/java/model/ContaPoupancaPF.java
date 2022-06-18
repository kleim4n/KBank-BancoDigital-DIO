/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gklei
 */
public class ContaPoupancaPF extends ContaPF{
    private float yield;
    
    public ContaPoupancaPF(Cliente client){
        super(client);
        super.accountType = 2;
    }

    public float getYield() {
        return yield;
    }

    public void setYield(float yield) {
        this.yield = yield;
    }
}
