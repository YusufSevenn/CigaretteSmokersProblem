/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cigarettesmokersproblem;

/**
 *
 * @author arkin
 */
public class PusherB extends Thread {
    private Table table;

    public PusherB(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            try {
                table.paper.acquire();
                table.mutex.acquire();

                if (table.isTobacco) {
                    table.isTobacco = false;
                    table.matchSmokerSem.release(); // Kağıt+Tütün -> Kibritçiyi uyandır
                } else if (table.isMatch) {
                    table.isMatch = false;
                    table.tobaccoSmokerSem.release(); // Kağıt+Kibrit -> Tütüncüyü uyandır
                } else {
                    table.isPaper = true;
                }

                table.mutex.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

