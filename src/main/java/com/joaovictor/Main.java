package com.joaovictor;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Olá, Seja Bem-vindo ao VitBank!!");

            System.out.print("Digite o número da sua conta: ");
            int numeroConta = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite seu nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite seu saldo inicial: ");
            double saldo = sc.nextDouble();

            // DEPÓSITO
            System.out.print("Você deseja realizar um depósito? (sim/não): ");
            String confirmacao = sc.next().trim().toLowerCase();

            if (Objects.equals(confirmacao, "sim")) {
                System.out.print("Digite o número da conta: ");
                int numeroProcurado = sc.nextInt();

                if (numeroProcurado == numeroConta) {
                    try {
                        System.out.print("Digite o valor do depósito: ");
                        double deposito = sc.nextDouble();

                        if (deposito > 0) {
                            saldo += deposito;
                            System.out.println("Depósito realizado com sucesso!");
                        } else {
                            System.out.println("❌ O valor do depósito deve ser positivo!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Valor inválido! Digite um número para o depósito.");
                        sc.nextLine(); // limpa entrada inválida
                    }
                } else {
                    System.out.println("❌ Conta não encontrada!");
                }
                System.out.println(nome + ", seu saldo atual é: " + saldo);
            }

            // SAQUE
            System.out.print("Você deseja realizar um saque? (sim/não): ");
            confirmacao = sc.next().trim().toLowerCase();

            if (Objects.equals(confirmacao, "sim")) {
                System.out.print("Digite o número da conta: ");
                int numeroProcurado = sc.nextInt();

                if (numeroProcurado == numeroConta) {
                    try {
                        System.out.print("Digite o valor do saque: ");
                        double saque = sc.nextDouble();

                        if (saque > 0 && saque <= saldo) {
                            saldo -= saque;
                            System.out.println("Saque realizado com sucesso!");
                        } else if (saque <= 0) {
                            System.out.println("❌ O valor do saque deve ser positivo!");
                        } else {
                            System.out.println("❌ Saldo insuficiente para o saque!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Valor inválido! Digite um número para o saque.");
                        sc.nextLine();
                    }
                } else {
                    System.out.println("❌ Conta não encontrada!");
                }
                System.out.println(nome + ", seu saldo atual é: " + saldo);
            }

            System.out.println("\nObrigado por usar o VitBank, " + nome + "!");
            System.out.println("💰 Saldo final: " + saldo);

        } catch (InputMismatchException e) {
            System.out.println("❌ Erro: entrada inválida. Reinicie o programa e insira os dados corretamente.");
        } catch (Exception e) {
            System.out.println("⚠ Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
};