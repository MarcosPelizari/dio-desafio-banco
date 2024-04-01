package com.banco.start;

import com.banco.entity.Banco;
import com.banco.entity.Cliente;
import com.banco.entity.Conta;
import com.banco.entity.ContaCorrente;
import com.banco.reader.DataReader;

public class Main {

    private static boolean sessaoBanco = false;
    private static Banco banco =new Banco();

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Marcos");
        cliente.setCpf("123456789011");
        cliente.setEndereco("Rua Eu vivo na Lua");
        cliente.setNumeroEndereco(131);

        Conta conta = new ContaCorrente(cliente);

        banco.adicionarCliente(conta);



        String opcao = "";

        Conta contaDestino;

        while (!sessaoBanco) {

            System.out.println();
            System.out.println(String.format("Olá %s, seleciona a opção com a transação que deseja realizar.", cliente.getNome()));
            System.out.println("1 - Verificar o saldo");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Consultar clientes");
            System.out.println("6 - sair");

            opcao = DataReader.lerDado();

            switch (opcao) {
                case "1":
                    conta.imprimirExtrato();
                    break;
                case "2":
                    System.out.println("Qual valor gostaria de sacar?");
                    opcao = DataReader.lerDado();
                    conta.sacar(Integer.parseInt(opcao));
                    break;
                case "3":
                    System.out.println("Qual valor gostaria de depositar?");
                    opcao = DataReader.lerDado();
                    conta.depositar(Integer.parseInt(opcao));
                    break;
                case "4":
                    System.out.println("Informe a conta que irá receber a transferencia:");
                    int contaTransferencia = Integer.parseInt(DataReader.lerDado());
                    System.out.println("Qual o valor a ser transferido?");
                    double valorTransferencia = Double.parseDouble(DataReader.lerDado());
                    banco.validarTransferencia(contaTransferencia, valorTransferencia, conta);
                    break;
                case "5":
                    banco.listAll();
                    break;
                case "6":
                    System.out.println("Volte sempre.");
                    sessaoBanco = true;
                    break;
                default:
            }
        }


    }
}
