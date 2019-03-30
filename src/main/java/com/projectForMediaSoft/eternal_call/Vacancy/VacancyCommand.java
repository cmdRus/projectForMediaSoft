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
    public void findVacancy() {
        System.out.println("Вы выбрали пункт: поиск определенной вакансии");
        System.out.println("Введите вакансию, которую нужно найти");
        Scanner scanner = new Scanner(System.in);
        String vac = scanner.next();
        Commands command = new Commands();
        command.findVacancy(vac);
        SwithcerVacancy switchVac = new SwithcerVacancy();
        switchVac.swith();
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
        System.out.println("Введите вакансию, которую нужно удалить");
        Scanner scanner = new Scanner(System.in);
        String vac = scanner.next();
        Commands command = new Commands();
        command.delVacancy(vac);
        System.err.println("Удаление успешно выполенно");
        SwithcerVacancy switchVac = new SwithcerVacancy();
        switchVac.swith();
    }
}


