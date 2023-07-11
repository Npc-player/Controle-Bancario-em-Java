/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciamentobancario2;

/**
 *
 * @author nelso
 */
import java.util.Scanner;
import java.text.DecimalFormat;


public class GerenciamentoBancario2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===========================");
        System.out.println("=====SISTEMA BANCÁRIO======");
        System.out.println("===========================");
        
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, cpf);
        ContaBancaria conta = new ContaBancaria();
        
        int opcao;
        do {
            exibirMenuInicial();
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    exibirMenuTransacoes();
                    int opcaoTransacoes;
                    do {
                        System.out.print("Digite a opção desejada: ");
                        opcaoTransacoes = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        switch (opcaoTransacoes) {
                            case 1:
                                System.out.println("Nome: " + cliente.getNome());
                                System.out.println("Sobrenome: " + cliente.getSobrenome());
                                System.out.println("CPF: " + cliente.getCpf());
                                break;
                            case 2:
                                System.out.print("Digite o valor do depósito: ");
                                double valorDeposito = scanner.nextDouble();
                                conta.depositar(valorDeposito);
                                System.out.println("Depósito realizado com sucesso!");
                                break;
                            case 3:
                                System.out.print("Digite o valor do saque: ");
                                double valorSaque = scanner.nextDouble();
                                if (conta.sacar(valorSaque)) {
                                    System.out.println("Saque realizado com sucesso!");
                                } else {
                                    System.out.println("Saldo insuficiente para o saque.");
                                }
                                break;
                            case 4:
                                System.out.println("Saldo: " + conta.getSaldoFormatado());
                                break;
                            case 5:
                                System.out.println("Retornando ao menu inicial...");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        System.out.println();
                    } while (opcaoTransacoes != 5);
                    break;
                case 2:
                    exibirMenuInvestimentos();
                    int opcaoInvestimentos;
                    do {
                        System.out.print("Digite a opção desejada: ");
                        opcaoInvestimentos = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer

                        switch (opcaoInvestimentos) {
                            case 1:
                                System.out.println("CDB (10% ao ano)");
                                System.out.print("Digite o valor a ser investido: ");
                                double valorInvestimentoCdb = scanner.nextDouble();
                                System.out.print("Digite o tempo de investimento em meses: ");
                                int mesesInvestimentoCdb = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer

                                double taxaJurosAnualCdb = 0.10; // 10% ao ano
                                double taxaJurosMensalCdb = taxaJurosAnualCdb / 12;
                                double valorTotalInvestidoCdb = valorInvestimentoCdb * mesesInvestimentoCdb;
                                double montanteFinalCdb = valorTotalInvestidoCdb * Math.pow(1 + taxaJurosMensalCdb, mesesInvestimentoCdb);
                                double lucroCdb = montanteFinalCdb - valorTotalInvestidoCdb;

                                DecimalFormat decimalFormatCdb = new DecimalFormat("#.##");
                                String montanteFinalFormatadoCdb = decimalFormatCdb.format(montanteFinalCdb);
                                String lucroCdbFormatado = decimalFormatCdb.format(lucroCdb);

                                System.out.println("Investimento realizado com sucesso!");
                                System.out.println("=====================================");
                                System.out.println("Valor investido: R$" + valorInvestimentoCdb);
                                System.out.println("Tempo de investimento: " + mesesInvestimentoCdb + " meses");
                                System.out.println("Valor total investido: R$" + valorTotalInvestidoCdb);
                                System.out.println("Montante final: R$" + montanteFinalFormatadoCdb);
                                System.out.println("Lucro: R$" + lucroCdbFormatado);
                                System.out.println("=====================================");
                                break;
                            case 2:
                                System.out.println("LCI (8% ao ano");
                                System.out.print("Digite o valor a ser investido: ");
                                double valorInvestimentoLci = scanner.nextDouble();
                                System.out.print("Digite o tempo de investimento em meses: ");
                                int mesesInvestimentoLci = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer

                                double taxaJurosAnualLci = 0.08; // 10% ao ano
                                double taxaJurosMensalLci = taxaJurosAnualLci / 12;
                                double valorTotalInvestidoLci = valorInvestimentoLci * mesesInvestimentoLci;
                                double montanteFinalLci = valorTotalInvestidoLci * Math.pow(1 + taxaJurosMensalLci, mesesInvestimentoLci);
                                double lucroLci = montanteFinalLci - valorTotalInvestidoLci;

                                DecimalFormat decimalFormatLci = new DecimalFormat("#.##");
                                String montanteFinalLciFormatado = decimalFormatLci.format(montanteFinalLci);
                                String lucroLciFormatado = decimalFormatLci.format(lucroLci);

                                System.out.println("Investimento realizado com sucesso!");
                                System.out.println("=====================================");
                                System.out.println("Valor investido: R$" + valorInvestimentoLci);
                                System.out.println("Tempo de investimento: " + mesesInvestimentoLci + " meses");
                                System.out.println("Valor total investido: R$" + valorTotalInvestidoLci);
                                System.out.println("Montante final: R$" + montanteFinalLciFormatado);
                                System.out.println("Lucro: R$" + lucroLciFormatado);
                                System.out.println("=====================================");
                                break;
                            case 3:
                                System.out.println("Retornando ao menu inicial...");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        System.out.println();
                    } while (opcaoInvestimentos != 3);
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        } while (opcao != 3);

        System.out.println("Programa encerrado.");
    }

    public static void exibirMenuInicial() {
        System.out.println("---- Menu Inicial ----");
        System.out.println("1. Transações Comuns");
        System.out.println("2. Investimentos");
        System.out.println("3. Sair");
    }

    public static void exibirMenuTransacoes() {
        System.out.println("---- Menu de Transações ----");
        System.out.println("1. Consultar informações");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar saque");
        System.out.println("4. Consultar saldo");
        System.out.println("5. Voltar ao menu inicial");
    }

    public static void exibirMenuInvestimentos() {
        System.out.println("---- Menu de Investimentos ----");
        System.out.println("1. CDB (10% ao ano)");
        System.out.println("2. LCI (8% ao ano)");
        //System.out.println("3. Opção de investimento 3");
        System.out.println("3. Voltar ao menu inicial");
    }
}


class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }
}
