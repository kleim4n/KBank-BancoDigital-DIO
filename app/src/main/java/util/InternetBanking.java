/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Banco;
import model.Cliente;
import model.ContaCorrentePF;
import model.ContaPF;
import model.ContaPoupancaPF;


/**
 *
 * @author gklei
 */
public class InternetBanking {
    Scanner scan = new Scanner(System.in).useDelimiter("\n");
    Banco kbank = new Banco();
    
    public InternetBanking(){
        int opt1 = -1;
        System.out.println("\nBem vindo ao KBank!");
        float cash = 0;
        while(opt1 != 0){
            System.out.print("\nSelecione a opção desejada (1- Login \t2- Cadastro\t3- Consultar clientes do banco\t0- Sair): ");
            opt1 = scan.nextInt();
            switch(opt1){
                case 1:
                    System.out.println("\nTabela dos clientes:");
                    kbank.printClientList();
                    List<Integer> accountsNumbers = new ArrayList<>(kbank.getAccountsNumbers());
                    int opt3 = -1;
                    while(opt3 != 0){
                        System.out.print("\nDigite o número da conta que deseja acessar ou 0 para cancelar: ");
                        opt3 = scan.nextInt();
                        if(accountsNumbers.contains(opt3)){
                            ContaPF account = kbank.getAccount(opt3);
                            System.out.println("\nBem vindo(a) " + account.getClient().getName());
                            opt3 = -1;
                            while(opt3 != 0){
                                System.out.print("\n 1- Depositar\t2- Sacar\t3- Transferir\t4- Consultar saldo\t0- Sair da conta\n\n Digite a operação desejada: ");
                                opt3 = scan.nextInt();
                                switch(opt3){
                                    case 1:
                                        System.out.print("\nDigite o valor que deseja depositar: R$");
                                        cash = scan.nextFloat();
                                        account.deposit(cash);
                                        account.printGeneralInfos();
                                        System.out.println("\nDepósito realizado com sucesso!\n");
                                        opt3 = -1;
                                        break;
                                    case 2:
                                        System.out.print("\nDigite o valor que deseja sacar: R$");
                                        cash = scan.nextFloat();
                                        if(account.withdraw(cash)){
                                            account.printGeneralInfos();
                                            System.out.println("\nSaque realizado com sucesso!\n");
                                            opt3 = -1;
                                            break;
                                        }
                                        else System.out.println("\nSaque não autorizado!\n");
                                        opt3 = -1;
                                        break;
                                    case 3:
                                        opt3 = -1;
                                        kbank.printClientList();
                                        while(opt3 != 0){
                                            System.out.print("\nDigite o número da conta para qual deseja transferir ou 0 para cancelar: ");
                                            opt3 = scan.nextInt();
                                            if(accountsNumbers.contains(opt3)){
                                                System.out.print("\nDigite o valor que deseja transferir: -> R$");
                                                cash = scan.nextFloat();
                                                account.transfer(cash, kbank.getAccount(opt3));
                                                account.printGeneralInfos();
                                                System.out.println("\nTransferência realizado com sucesso!\n");
                                                opt3 = -1;
                                                break;
                                            }
                                        }
                                        opt3 = -1;
                                        break;
                                    case 4:
                                        account.printGeneralInfos();
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
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
                            client.setCc(account);
                            account.setCreditTotal(1000);
                            System.out.println("\nConta criada com sucesso!");
                            if(opt2 == 1) opt2 = 4;
                        } if(opt2 == 2 || opt2 == 3){
                            ContaPoupancaPF account = new ContaPoupancaPF(client);
                            kbank.addAccount(account);
                            client.setCp(account);
                            System.out.println("\nConta criada com sucesso!");
                            opt2 = 4;
                        }
                    }
                    break;
                case 3:
                    kbank.printGeneralInfos();
                    break;
                default:
                    break;
            }
        }
        scan.close();
    }
}
