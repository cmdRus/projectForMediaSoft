package com.eternal_call.projectForMediaSoft;
import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main (String[] args) throws IOException {
        System.out.println("Добро пожаловать в систему поиска и размещения вакансий");
        mainer();
        System.out.println("Finish program. THX for using ;)");
    }

    /* Реализация главное меню*/
    public static void mainer(){
        System.out.println("Если вы хотите работать с вакансиями, нажмите 1:");
        System.out.println("Если вы хотите работать с резюме соискателей, нажмите 2:");
        System.out.println("Если вы хотите закончить работу программы, нажмите 3:");
        try{ //Обработка правильности вводимого значения для главного меню
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            SwitcherMain switcherMain = new SwitcherMain();
            switcherMain.switcher(x);
        } catch (Exception e) {
            System.out.println("Вы ввели не корректное число");
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
    * Сделать комментарии во всём проекте
 */