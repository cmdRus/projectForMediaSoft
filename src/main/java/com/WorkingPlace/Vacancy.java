package com.WorkingPlace;

import dataBase.jdbc;

import java.util.Scanner;

public class Vacancy {

    /* Создание вакансий в БД*/
    public void createVakans() {
        System.out.println("Создание вакансии");
    }

    /* Поиск определенных вакансий в БД*/
    public void findVakans() {
        System.out.println("Поиск определенной вакансии");
        Scanner scanner = new Scanner(System.in);
        String vac = scanner.next();
        jdbc dataBase = new jdbc();
        dataBase.findVakans(vac);
    }



    /* Просмотр всех вакансий в БД*/
    public void viewVacancy() {
        System.out.println("Просмотр всех вакансий");
        jdbc dataBase = new jdbc();
        dataBase.viewVacancy();
    }

    /* Удаление вакансии*/
    public void delVacancy (){
        System.out.println("Удаление вакансии");
    }
}
