package erm04.lab4;

import java.io.*;
import java.util.*;

import java.util.Vector;
/**
 * 4 вариант, Определить, имеется ли в таблице хотя бы один нулевой элемент. Если такой элемент
 * есть, то заменить все вещественные значения таблицы единицами.
 * Стартовый класс, запускается сразу
 * @author Dev
 */
public class Launch {
    public static void main(String[] args) {     
        
        final int rows = 4;
        final int cols = 5; 
        double m[][] = new double[rows][cols];
        double k;
        
        // Вывод данных о задании на экран
        System.out.println("LAB 4, Var 4");
        System.out.println("Zad: Определить, имеется ли в таблице хотя бы один нулевой элемент."
                + " Если такой элемент есть, то заменить его единицей.");

        try {
            // Определяем текущий каталог с именем файла
             String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator");
            
            String fileNameXML = dir + "erm_data.xml"; // Имя XML-файла для работы
            String fileNameProp = dir + "erm_data.prop"; // Имя Prop-файла для работы
            System.out.println(fileNameXML);
            System.out.println(fileNameProp);
            
             Properties p = new Properties(); // Переменная для хранения xml-данных
            File f1 = new File(fileNameXML); // Переменная для доступа к файлу fileNameXML
            File f2 = new File(fileNameProp); // Переменная для доступа к файлу fileNameProp
            String comment = new Date().toString(); // Переменная для комментария

            
            if ((f1.exists() == false) || f2.exists() == false) {
                // Создаем случайные данные для файлов
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        double randomNum = Math.random() * 1.0;
                        k = (double) Math.round(randomNum * 100.0)/10.0;
                        p.put("old" + i + j, String.valueOf(k));
                       // p.put("m" + i + j, String.valueOf(1));
                    }
                }
                // Сохранение обработанных данных массива в файлы
                p.storeToXML(new FileOutputStream(fileNameXML), comment);
                p.store(new FileOutputStream(fileNameProp), comment);
            } else { // Если файл существует, то
                // Загружаем xml-данные из файла в переменную p для сохранения существующих значений
                p.loadFromXML(new FileInputStream(fileNameXML));
                //p.load(new FileInputStream(fileNameProp));
            }

            
            System.out.println("Matrix:");

            
            // Считывание данных из XML-файла
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    k = Double.valueOf(p.getProperty("old" + i + j, "0"));
                    m[i][j] = k;
                    System.out.print(k + " ");
                }
                System.out.println("");
            }

            
            // Реализация алгоритма варианта задания 
            boolean isZero = false;
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    k = m[i][j];
                  
                    if (k == 0) {
                        isZero = true;
                        m[i][j] = 1;
                    }
                }
            }

            // Сохраняем данные итогового массива в перемменную XML-файла
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // Сохраняем данные в переменную, хранящую данные xml
                    p.put("new" + i + j, String.valueOf(m[i][j]));
                }
            }

            System.out.println("is_zero: " + String.valueOf(isZero));

            p.put("is_zero", String.valueOf(isZero));
            // Сохранение обработанных данных массива в XML-файл
            p.storeToXML(new FileOutputStream(fileNameXML), comment);
            p.store(new FileOutputStream(fileNameProp), "Source and processed array data");

            // Считывание обработанных данных из XML-файла
            System.out.println("New matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(p.getProperty("new" + i + j, "?") + " ");
                }
                System.out.println("");
            }

        } catch (Exception e) {
            System.err.println("Error working with XML-file!"); // Вывести сообщение об ошибке            
        }
        
    }
}

