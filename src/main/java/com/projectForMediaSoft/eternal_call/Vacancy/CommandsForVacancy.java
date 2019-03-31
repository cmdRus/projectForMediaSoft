package com.projectForMediaSoft.eternal_call.Vacancy;
import com.projectForMediaSoft.eternal_call.DataBase.*;
import java.util.Scanner;


/* Реализация работы с вакансиями*/
public class CommandsForVacancy {

    /* Создание вакансий в БД*/
    public void createVakans() {
        System.out.println("Вы выбрали пункт: Создание вакансии");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Введите вакансию, которую нужно создать");
        String name = scanner.next();
        System.out.println("Введите описание создаваемой вакансии");
        String duties = scanner2.next();
        System.out.println("Введите кол-во часов в неделю (от 1 до 168)");
        int conitions  = scanner3.nextInt();
        System.out.println("Введите заработную плату");
        int salary = scanner4.nextInt();
        CommandsForDataBase command = new CommandsForDataBase();
        command.createVacancy(name, duties, conitions, salary);
        System.out.println("Вакансия успешно создана");
        SwitсherForVacancy switchVac = new SwitсherForVacancy();
        switchVac.switcher();
    }

    /* Поиск определенных вакансий в БД*/
    public void findVacancy() {
        System.out.println("Вы выбрали пункт: Поиск определенной вакансии");
        System.out.println("Введите вакансию, которую нужно найти");
        Scanner scanner = new Scanner(System.in);
        String vac = scanner.next();
        CommandsForDataBase command = new CommandsForDataBase();
        command.findVacancy(vac);
        SwitсherForVacancy switchVac = new SwitсherForVacancy();
        switchVac.switcher();
    }

    /* Удаление вакансии*/
    public void delVacancy (){
        System.out.println("Вы выбрали пункт: Удаление вакансии");
        System.out.println("Введите id вакансии, которое нужно удалить");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        CommandsForDataBase command = new CommandsForDataBase();
        command.delVacancy(id);
        System.out.println("Удаление успешно выполенно");
        SwitсherForVacancy switchVac = new SwitсherForVacancy();
        switchVac.switcher();
    }

    /* Просмотр всех вакансий в БД*/
    public void viewVacancy() {
        System.out.println("Вы выбрали пункт: Просмотр всех вакансий");
        CommandsForDataBase command = new CommandsForDataBase();
        command.viewVacancy();
        SwitсherForVacancy switchVac = new SwitсherForVacancy();
        switchVac.switcher();
    }

    /* Реализация проверки вводимых данных Не используется*/
    private void compСonitions (int a) {
        try{
            if (a > 0){
                if (a < 168){
                    System.out.println("Вы ввели верные данные");
                }
            }
        } catch (Exception e) {
            System.out.println("Вы ввели не корректное число");
            this.createVakans();
        }
    }
}


