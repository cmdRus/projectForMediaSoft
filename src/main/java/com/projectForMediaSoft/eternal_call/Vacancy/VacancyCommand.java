package com.projectForMediaSoft.eternal_call.Vacancy;
import com.projectForMediaSoft.eternal_call.Main;
import com.projectForMediaSoft.eternal_call.dataBase.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/* Реализация работы с вакансиями*/
public class VacancyCommand {

    /* Создание вакансий в БД*/
    public void createVakans() {
        System.out.println("Вы выбрали пункт: создание вакансии");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Введите вакансию, которую нужно создать");
        String name = scanner.next();
        System.out.println("Введите описание создаваемой вакансии");
        String duties = scanner2.next();
        System.out.println("Введите вид рабочей недели");
        String conitions = scanner3.next();
        System.out.println("Введите заработную плату");
        int salary = scanner4.nextInt();
        Commands command = new Commands();
        command.createVacancy(name, duties, conitions, salary);
        SwithcerVacancy switchVac = new SwithcerVacancy();
        switchVac.swith();
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

    /* Просмотр всех вакансий в БД*/
    public void viewVacancy() {
        System.out.println("Вы выбрали пункт: просмотр всех вакансий");
        Commands command = new Commands();
        command.viewVacancy();
        System.out.println("Хотите выгрузить всё в файл? Нажмите 1");
        System.out.println("В обратном случае, нажмите 2");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        switcherWriter(x);
    }

    /* Свитчер на выбор да/нет, записи вакансий в файл*/
    private void switcherWriter (int x){
        switch (x){
            case (1):{
                try{
                    FileWriter writer = new FileWriter("Text.txt");
                    writer.write("Hello");
                    writer.flush();
                    writer.close();
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                break;
            }case (2):{
                SwithcerVacancy swithcerVacancy = new SwithcerVacancy();
                swithcerVacancy.swith();
                break;
            }default:
                System.err.println("Упс. Вы где-то ошиблись");
                break;
        }
    }
}


