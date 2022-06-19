/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;
import model.Banco;
import model.Cliente;
import model.ContaCorrentePF;
import model.ContaPoupancaPF;


/**
 *
 * @author gklei
 */
public class InternetBanking {
    Scanner scan = new Scanner(System.in);
    Banco kbank = new Banco();
    
    public InternetBanking(){
        int opt1 = -1;
        System.out.println("Bem vindo ao KBank!\n");
        while(opt1 != 3){
            System.out.print("\nSelecione a opção desejada (1- Login \t2- Cadastro\t3- Sair): ");
            opt1 = scan.nextInt();
            switch(opt1){
                case 1:
                    kbank.printGeneralInfos();
                    break;
                case 2:
                    Cliente client = new Cliente();
                    System.out.print("\nCadastro de novo cliente\nNome: ");
                    String name = scan.next();
                    client.setName(name);
                    int opt2 = 0;
                    while(opt2 != 4){
                        System.out.print("\nQue tipo de conta deseja (1- Conta corrente\t2- Conta Poupança\t3- Ambas\t4- Cancelar): ");
                        opt2 = scan.nextInt();
                        if(opt2 == 1 || opt2 == 3){
                            ContaCorrentePF account = new ContaCorrentePF(client);
                            kbank.addAccount(account);
                            System.out.println("\nConta criada com sucesso!");
                        } if(opt2 == 2 || opt2 == 3){
                            ContaPoupancaPF account = new ContaPoupancaPF(client);
                            kbank.addAccount(account);
                            System.out.println("\nConta criada com sucesso!");
                            opt2 = 4;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
