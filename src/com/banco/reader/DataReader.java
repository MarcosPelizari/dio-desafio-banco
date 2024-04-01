package com.banco.reader;

import java.util.Scanner;

public final class DataReader {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static String lerDado() {
        String linha = scanner.nextLine();

        return linha;
    }
}
