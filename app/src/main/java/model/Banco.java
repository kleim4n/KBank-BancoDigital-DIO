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
        String message = "| ID |\t Cliente |\t Tipo de Conta |\t Saldo |\n";
        text += message;
        
        for(ContaPF account: accountsPF){
            message ="| " + account.client.getId() + "| " + account.client.getName() + " |\t " + account.accountsTypes.get(account.accountType) + " |\t " + account.balance + " |\n";
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
    
    public ContaPF getAccountByIndex(int index){
        return this.accountsPF.get(index);
    }
    
    public ContaPF getAccount(int accountNumber){
        //Caso o script peça um número de conta inexistente o programa retorná um erro.
        return this.accountsPF.get(this.getAccountsNumbers().indexOf(accountNumber));
    }
    
    public void printGeneralInfos(){
        System.out.println(this.toString());
    }
    
    public void printClientList(){
        String text = "| %-8d | %-18s | %-14s |%n";
        System.out.format("+----------+--------------------+----------------+%n");
        System.out.format("| Nº Conta | NOME DO CLIENTE    | Tipo de conta  |%n");
        System.out.format("+----------+--------------------+----------------+%n");
        for(ContaPF account: this.accountsPF){
            System.out.format(text, account.getAccountNumber(), account.getClient().getName(), account.getAccountTypeStr());
        }
        System.out.format("+----------+--------------------+----------------+%n");
    }
    
    public List getAccountsNumbers(){
        List<Integer> accountsNumbers = new ArrayList<>();
        for(ContaPF account: this.accountsPF){
            accountsNumbers.add(account.getAccountNumber());
        }
        return accountsNumbers;
    }
}
