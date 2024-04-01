package com.banco.entity;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void adicionarCliente(Conta nome) {
        contas.add(nome);
    }

    public Banco() {

        this.contas = new ArrayList<>();
        String[] nomes = {"Julia", "João", "Pedro", "Bia", "Ana Maria", "Paulo", "Junior", "Nicolas", "Maria",
                "Dianna", "Elizabeth", "Ana Paula", "Welligton", "Francisco", "Maria Helena", "Victor", "Natalia"};

        for (String nome: nomes) {
            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            contas.add(new ContaCorrente(cliente));
            contas.add(new ContaPoupanca(cliente));
        }
    }


    public void validarTransferencia(int conta, double valor, Conta contaOrigem) {
        if (conta > contas.size()) {
            System.out.println("O número de conta é inválido!");
        } else {
            for (Conta contasBanco : contas) {
                if (contasBanco.getConta() == conta) {
                    contaOrigem.transferir(valor, contasBanco);
                    break;
                }
            }
        }
    }

    public void listAll() {
        for (Conta conta: contas) {
            System.out.println(conta.toString());
        }
    }

}