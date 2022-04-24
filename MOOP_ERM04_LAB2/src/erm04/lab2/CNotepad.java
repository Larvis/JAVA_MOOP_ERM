/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm04.lab2;

import java.util.Scanner;
/**
 *
 * @author Dev
 */
public class CNotepad implements Comparable<CNotepad> {
    private String heading; // Заголовок
//    private int type; // Тип 1 - электронный, 2 - бумажный
    private int pages; // Количество страниц
     
    enum PaperTypes {
       
    }

    public CNotepad()
    {
        
    }
    
    public CNotepad(String heading, int pages, enum Types)
    {
        setHeading(heading);
        setType(Types);
        setPages(pages);
    }
    
    public String getHeading() {
        return heading;
    }
    
    public String getType() {
        return Types;
    }

    public int getPages() {
        return pages;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
    
    public void setType(Types type) {
        this.Types = type;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "CNotepad{" + "type=" + paperTypes + ", heading=" + heading + ", pages=" + pages + '}';
    }

    @Override
    public int compareTo(CNotepad note) {
        if (note == null) {
            return 1;
        }
//        if (paperTypes > note.type) {
//            return 1;
//        }
//        if (paperTypes < note.type) {
//            return -1;
//        }
        
        if (pages > note.pages) {
            return 1;
        }
        if (pages < note.pages) {
            return -1;
        }
        
        if (heading.compareTo(note.heading) > 0) {
            return 1;
        }
        if (heading.compareTo(note.heading) < 0) {
            return -1;
        }

        return 0;
    }
    
    public static CNotepad createNewNotepadWriter() {
        CNotepad note = new CNotepad();
        Scanner sc = new Scanner(System.in);
        System.out.print("Heading: ");
        note.setHeading(sc.nextLine());
        System.out.print("type 1 or 2: ");
        note.setType(sc.next());
        System.out.print("Pages count: ");
        note.setPages(sc.nextInt());
        
        return note;
    } 
    public static CNotepad createNewNotepadDataset(String heading, int type, int pages) {
        CNotepad note = new CNotepad(heading, type, pages);
        return note;
    } 
}