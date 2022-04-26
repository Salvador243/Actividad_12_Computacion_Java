package com.company;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class AddressBook extends Main{
    Scanner in = new Scanner(System.in);
    //Guarda
    public static void write() {
        File file = new File(inputFilename);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bf.write(entry.getKey() + "," + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
            }
        }
    }

    //Delete
    public void delete(){
        for (Map.Entry<String, String> entry : mapFromFile.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("\nIngrese el numero que quiere eliminar");
        String eleccion = in.nextLine();
        map.remove(eleccion);
        System.out.println("\n");
    }


    //Create
    public void crear(){
        System.out.println("Ingrese el numero de telefono");
        String number = in.nextLine();
        System.out.println("Ingrese el nombre");
        String nombre = in.nextLine();
        map.put(number, nombre);
    }

    //List

    public void listar(){
        for (Map.Entry<String, String> entry : mapFromFile.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static Map<String, String> load() {
        BufferedReader br = null;
        try {
            File file = new File(inputFilename);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[1].trim();
                String number = parts[0].trim();
                if (!name.equals("") && !number.equals(""))
                    map.put(number, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {

                }
            }
        }
        return map;
    }

}
