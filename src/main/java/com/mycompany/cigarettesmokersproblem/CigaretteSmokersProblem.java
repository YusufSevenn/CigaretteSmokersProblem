/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cigarettesmokersproblem;

/**
 *
 * @author arkin
 */
public class CigaretteSmokersProblem {

 public static void main(String[] args) {
        // 1. Ortak Masa (Shared Memory) oluşturuluyor
        Table table = new Table();

        // 2. Ajan başlatılıyor
        Agent agent = new Agent(table);
        agent.start();

        // 3. İçiciler başlatılıyor (Table nesnesini parametre olarak alıyorlar)
        // Not: Hangi semaforu bekleyeceklerini de Table üzerinden veriyoruz
        new Smoker("Tütüncü (Kağıt+Kibrit bekliyor)", table, table.tobaccoSmokerSem).start();
        new Smoker("Kağıtçı (Tütün+Kibrit bekliyor)", table, table.paperSmokerSem).start();
        new Smoker("Kibritçi (Tütün+Kağıt bekliyor)", table, table.matchSmokerSem).start();

        // 4. Pusher'lar başlatılıyor
        new PusherA(table).start();
        new PusherB(table).start();
        new PusherC(table).start();
    }
}
