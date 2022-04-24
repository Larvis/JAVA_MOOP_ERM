package erm04.lab6;

import java.io.*;
import java.util.*;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

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
    public static final String ANSI_RESET = "\u001B[CUUA";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    
    public static void main(String[] args)  throws IOException, BackingStoreException {     

        Scanner scanner = new Scanner(System.in);
        int reply_num;
 

        String country = "", language = "";
        System.out.println("1 – Английский");
        System.out.println("2 – Казахский");
        System.out.println("3 – Белорусский");
        System.out.println("4 – Китайский");
        System.out.println("Любой другой символ – Русский");
        char i = (char) System.in.read();
        switch (i) {
            case '1':
                language = "en";
                country = "US";
                break;
            case '2':
                language = "kk";
                country = "KZ";
                break;
            case '3':
                language = "bel";
                country = "BY";
                break;
            case '4':
                language = "zh";
                country = "TW";
                break;        
        }
        
        ResourceBundle rb = ResourceBundle.getBundle("text", new Locale(language, country));

        for (int q = 1; q < 4; q++)
        {
            System.out.println("=== === === ===");
            System.out.println(getStr(rb.getString("question_" + q), rb.getString("utf16")));
            for (int r = 1; r < 4; r++)
            {
                System.out.println(getStr(rb.getString("reply_" + q + "_" + r), rb.getString("utf16")));
            }
            
            reply_num = scanner.nextInt();
            String reply_true = getStr(rb.getString("reply_" + q + "_true"), rb.getString("utf16"));
            
            if (reply_num == Integer.parseInt(reply_true))
            {
                System.out.println(ANSI_GREEN + getStr(rb.getString("true_text"), rb.getString("utf16")) + ANSI_RESET);
            }
            else
            {
                System.out.println(ANSI_RED + getStr(rb.getString("false_text"), rb.getString("utf16")) + ANSI_RESET);
            }

        }
        
//        System.out.println(rb.getString("my.question")); // Так делать нельзя для некоторых языков, например, белорусского
//        System.out.println(rb.getString("my.reply")); // Âîñü ó ÷ûì ïûòàííå. <- вот так иначе получится
        
//question_1 = 1. Что такое Первичный ключ?
//reply_1_1 = Уникальный ключ
//reply_1_2 = Уникальная таблица
//reply_1_3 = Главное поле
//reply_1_true


        
    }
    
    public static String getStr(String text, String utf16) throws UnsupportedEncodingException {
        if (!utf16.equals("true")) {
            return new String(text.getBytes("ISO-8859-1"), "Windows-1251");
        } else {
            return text;
        }
    }
}

