/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cigarettesmokersproblem;

/**
 *
 * @author arkin
 */
import java.util.concurrent.Semaphore;

public class Smoker extends Thread {
    private String name;
    private Table table;
    private Semaphore mySem; // Bu içicinin beklediği özel semafor

    // Hangi semaforu bekleyeceğini dışarıdan alıyoruz
    public Smoker(String name, Table table, Semaphore mySem) {
        this.name = name;
        this.table = table;
        this.mySem = mySem;
    }

    @Override
    public void run() {
        while (true) {
            try {
                mySem.acquire(); // Kendi malzemelerinin hazır olmasını bekle
                System.out.println(name + " malzemeleri aldı.");
                System.out.println(name + " sigara sarıyor ve içiyor... (puff puff)");
                Thread.sleep(1000); // İçme süresi
                System.out.println(name + " işini bitirdi. Ajanı çağırıyor.");
                table.agentSem.release(); // Ajanı serbest bırak
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    

