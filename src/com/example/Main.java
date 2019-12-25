package com.example;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

class FirstThread extends Thread {
    @Override
    public void run() {
        File directory = new File("BTU_DOCUMENT");

        while (true) {
            try {
                System.out.println(directory.listFiles().length);

                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SecondThread extends Thread {
    @Override
    public void run() {
        File directory = new File("BTU_DOCUMENT");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("შემოიტანე საძიებო სიტყვა : ");
                String searchKey = scanner.next();

                File[] files = directory.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.contains(searchKey);
                    }
                });

                for (File file : files) {
                    System.out.println("მოიძებნა - " + file.getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread();
        firstThread.start();

        SecondThread secondThread = new SecondThread();
        secondThread.start();
    }
}
