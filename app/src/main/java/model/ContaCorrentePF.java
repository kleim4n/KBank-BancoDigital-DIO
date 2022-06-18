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
    private float creditDisponible, creditUsed;

    public float getCreditDisponible() {
        return creditDisponible;
    }

    public void setCreditDisponible(float creditDisponible) {
        this.creditDisponible = creditDisponible;
    }

    public float getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(float creditUsed) {
        this.creditUsed = creditUsed;
    }
    
}
