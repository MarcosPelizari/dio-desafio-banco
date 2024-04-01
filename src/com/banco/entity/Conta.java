package com.banco.entity;

import com.banco.entity.Banco;

public abstract class Conta implements OperacaoBancaria {
    protected static final int AGENCIA_PADRAO = 1;
    protected static int SEQUENCIAL = 1;

    protected int agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;
    private Cliente cpf;
    private Banco banco;


    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {

        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para essa transação.");
        }

    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Valor depositado.");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {

        if (this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println(String.format("A Transferencia para o correntista %s no valor de %.2f foi realizada com sucesso.",
                    contaDestino.cliente.getNome(), valor));
        } else {
            System.out.println("Saldo insuficiente para essa transação.");
        }


    }

    public void imprimirExtrato(){}
    protected void imprimirDados() {
        System.out.println();
        System.out.println(String.format("Client = %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia = %d", this.agencia));
        System.out.println(String.format("Conta = %d", this.conta));
        System.out.println(String.format("Saldo = %.2f", this.saldo));
        System.out.println();
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", conta=" + conta +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNome() +
                '}';
    }
}
