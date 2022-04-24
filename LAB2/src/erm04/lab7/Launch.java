/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm04.lab7;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.*;

import java.util.Vector;

import static erm04.lab7.CNotepad.createNewNotepadWriter;
import static erm04.lab7.CNotepad.createNewNotepadDataset;

/**
 * Стартовый класс, запускается сразу
 * @author Dev
 */
public class Launch {
    public static void main(String[] args) {     

//      New ENote
        ElectronNotepad e_notepad = new ElectronNotepad(); 
        e_notepad.setHeading("Новая запись1"); 
        e_notepad.setPages(30); 

       // Zadacha 1 / 2 / 3 
//        e_notepad.markListAddNew();
        
//        CNotepad n = null;
//        n = createNewNotepad(); 

        // Запись в объект
        List<CNotepad> soureList = new ArrayList();
            soureList.add(createNewNotepadWriter()); // Ввод с клавиатуры
            soureList.add(createNewNotepadDataset("Paper", 2, 21));// Готовый набор данных
            soureList.add(createNewNotepadDataset("aEl 2", 1, 46));// Готовый набор данных
        
        Set<CNotepad> set = new TreeSet<CNotepad>();
        TreeMap<Integer, CNotepad> map = new TreeMap<Integer, CNotepad>();
        
        // Запись в другие объекты
        int counter = 0;
        for(CNotepad obj : soureList)
        {
            set.add(obj);
            map.put(counter, obj);
            
            counter++;
        }
        
        /* ===================| Удаление |===================== */
        soureList.remove(counter-1); // удаление последнего элемента
//        soureList.remove(0); // удаление первого элемента
        soureList.get(1).setHeading("New heading 1");

//        set.remove(counter); // удаление последнего элемента
//        set.get(0).setHeading("New heading 2");

//        map.remove(0); // Удаляем элемент с ключом равным 1
//        map.remove(map.size()); // Удаляем последний элемент с нужным ключом
        map.get(0).setHeading("New heading 3");
        /* ===================| Удаление |===================== */

        /* ===================| Выводы результатов |===================== */
        System.out.println("========");
        for (int i = 0; i < soureList.size(); i++) {
            System.out.println(soureList.get(i));
        }
        
        System.out.println("========");
        for(CNotepad obj : set)
        {
            System.out.println(obj);
        }
        
        System.out.println("========");
        for (Integer i : map.keySet()) {
            System.out.println("№" + i + " : " + map.get(i));
        }
        
    }
}

