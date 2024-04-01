package com.banco.entity;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println();
        System.out.println("=== Extrato da Conta Pupança ===");
        super.imprimirDados();
        System.out.println("=================================");
        System.out.println();
    }



}
