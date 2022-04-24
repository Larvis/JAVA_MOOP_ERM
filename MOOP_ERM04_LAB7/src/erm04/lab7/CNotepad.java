/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erm04.lab7;

import java.io.Serializable;
import java.util.Scanner;
/**
 *
 * @author Dev
 */
public class CNotepad implements Comparable<CNotepad>, Serializable {
    private String heading; // Заголовок
    private int type; // Тип 1 - электронный, 2 - бумажный
    private int pages; // Количество страниц

    public CNotepad()
    {
        
    }
    
    public CNotepad(String heading, int type, int pages)
    {
        setHeading(heading);
        setType(type);
        setPages(pages);
    }
    
    public String getHeading() {
        return heading;
    }
    
    public int getType() {
        return type;
    }

    public int getPages() {
        return pages;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
    
    public void setType(int type) {
        this.type = type;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "CNotepad{" + "type=" + type + ", heading=" + heading + ", pages=" + pages + '}';
    }

    @Override
    public int compareTo(CNotepad note) {
        if (note == null) {
            return 1;
        }
        if (type > note.type) {
            return 1;
        }
        if (type < note.type) {
            return -1;
        }
        
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
        note.setType(sc.nextInt());
        System.out.print("Pages count: ");
        note.setPages(sc.nextInt());
        
        return note;
    } 
    public static CNotepad createNewNotepadDataset(String heading, int type, int pages) {
        CNotepad note = new CNotepad(heading, type, pages);
        return note;
    } 
}