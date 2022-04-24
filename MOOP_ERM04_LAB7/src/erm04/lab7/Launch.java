/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm04.lab7;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static erm04.lab7.CNotepad.createNewNotepadWriter;
import static erm04.lab7.CNotepad.createNewNotepadDataset;



/**
 * Стартовый класс, запускается сразу
 * @author Dev
 */
public class Launch {
    public static void main(String[] args) {     


        CNotepad[] notes = new CNotepad[2]; // Массив сотрудников
        
        CNotepad e_notepad = new CNotepad("Paper", 2, 21); 
        CNotepad p_notepad = new CNotepad("aEl 2", 1, 46); 
        
        notes[0] = e_notepad;
        notes[1] = p_notepad;
        
        
        try {
                    // Сброс данных объекта staff в файл (сериализация данных)
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("notes.dat"));
                    out.writeObject(notes);
                    out.close();

                    // Чтение сериализованных данных из файла в объект (десериализация данных)
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream("notes.dat"));
                    CNotepad[] newNotes = (CNotepad[]) in.readObject(); // Новый список
                    in.close();

                    newNotes[1].setHeading("Normal Header "); // Изменяем заголовок

                    // Вывод на экран массива объектов newNotes
                    for (CNotepad e : newNotes) {
                        System.out.println(e);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
       
        
    }
}

