/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cigarettesmokersproblem;

/**
 *
 * @author arkin
 */
public class PusherC extends Thread {
    private Table table;

    public PusherC(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            try {
                table.match.acquire();
                table.mutex.acquire();

                if (table.isPaper) {
                    table.isPaper = false;
                    table.tobaccoSmokerSem.release(); // Kibrit+Kağıt -> Tütüncüyü uyandır
                } else if (table.isTobacco) {
                    table.isTobacco = false;
                    table.paperSmokerSem.release(); // Kibrit+Tütün -> Kağıtçıyı uyandır
                } else {
                    table.isMatch = true;
                }

                table.mutex.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}