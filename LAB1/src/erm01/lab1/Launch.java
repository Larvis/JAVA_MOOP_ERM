/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm01.lab1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.*;

import java.util.Vector;
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

        System.out.println(e_notepad.getPages()); 
        System.out.println(e_notepad.toString()); 

//      New Paper
        PaperNotepad p_notepad = new PaperNotepad();   
        p_notepad.setHeading("Бумагаааа"); 
        p_notepad.setPages(1); 

        System.out.println(p_notepad.toString()); 

//      E  Check
        e_notepad.tableDel(2);
        e_notepad.textAdd("Lorem ipsum dolor at siet");
        e_notepad.tableAdd(5,4);

    }
}

