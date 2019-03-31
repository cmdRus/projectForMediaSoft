package com.eternal_call.projectForMediaSoft;
import com.eternal_call.projectForMediaSoft.DataBase.CommandsForDataBase;
import java.io.*;
import java.util.Scanner;
import java.util.logging.*;


public class Main {

    /* Создание логгера, с получением имени класса*/
    private static Logger log = Logger.getLogger(CommandsForDataBase.class.getName());
    static String file1 = "D:/Java/projects/git/projectForMediaSoft/logs/LogExceptions.log"; // Путь файла для логирования ошибок

    public static void main (String[] args) throws IOException {
        System.out.println("Добро пожаловать в систему поиска и размещения вакансий");
        mainer();
        System.out.println("Finish program. THX for using ;)");
    }

    /* Реализация главное меню*/
    public static void mainer() throws IOException {
        LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
        Handler fileHandlerException = new FileHandler(file1, true); //Объявление файла для логирования
        System.out.println("Если вы хотите работать с вакансиями, нажмите 1:");
        System.out.println("Если вы хотите работать с резюме соискателей, нажмите 2:");
        System.out.println("Если вы хотите закончить работу программы, нажмите 3:");
        try{ //Обработка правильности вводимого значения для главного меню
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            SwitcherMain switcherMain = new SwitcherMain();
            switcherMain.switcher(x);
        } catch (Exception e) { // Обработка логером ошибки
            log.addHandler(fileHandlerException);
            log.info("Вы ввели не корректное значение");
            mainer();
        }
    }

}

/*
    * Создание нескольких вакансий, в многопоточности
    * Логирование (работа с БД + exceptions) +
    * Лямба выражение
    * Попробовать прикрутить графику
    *
    * Сделать работающие обработки резюме +
    * try/catch вводимые данные (проверка последних) +
    * Сделать комментарии во всём проекте +
 */