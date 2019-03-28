package com.projectForMediaSoft.eternal_call;

import com.projectForMediaSoft.eternal_call.Vacancy.*;
import java.util.Scanner;


public class Main {
    public static void main (String[] args) {
        System.out.println("Добро пожаловать в систему поиска и размещения вакансий");
        System.out.println("Если вы хотите работать с вакансиями, нажмите 1:");
        System.out.println("Если вы хотите работать с резюме соискателей, нажмите 2:");
        System.out.println("Если вы хотите закончить работу программы, нажмите 3:");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        SwitcherMain switcherMain = new SwitcherMain();
        switcherMain.switcher(x);
        System.out.println("Finish program. THX for using ;)");
    }
}

// Создание нескольких вакансий, в многопоточности
// Логирование (работа с БД)
// Лямба выражение

//Попробовать прикрутить графику