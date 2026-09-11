/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cigarettesmokersproblem;

/**
 *
 * @author arkin
 */
public class PusherA extends Thread {
    private Table table;

    public PusherA(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            try {
                table.tobacco.acquire(); // Tütün var mı?
                table.mutex.acquire();   // Kritik bölgeye gir
                
                if (table.isPaper) {
                    table.isPaper = false;
                    table.matchSmokerSem.release(); // Tütün+Kağıt -> Kibritçiyi uyandır
                } else if (table.isMatch) {
                    table.isMatch = false;
                    table.paperSmokerSem.release(); // Tütün+Kibrit -> Kağıtçıyı uyandır
                } else {
                    table.isTobacco = true; // Eşleşme yok, tütünü not et
                }
                
                table.mutex.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
  
