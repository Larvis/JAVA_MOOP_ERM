package erm04.lab5;

import java.io.*;
import java.util.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;


import java.util.Vector;
/**
 * 4 вариант, Определить, имеется ли в таблице хотя бы один нулевой элемент. Если такой элемент
 * есть, то заменить все вещественные значения таблицы единицами.
 * Стартовый класс, запускается сразу
 * @author Dev
 */
public class Launch {
    public static void main(String[] args)  throws IOException, BackingStoreException {     
      
//        Preferences root = Preferences.systemRoot();
//        Preferences user = Preferences.userRoot();
        
        Preferences node = Preferences.userRoot().node("erm04_node");
        
        System.out.println("4. Определить, имеется ли в таблице хотя бы один нулевой элемент. Если такой элемент есть, то заменить все вещественные значения таблицы единицами  ");
        
//        node.putFloat("float1", (float) 2.54);
//        System.out.println(node.getFloat("float1", 0));

        final int rows = 5;
        final int cols = 6;
        double m[][] = new double[rows][cols];
        double k[][] = new double[rows][cols];
        double sum = 0, oldI, newI;
        
        boolean isZero = false;
        
        System.out.println("Matrix:");
        
        if (false)
        {
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    double randomNum = Math.random() * 1.0;
                    oldI = (double) Math.round(randomNum * 100.0)/10.0;
                    node.putDouble("old_" + i + j, oldI);
    //                System.out.println(String.format("%.0f", Ki) + " 0");
                   // node.put("m" + i + j, String.valueOf(1));
                    System.out.print(oldI + " ");
                }
                System.out.println("");
            }
        }

        // Считывание данных из Prefs
        System.out.println("New Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newI = node.getDouble("old_" + i + j, 0);

                 if (newI == 0) {
                    isZero = true;
                    k[i][j] = 1;
                }
                else
                {
                    k[i][j] = newI;
                }
                
                node.putDouble("new_" + i + j, k[i][j]); // Запись в новый регистр
                System.out.print(k[i][j] + " ");
            }
            System.out.println("");
        }
        
    }
}

