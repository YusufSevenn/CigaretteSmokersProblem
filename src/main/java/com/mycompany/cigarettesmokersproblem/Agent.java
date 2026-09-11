/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cigarettesmokersproblem;

/**
 *
 * @author arkin
 */
import java.util.Random;

public class Agent extends Thread {
    private Table table;
    private Random rand = new Random();

    public Agent(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            try {
                table.agentSem.acquire(); // İçicinin bitirmesini bekle
                System.out.println("\n--- Ajan uyanıyor ve masaya malzeme koyuyor... ---");

                int choice = rand.nextInt(3);
                switch (choice) {
                    case 0:
                        System.out.println("Ajan masaya TÜTÜN ve KAĞIT koydu.");
                        table.tobacco.release();
                        table.paper.release();
                        break;
                    case 1:
                        System.out.println("Ajan masaya KAĞIT ve KİBRİT koydu.");
                        table.paper.release();
                        table.match.release();
                        break;
                    case 2:
                        System.out.println("Ajan masaya TÜTÜN ve KİBRİT koydu.");
                        table.tobacco.release();
                        table.match.release();
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
