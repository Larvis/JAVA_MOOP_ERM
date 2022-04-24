/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm04.lab4;

/**
 *
 * @author Dev
 */
public class Launch2{

    private static Runnable task1;
    private static Runnable task2;
    private static Runnable task3;
    
    public static void main(String []args) {
        // Функциональный интерфейс
        // https://javarush.ru/groups/posts/2047-threadom-java-ne-isportishjh--chastjh-i---potoki
        
        // поток_ввода_данных
        task1 = () -> {
            try {
                int secToWait = 1000;
                Thread.currentThread().sleep(secToWait);
                System.out.println("Waked up, Neo");
                
                Thread thread2 = new Thread(task2);
                thread2.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        
        // поток_обработки_данных
        task2 = () -> {
            try {
                int secToWait = 1000;
                Thread.currentThread().sleep(secToWait);
                System.out.println("Waked up, Morph");
                
                Thread thread2 = new Thread(task3);
                thread2.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        
        // поток_вывода_данных
        task3 = () -> {
            try {
                int secToWait = 1000;
                Thread.currentThread().sleep(secToWait);
                System.out.println("Sleeep!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task1);
        thread.start();
    }
}
