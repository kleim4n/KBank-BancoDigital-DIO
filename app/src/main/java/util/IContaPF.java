/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;

import model.ContaPF;

/**
 *
 * @author gklei
 */
public interface IContaPF {
    void deposit(float cash);
    boolean withdraw(float cash);
    void transfer(float cash, ContaPF account);
    void printGeneralInfos();
}
