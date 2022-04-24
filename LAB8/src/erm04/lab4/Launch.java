package erm04.lab4;

import java.io.*;
import java.util.*;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 4 вариант, Определить, имеется ли в таблице хотя бы один нулевой элемент. Если такой элемент
 * есть, то заменить все вещественные значения таблицы единицами.
 * Стартовый класс, запускается сразу
 * @author Dev
 */
public class Launch {
    
    private static Runnable task1;
    private static Runnable task2;
    private static Runnable task3;
    
    
    private static final int rows = 4;
    private static final int cols = 5; 
    private static double m[][] = new double[rows][cols];
    private static double k;
    
    private static String comment;
    private static Properties p;
    private static File f1;
    private static File f2;
    private static String fileNameXML;
    private static String fileNameProp;

 
    public static void main(String[] args) throws Exception {     
        
        
        
        
        // Вывод данных о задании на экран
        System.out.println("LAB 4, Var 4");
        System.out.println("Zad: Определить, имеется ли в таблице хотя бы один нулевой элемент."
                + " Если такой элемент есть, то заменить его единицей.");

        
            
//        try {
//            // TH1 start
//            
//        } catch (Exception e) {
//            System.err.println("Error working with XML-file!"); // Вывести сообщение об ошибке            
//        }
        
        
        task1 = () -> {
                System.out.println("TH1 Start");
                
                // Определяем текущий каталог с именем файла
                String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                        + System.getProperty("file.separator");
                
                fileNameXML = dir + "erm_data.xml"; // Имя XML-файла для работы
                fileNameProp = dir + "erm_data.prop"; // Имя Prop-файла для работы
                System.out.println(fileNameXML);
                System.out.println(fileNameProp);
                
                p = new Properties(); // Переменная для хранения xml-данных
                f1 = new File(fileNameXML); // Переменная для доступа к файлу fileNameXML
                f2 = new File(fileNameProp); // Переменная для доступа к файлу fileNameProp
                comment = new Date().toString(); // Переменная для комментария
                
                /* =========================| TH 1 |============================ */
                // поток_ввода_данных
                
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
                    try {
                        // Сохранение обработанных данных массива в файлы
                        p.storeToXML(new FileOutputStream(fileNameXML), comment);
                    } catch (IOException ex) {
                        Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        p.store(new FileOutputStream(fileNameProp), comment);
                    } catch (IOException ex) {
                        Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        // Если файл существует, то
                        // Загружаем xml-данные из файла в переменную p для сохранения существующих значений
                        p.loadFromXML(new FileInputStream(fileNameXML));
                        //p.load(new FileInputStream(fileNameProp));
                    }  catch (IOException ex) {
                        Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                
                // Запуск второго потока
                Thread thread2 = new Thread(task2);
                thread2.start();
        };
        
        task2 = () -> {
            System.out.println("TH2 Start");

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
            try {
                // Сохранение обработанных данных массива в XML-файл
                p.storeToXML(new FileOutputStream(fileNameXML), comment);
            } catch (IOException ex) {
                Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                p.store(new FileOutputStream(fileNameProp), "Source and processed array data");
            } catch (IOException ex) {
                Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Запуск третьего потока
            Thread thread3 = new Thread(task3);
            thread3.start();
        };
        
        task3 = () -> {
            System.out.println("TH3 Start");
            
            // Считывание обработанных данных из XML-файла
            System.out.println("New matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(p.getProperty("new" + i + j, "?") + " ");
                }
                System.out.println("");
            }

            
            System.out.println("TH3 End");
        };
        
        
        Thread thread = new Thread(task1);
        thread.start();
        
        
    }
}

