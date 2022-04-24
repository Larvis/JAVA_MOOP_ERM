/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm01.lab1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
/**
 * Абстрактный класс Блокнот
 * @author Dev
 */
public abstract class ANotepad implements INotepad {    
    /**
     * Добавить текст
     *
     * System.out success Text
     */
    @Override
    public void textAdd(String text) {
        System.out.println("|==============================");
        System.out.println("Добавлен текст: " + text);
    }
    
    /**
     * Скопировать текст
     *
     * System.out success Text
     * @param text
     */
    @Override
    public void textCopy(String text) {
        System.out.println("|==============================");
        System.out.println("Текст скопирован: " + text);
    }
    
    /**
     * Удалить текст
     *
     * System.out success Text
     */
    @Override
    public void textDel(String text) {
        System.out.println("|==============================");
        System.out.println("Текст удален: " + text);
    }
    
    /**
     *  Вставить картинку из буфера
     *
     *  System.out success Text
     */
     @Override
     public void picPaste() {
        System.out.println("|==============================");
        System.out.println("Картинка добавлена!");
    }
   
     /**
     *  Удалить выбранную картинку
     *
     *  System.out success Text
     */
    @Override
    public void picDel(int picID) {
        System.out.println("|==============================");
        System.out.println("Картинка №" + picID + " удалена.");
    }
    
    /**
     *  Создать таблицу X*Y
     *
     *  System.out success Text
     */
    @Override
    public void tableAdd(int cols, int rows) {
        System.out.println("|==============================");
        System.out.println("Таблица " + cols + "x" + rows + " создана.");
    }
    
    /**
     *  Удалить таблицу №
     *
     *  System.out success Text
     */
    @Override
    public void tableDel(int tableID) {
        System.out.println("|==============================");
        System.out.println("Таблица №" + tableID + " удалена.");
    }
    
}
