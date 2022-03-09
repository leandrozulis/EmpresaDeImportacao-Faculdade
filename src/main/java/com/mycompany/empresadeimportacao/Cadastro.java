package com.mycompany.empresadeimportacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro {

    ArrayList<Cadastro> produtos = new ArrayList();

    Scanner scanner = new Scanner(System.in);

    private String nomeProduto;
    private double precoProduto;
    private String unidade;
    private int quantidade;
    private String confirmaOperacao;
    private String repetirOperacao;

    // ======== CADASTRO DOS PRODUTOS ========
    public void menuCadastro() {

        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          CADASTRO DE PRODUTOS");
        System.out.println("[1] INCLUSÃO");
        System.out.println("[2] ALTERAÇÃO");
        System.out.println("[3] CONSULTA");
        System.out.println("[4] EXCLUSÃO");
        System.out.println("[0] RETORNAR");
        System.out.println("Opcao: ");

    }

    public void inclui() {

        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          INCLUSÃO DE PRODUTOS");

        System.out.println("DESCRIÇÃO: ");
        boolean nomeIgual = false;
        String nomeProduto = scanner.next();
        for (int i = 0; i < produtos.size(); i++) {
            Cadastro uTemp = produtos.get(i);
            if (nomeProduto.equals(uTemp.getNome())) {
                nomeIgual = true;
                System.out.println("Produto já cadastrado");
                System.out.println("Informe outra descrição!!");
                nomeProduto = scanner.next();
                break;
            }
        }
        System.out.println("");

        System.out.println("PREÇO: ");
        String precoProduto = scanner.next();
        precoProduto = precoProduto.replace(',', '.');
        double numero = Double.parseDouble(precoProduto);
        if (numero <= 0) {
            System.out.println("Informe um valor maior que Zero!!");
            numero = scanner.nextInt();
        }
        System.out.println("");

        System.out.println("UNIDADE MEDIDA: ");
        String unidade = scanner.next();
        System.out.println("");

        System.out.println("QUANTIDADE: ");
        int quantidade = scanner.nextInt();
        if (quantidade < 0) {
            System.out.println("Informe uma quantidade maior ou igual a Zero!!");
            quantidade = scanner.nextInt();
        }
        System.out.println("");

        System.out.println("CONFIRMA INCLUSÃO (sim/nao)?");
        String confirmaOperacao = scanner.next();

        switch (confirmaOperacao) {
            case "sim": {

                boolean nomeIguall = false;
                for (int i = 0; i < produtos.size(); i++) {
                    Cadastro uTemp = produtos.get(i);
                    if (nomeProduto.equals(uTemp.getNome())) {
                        nomeIguall = true;
                        System.out.println("Tentativa de cadastro de produto duplicado!!");
                    }
                    if (numero <= 0) {
                        nomeIguall = true;
                        System.out.println("Tentativa de cadastro de produto com valor menor ou igual a zero!!");
                    }
                    if (quantidade < 0) {
                        nomeIguall = true;
                        System.out.println("Tentativa de cadastro de produto com quantidade menor que zero!!");
                        System.out.println("Cadastro Cancelado!!");

                        break;
                    }
                    System.out.println("Cadastro Cancelado!!");

                }

                if (!nomeIguall) {
                    System.out.println("");

                    Cadastro c = new Cadastro();
                    c.setNome(nomeProduto);
                    c.setPreco(numero);
                    c.setUnidade(unidade);
                    c.setQuantidade(quantidade);

                    produtos.add(c);
                    System.out.println("Produto cadastrado!!");
                    System.out.println("");
                }

                System.out.println("REPITIR OPERAÇÃO (sim/nao)?");
                String repetirOperacao = scanner.next();
                switch (repetirOperacao) {
                    case "sim":
                        inclui();
                        System.out.println("");
                        break;
                    case "nao":
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Digite uma resposta válida!");
                }
                break;

            }
            case "nao": {
                System.out.println("O produto não foi cadastrado");
                System.out.println("");
                System.out.println("REPITIR OPERAÇÃO (sim/nao)?");
                String repetirOperacao = scanner.next();
                switch (repetirOperacao) {
                    case "sim":
                        inclui();
                        System.out.println("");
                        break;
                    case "nao":
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Digite uma resposta válida!");
                }
                break;
            }
            default: {
                System.out.println("Digite uma resposta válida!");
            }
        }
    }

    public void altera() {
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          ALTERAÇÃO DE PRODUTOS");
        System.out.println("Digite o nome do produto:");
        String nomeBusca = scanner.next();

        boolean encontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Cadastro uTemp = produtos.get(i);
            if (nomeBusca.equals(uTemp.getNome())) {
                encontrado = true;
                System.out.println("Produto " + i + " | "
                        + "\t\tDescrição: " + uTemp.getNome()
                        + "\t\tPreço: " + uTemp.getPreco()
                        + "\t\tUnidade Medida: " + uTemp.getUnidade()
                        + "\t\tQuantidade: " + uTemp.getQuantidade());
                System.out.println("");
                System.out.println("Digite um novo preco: ");
                String precoProduto = scanner.next();
                precoProduto = precoProduto.replace(',', '.');
                double numero = Double.parseDouble(precoProduto);
                if (numero <= 0) {
                    System.out.println("Informe um valor maior que Zero!!");
                    numero = scanner.nextInt();
                }
                System.out.println("");

                System.out.println("Digite uma nova unidade de medida: ");
                String novaUnidade = scanner.next();
                System.out.println("Digite uma nova quantidade: ");
                int novaQuantidade = scanner.nextInt();
                if (novaQuantidade < 0) {
                    System.out.println("Informe uma quantidade maior ou igual a Zero!!");
                    novaQuantidade = scanner.nextInt();
                }
                System.out.println("");

                System.out.println("CONFIRMA ALTERAÇÃO (sim/nao)?: ");
                String confirmaOperacao = scanner.next();
                switch (confirmaOperacao) {
                    case "sim":

                        boolean nomeIguall = false;
                        for (int a = 0; a < produtos.size(); a++) {
                            if (numero <= 0) {
                                nomeIguall = true;
                                System.out.println("Tentativa de alteração de produto com valor menor ou igual a zero!!");
                            }
                            if (novaQuantidade < 0) {
                                nomeIguall = true;
                                System.out.println("Tentativa de alteração de produto com quantidade menor que zero!!");
                            }
                            break;
                        }

                        if (!nomeIguall) {

                            Cadastro c = produtos.get(i);
                            c.setPreco(numero);
                            c.setUnidade(novaUnidade);
                            c.setQuantidade(novaQuantidade);
                            System.out.println("Produto alterado!!");
                            System.out.println("");

                        }
                        break;

                    case "nao":
                        System.out.println("Produto não foi alterado");
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Digite uma resposta válida!");
                }

            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado!");
            System.out.println("");
        }

        System.out.println("REPITIR OPERAÇÃO (sim/nao)?");
        String repetirOperacao = scanner.next();
        switch (repetirOperacao) {
            case "sim":
                altera();
                System.out.println("");
                break;
            case "nao":
                System.out.println("");
                break;
            default:
                System.out.println("Digite uma resposta válida!");
        }
    }

    public void consultaCadastro() {

        System.out.println("==== PRODUTOS CADASTRADOS ====");
        System.out.println("Digite o nome do produto:");
        String nomeBusca = scanner.next();
        System.out.println("");

        boolean encontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Cadastro uTemp = produtos.get(i);
            if (nomeBusca.equals(uTemp.getNome())) {
                encontrado = true;
                System.out.println("Produto " + i + " | "
                        + "\t\tDescrição: " + uTemp.getNome()
                        + "\t\tPreço: " + uTemp.getPreco()
                        + "\t\tUnidade Medida: " + uTemp.getUnidade()
                        + "\t\tQuantidade: " + uTemp.getQuantidade());
                System.out.println("");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado!");
            System.out.println("");
        }

        System.out.println("REPITIR OPERAÇÃO (sim/nao)?");
        String repetirOperacao = scanner.next();
        switch (repetirOperacao) {
            case "sim":
                consultaCadastro();
                System.out.println("");
                break;
            case "nao":
                System.out.println("");
                break;
            default:
                System.out.println("Digite uma resposta válida!");
        }

    }

    public void exclui() {
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          EXCLUSÃO DE PRODUTOS");

        System.out.println("Digite o nome do produto:");
        String nomeExcluir = scanner.next();
        System.out.println("");

        boolean encontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Cadastro uTemp = produtos.get(i);

            if (nomeExcluir.equals(uTemp.getNome())) {
                encontrado = true;
                System.out.println("Produto " + i + " | "
                        + "\t\tDescrição: " + uTemp.getNome()
                        + "\t\tPreço: " + uTemp.getPreco()
                        + "\t\tUnidade Medida: " + uTemp.getUnidade()
                        + "\t\tQuantidade: " + uTemp.getQuantidade());
                System.out.println("");

                System.out.println("Informe o número do produto para excluir!!");
                int excluirProduto = scanner.nextInt();
                scanner.nextLine();
                System.out.println("");

                System.out.println("CONFIRMA EXCLUSÃO (sim/nao)?: ");
                String confirmaOperacao = scanner.next();
                switch (confirmaOperacao) {
                    case "sim":
                        produtos.remove(excluirProduto);
                        System.out.println("O produto foi excluído!");
                        System.out.println("");
                        break;
                    case "nao":
                        System.out.println("Produto não foi excluído");
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Digite uma resposta válida!");
                }
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado!");
            System.out.println("");
        }

        System.out.println("REPITIR OPERAÇÃO (sim/nao)?");
        String repetirOperacao = scanner.next();
        switch (repetirOperacao) {
            case "sim":
                exclui();
                System.out.println("");
                break;
            case "nao":
                System.out.println("");
                break;
            default:
                System.out.println("Digite uma resposta válida!");
        }

    }

    // ======== MOVIMENTAÇÃO DOS PRODUTOS ========
    public void menuMovimentação() {

        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          MOVIMENTAÇÃO");
        System.out.println("[1] ENTRADA");
        System.out.println("[2] SAIDA");
        System.out.println("[0] RETORNAR");
        System.out.println("Opcao: ");

    }

    public void entrada() {

        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          ENTRADA DE PRODUTOS");
        System.out.println("Procura de Produtos:");
        String nomeBusca = scanner.next();
        System.out.println("");

        boolean encontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Cadastro uTemp = produtos.get(i);
            if (nomeBusca.equals(uTemp.getNome())) {
                encontrado = true;
                System.out.println("Produto " + i + " | "
                        + "\t\tDescrição: " + uTemp.getNome()
                        + "\t\tPreço: " + uTemp.getPreco()
                        + "\t\tUnidade Medida: " + uTemp.getUnidade()
                        + "\t\tQuantidade: " + uTemp.getQuantidade());
                System.out.println("");
                System.out.println("\tNome: " + uTemp.getNome());
                System.out.println("\tQuantidade Atual: " + uTemp.getQuantidade());
                System.out.println("");
                System.out.println("Informe a quantidade da entrada");
                int novaQuantidade = scanner.nextInt();

                if (novaQuantidade < 0) {
                    System.out.println("QUANTIDADE INFORMADA COM VALOR NEGATIVO!!");
                    System.out.println("INFORME UM NOVO VALOR: ");
                    novaQuantidade = scanner.nextInt();
                    novaQuantidade += uTemp.getQuantidade();

                    System.out.println("Quantidade final: " + novaQuantidade);
                    System.out.println("");

                    System.out.println("CONFIRMA ENTRADA (sim/nao)?: ");
                    String confirmaOperacao = scanner.next();
                    switch (confirmaOperacao) {
                        case "sim": {
                            boolean alteracao = false;
                            for (int b = 0; b < produtos.size(); b++) {
                                Cadastro entrada = produtos.get(b);
                                if (novaQuantidade < entrada.getQuantidade()) {
                                    alteracao = true;
                                    System.out.println("Tentativa de entrada informando valor negativo");
                                    break;
                                }

                            }

                            if (!alteracao) {

                                Cadastro c = produtos.get(i);
                                c.setQuantidade(novaQuantidade);
                                System.out.println("Entrada realizada corretamente!!");
                                System.out.println("");
                                break;

                            }

                        }
                        case "nao": {
                            System.out.println("Entrada cancelada!!");
                            System.out.println("");
                            break;

                        }
                        default: {
                            System.out.println("Digite uma resposta válida!");
                            confirmaOperacao = scanner.next();

                        }
                    }
                    break;
                }

                if (novaQuantidade > 0) {
                    novaQuantidade += uTemp.getQuantidade();

                    System.out.println("Quantidade final: " + novaQuantidade);
                    System.out.println("");

                    System.out.println("CONFIRMA ENTRADA (sim/nao)?: ");
                    String confirmaOperacao = scanner.next();
                    switch (confirmaOperacao) {
                        case "sim": {
                            Cadastro c = produtos.get(i);
                            c.setQuantidade(novaQuantidade);
                            System.out.println("Entrada realizada corretamente!!");
                            System.out.println("");
                            break;

                        }
                        case "nao": {
                            System.out.println("Entrada cancelada!!");
                            System.out.println("");
                            break;

                        }
                        default: {
                            System.out.println("Digite uma resposta válida!");

                        }
                    }
                }
                break;
            }

        }

        if (!encontrado) {
            System.out.println("Produto não encontrado!");
            System.out.println("");
        }

        System.out.println("REPITIR OPERAÇÃO (sim/nao)?");
        String repetirOperacao = scanner.next();
        switch (repetirOperacao) {
            case "sim":
                entrada();
                System.out.println("");
                break;
            case "nao":
                System.out.println("");
                break;
            default:
                System.out.println("Digite uma resposta válida!");
        }

    }

    public void saida() {

        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          ENTRADA DE PRODUTOS");
        System.out.println("Procura de Produtos:");
        String nomeBusca = scanner.next();

        boolean encontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Cadastro uTemp = produtos.get(i);
            if (nomeBusca.equals(uTemp.getNome())) {
                encontrado = true;
                System.out.println("Produto " + i + " | "
                        + "\t\tDescrição: " + uTemp.getNome()
                        + "\t\tPreço: " + uTemp.getPreco()
                        + "\t\tUnidade Medida: " + uTemp.getUnidade()
                        + "\t\tQuantidade: " + uTemp.getQuantidade());
                System.out.println("");
                System.out.println("\tNome: " + uTemp.getNome());
                System.out.println("\tQuantidade Atual: " + uTemp.getQuantidade());
                System.out.println("");

                System.out.println("Informe a quantidade da saída");
                int novaQuantidade = scanner.nextInt();

                if (novaQuantidade < 0) {
                    System.out.println("Quantidade informada negativa!!");
                    System.out.println("Informe uma nova quantidade!!");
                    novaQuantidade = scanner.nextInt();
                }

                novaQuantidade = uTemp.getQuantidade() - novaQuantidade;

                System.out.println("");

                if (novaQuantidade < 0) {
                    System.out.println("Quantidade final: " + novaQuantidade);
                    System.out.println("PRODUTO COM QUANTIDADE NEGATIVA!!");
                    System.out.println("DESEJA CONTINUAR (sim/nao)?: ");
                    String confirmaOperacao = scanner.next();
                    switch (confirmaOperacao) {
                        case "sim": {
                            Cadastro c = produtos.get(i);
                            c.setQuantidade(novaQuantidade);
                            System.out.println("Saida realizada corretamente!!");
                            System.out.println("");
                            break;

                        }
                        case "nao": {
                            System.out.println("Saida cancelada!!");
                            System.out.println("");
                            break;

                        }
                        default: {
                            System.out.println("Digite uma resposta válida!");

                        }
                    }
                    break;
                }

                if (novaQuantidade > 0) {
                    System.out.println("Quantidade final: " + novaQuantidade);
                    System.out.println("");
                    System.out.println("CONFIRMA SAIDA (sim/nao)?: ");
                    String confirmaOperacao = scanner.next();
                    switch (confirmaOperacao) {
                        case "sim": {
                            boolean saida = false;
                            for (int c = 0; c < produtos.size(); c++) {
                                Cadastro saidaProduto = produtos.get(c);
                                if (novaQuantidade > saidaProduto.getQuantidade()) {
                                    saida = true;
                                    System.out.println("Tentativa de saida somando valor!!");
                                    break;
                                }
                            }

                            if (!saida) {

                                Cadastro c = produtos.get(i);
                                c.setQuantidade(novaQuantidade);
                                System.out.println("Saida realizada corretamente!!");
                                System.out.println("");
                                break;

                            }

                        }
                        case "nao": {
                            System.out.println("Saida cancelada!!");
                            System.out.println("");
                            break;

                        }
                        default: {
                            System.out.println("Digite uma resposta válida!");

                        }
                    }
                }
                break;
            }

        }

        if (!encontrado) {
            System.out.println("Produto não encontrado!");
            System.out.println("");
        }

        System.out.println("REPITIR OPERAÇÃO (sim/nao)?");
        String repetirOperacao = scanner.next();
        switch (repetirOperacao) {
            case "sim":
                saida();
                System.out.println("");
                break;
            case "nao":
                System.out.println("");
                break;
            default:
                System.out.println("Digite uma resposta válida!");
        }

    }

    // ======== REAJUSTE DE PREÇOS ========
    public void menuReajuste() {

        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          REAJUSTE DE PREÇOS");
        System.out.println("[1] REALIZAR REAJUSTE");
        System.out.println("[0] RETORNAR");
        System.out.println("Opcao: ");

    }

    public void reajuste() {

        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          REAJUSTE DE PREÇOS");
        System.out.println("Procura de Produtos:");
        String nomeBusca = scanner.next();

        boolean encontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Cadastro uTemp = produtos.get(i);
            if (nomeBusca.equals(uTemp.getNome())) {
                encontrado = true;
                System.out.println("Produto " + i + " | "
                        + "\t\tDescrição: " + uTemp.getNome()
                        + "\t\tPreço: " + uTemp.getPreco()
                        + "\t\tUnidade Medida: " + uTemp.getUnidade()
                        + "\t\tQuantidade: " + uTemp.getQuantidade());
                System.out.println("");
                System.out.println("\tNome: " + uTemp.getNome());
                System.out.println("\tPreço Atual: " + uTemp.getPreco());
                System.out.println("");

                System.out.println("Informe uma porcentagem de reajuste: ");
                String novoReajuste = scanner.next(); // 15
                novoReajuste = novoReajuste.replace(',', '.');
                double percentual = Double.parseDouble(novoReajuste) / 100; // 0,15
                double totalPorcento = percentual * uTemp.getPreco(); // 3
                double total = totalPorcento + uTemp.getPreco(); // 23

                System.out.println("Preço final: " + total);

                System.out.println("CONFIRMA REAJUSTE (sim/nao)?: ");
                String confirmaOperacao = scanner.next();
                switch (confirmaOperacao) {
                    case "sim": {
                        Cadastro c = produtos.get(i);
                        c.setPreco(total);
                        System.out.println("Reajuste realizado corretamente!!");
                        System.out.println("");
                        break;

                    }
                    case "nao": {
                        System.out.println("Reajuste cancelado!!");
                        System.out.println("");
                        break;

                    }
                    default: {
                        System.out.println("Digite uma resposta válida!");

                    }
                }

                break;
            }

        }

        if (!encontrado) {
            System.out.println("Produto não encontrado!");
            System.out.println("");
        }

        System.out.println("REPITIR OPERAÇÃO (sim/nao)?");
        String repetirOperacao = scanner.next();
        switch (repetirOperacao) {
            case "sim":
                reajuste();
                System.out.println("");
                break;
            case "nao":
                System.out.println("");
                break;
            default:
                System.out.println("Digite uma resposta válida!");
        }

    }

    // ======== RELATÓRIO DOS PRODUTOS ========
    public void menuRelatorio() {

        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("    SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("          RELATÓRIO DE PRODUTOS");
        System.out.println("[1] GERAR RELATÓRIO");
        System.out.println("[0] RETORNAR");
        System.out.println("Opcao: ");

    }

    public void relatorio() {

        System.out.println("\t\t\t\t\t==== RELATÓRIO DE PRODUTOS ====");
        for (int i = 0; i < produtos.size(); i++) {
            Cadastro uTemp = produtos.get(i);
            System.out.println("Produto " + i + " | "
                    + "\t\tDescrição: " + uTemp.getNome()
                    + "\t\tPreço: " + uTemp.getPreco()
                    + "\t\tUnidade Medida: " + uTemp.getUnidade()
                    + "\t\tQuantidade: " + uTemp.getQuantidade());
        }

        System.out.println("Opção 0 - RETORNAR AO MENU");
        String repetirOperacao = scanner.next();
        switch (repetirOperacao) {
            case "0":
                System.out.println("");
                break;
            default:
                System.out.println("Digite uma resposta válida!");
        }
    }
    
    public void setNome(String nome) { this.nomeProduto = nome; }
    public void setPreco(double preco) { this.precoProduto = preco; }
    public void setUnidade(String unidade) { this.unidade = unidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    

    public String getNome() { return this.nomeProduto; }
    public double getPreco() { return this.precoProduto; }
    public String getUnidade() { return this.unidade; }
    public int getQuantidade() { return this.quantidade; }
    public String getConfirmaOperacao() { return this.confirmaOperacao; }
    public String getRepetirOperacao() { return this.repetirOperacao; }

}