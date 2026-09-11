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

public class Table {
    // Ajanın uyanması için
    public Semaphore agentSem = new Semaphore(1);

    // Malzemeler
    public Semaphore tobacco = new Semaphore(0);
    public Semaphore paper = new Semaphore(0);
    public Semaphore match = new Semaphore(0);

    // İçicileri uyandıran semaforlar
    public Semaphore tobaccoSmokerSem = new Semaphore(0);
    public Semaphore paperSmokerSem = new Semaphore(0);
    public Semaphore matchSmokerSem = new Semaphore(0);

    // Değişken koruması için Mutex
    public Semaphore mutex = new Semaphore(1);

    // Durum değişkenleri
    public boolean isTobacco = false;
    public boolean isPaper = false;
    public boolean isMatch = false;
}
