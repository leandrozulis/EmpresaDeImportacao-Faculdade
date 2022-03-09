package com.mycompany.empresadeimportacao;

import java.util.Scanner;

public class MenuPrincipal {

    public static void menu() {
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          MENU PRINCIPAL");
        System.out.println("[1] CADASTRO DE PRODUTOS");
        System.out.println("[2] MOVIMENTAÇÃO");
        System.out.println("[3] REAJUSTE DE PREÇOS");
        System.out.println("[4] RELATÓRIOS");
        System.out.println("[0] FINALIZAR");
        System.out.println("Opcao: ");
        
    }

    public static void main(String[] args) {
        int opcao;
        int opcaoCadastro;
        int opcaoMovimentação;
        int opcaoReajuste;
        int opcaoRelatorio;
        
        Scanner entrada = new Scanner(System.in);
        Cadastro c = new Cadastro();

        menu();
        do {
            
            opcao = entrada.nextInt();
            
            switch (opcao) {
                case 1:
                    do {
                        c.menuCadastro();
                        opcaoCadastro = entrada.nextInt();
                        
                        switch (opcaoCadastro) {
                            case 1: c.inclui(); break;
                            case 2: c.altera(); break;
                            case 3: c.consultaCadastro(); break;
                            case 4: c.exclui(); break;
                            case 0: menu(); break;
                            default: System.out.println("Valor inválido!!");
                        }
                        
                    } while (opcaoCadastro != 0);
                    
                    break;

                case 2:
                    do {
                        c.menuMovimentação();
                        opcaoMovimentação = entrada.nextInt();
                        
                        switch (opcaoMovimentação) {
                            case 1: c.entrada(); break;
                            case 2: c.saida(); break;
                            case 0: menu(); break;
                            default: System.out.println("Valor inválido!!");
                        }
                        
                    } while (opcaoMovimentação != 0);
                    
                    break;

                case 3: 
                    do {
                        c.menuReajuste();
                        opcaoReajuste = entrada.nextInt();
                        
                        switch (opcaoReajuste) {
                            case 1: c.reajuste(); break;
                            case 0: menu(); break;
                            default: System.out.println("Valor inválido!!");
                        }
                        
                    } while (opcaoReajuste != 0);    
                    
                    break;

                case 4:
                    do {
                        c.menuRelatorio();
                        opcaoRelatorio = entrada.nextInt();
                        
                        switch (opcaoRelatorio) {
                            case 1: c.relatorio(); break;
                            case 0: menu(); break;
                        }
                    } while (opcaoRelatorio != 0);
                    
                    break;
                            
                default: 
                    System.out.println("VALOR INVÁLIDO!!");
                    menu();
            }
        } while (opcao != 0);
    }
}