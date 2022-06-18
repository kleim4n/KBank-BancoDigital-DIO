/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author gklei
 */
public class Banco {
    private String name = "KBank";
    protected List<ContaPF> accountsPF;
    
    public String getName() {
        return name;
    }
}
