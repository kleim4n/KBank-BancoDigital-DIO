/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import util.IContaPF;

/**
 *
 * @author gklei
 */
public abstract class ContaPF implements IContaPF{
    protected Cliente client;
    protected String password;
    protected Date openingDate;
    protected float balance;
    protected boolean active;
    private int agencyNumber = 1, accountNumber;
    protected int accountType;
    private static int SEQUENTIAL = 1;
    protected List<String> accountsTypes = new ArrayList<>(Arrays.asList("Incompleto", "Conta Corrente", "Conta Poupança"));
    
    public ContaPF(Cliente client){
        this.client = client;
        this.accountNumber = SEQUENTIAL++;
        this.openingDate = new Date(System.currentTimeMillis());
        this.active = true;
    }

    public Cliente getClient() {
        return client;
    }
    
    @Override
    public void deposit(float cash) {
        this.balance += cash;
    }
    
    @Override
    public boolean withdraw(float cash) {
        if(this.balance >= cash){
            this.balance -= cash;
            return true;
        }
        else return false;
    }
    
    public void transfer(float cash, int agencyNumber, int accountNumber){
        
    }
    
    @Override
    public void transfer(float cash, ContaPF account){
        if(this.withdraw(cash)) account.deposit(cash);
    }
    
    public int getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(int agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void printGeneralInfos() {
        String text = "| %-8d | %-18s | %-14s | %-8.2f |%n";
        System.out.format("+----------+--------------------+----------------+----------+%n");
        System.out.format("| Nº Conta | NOME DO CLIENTE    | Tipo de conta  | SALDO R$ |%n");
        System.out.format("+----------+--------------------+----------------+----------|%n");
        System.out.format(text, this.getAccountNumber(), this.getClient().getName(), this.getAccountTypeStr(), this.getBalance());
        System.out.format("+----------+--------------------+----------------+----------+%n");
    }

    @Override
    public String toString() {
        //return "ContaPF{" + " balance=" + balance + ", agencyNumber=" + agencyNumber + ", accountNumber=" + accountNumber + ", openingDate=" + openingDate + ", active=" + active + ", accountType=" + accountType + '}';
        String message = "Cliente |\t Tipo de Conta |\t Saldo\n" + this.client.getName() + " |\t " + this.accountsTypes.get(this.accountType) + " |\t " + this.balance + "\n";
        /*
        for(int i = 0; i < message.length(); i++){
            message += "_";
        }
        */
        return message;
    }
    
    public String getAccountTypeStr() {
        return this.accountsTypes.get(this.accountType);
    }
}
