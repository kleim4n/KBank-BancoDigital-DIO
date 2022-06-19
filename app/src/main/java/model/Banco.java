/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.ContaPF;

/**
 *
 * @author gklei
 */
public class Banco {
    private String name = "KBank";
    private List<ContaPF> accountsPF = new ArrayList<>();
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        int counter = 0;
        String text;
        text = "| Banco " + this.name + "\n";
        String message = "| Cliente|\tTipo de Conta|\tSaldo |\n";
        text += message;
        
        for(ContaPF account: accountsPF){
            message ="| " + account.client.getName() + " |\t " + account.accountsTypes.get(account.accountType) + " |\t " + account.balance + " |\n";
            text += message;
            if(message.length() > counter) counter = message.length();
        }
        
        /*
        for(int i = 0; i < message.length(); i++){
            message += "_";
        }
        */
        return text;
    }
    
    public void addAccount(ContaPF account){
        this.accountsPF.add(account);
    }
    
    public void printGeneralInfos(){
        System.out.println(this.toString());
    }
}
