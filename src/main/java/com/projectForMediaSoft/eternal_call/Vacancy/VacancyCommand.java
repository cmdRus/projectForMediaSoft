package com.projectForMediaSoft.eternal_call.Vacancy;
import com.projectForMediaSoft.eternal_call.dataBase.*;
import java.util.Scanner;


/* Реализация работы с вакансиями*/
public class VacancyCommand {

    /* Создание вакансий в БД*/
    public void createVakans() {
        System.out.println("Вы выбрали пункт: создание вакансии");
    }

    /* Поиск определенных вакансий в БД*/
    public void findVakans() {
        System.out.println("Вы выбрали пункт: поиск определенной вакансии");
        Scanner scanner = new Scanner(System.in);
        String vac = scanner.next();
        Commands command = new Commands();
        command.findVakans(vac);
    }

    /* Просмотр всех вакансий в БД*/
    public void viewVacancy() {
        System.out.println("Вы выбрали пункт: просмотр всех вакансий");
        Commands command = new Commands();
        command.viewVacancy();
        SwithcerVacancy switchVac = new SwithcerVacancy();
        switchVac.swith();
    }

    /* Удаление вакансии*/
    public void delVacancy (){
        System.out.println("Вы выбрали пункт: удаление вакансии");
    }
}


