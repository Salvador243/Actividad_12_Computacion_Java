package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    final static String inputFilename = "src/com/company/static/input.txt";
    final static Map<String, String> map = new HashMap<String, String>();
    static Map<String, String> mapFromFile = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AddressBook ab = new AddressBook();
        mapFromFile = ab.load();
        try {
            int opcion;
            do {
                System.out.println("Elija un Metodo: \n" +
                        "[1] List \n" +
                        "[2] Create \n" +
                        "[3] Delete \n" +
                        "[0] Exit");
                opcion = Integer.parseInt(in.nextLine());

                switch (opcion) {
                    case 1:
                        ab.listar();
                        break;
                    case 2:
                        ab.crear();
                        ab.write();
                        break;
                    case 3:
                        ab.delete();
                        ab.write();
                        break;
                    case 0:
                        System.out.println("\nAdios!!!\n");
                        break;
                    default:
                        System.out.println("\nOpcion Invalida\n");
                        break;
                }
            } while (opcion != 0);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
