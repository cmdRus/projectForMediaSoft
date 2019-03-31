package com.eternal_call.projectForMediaSoft.Vacancy;
import com.eternal_call.projectForMediaSoft.DataBase.CommandsForDataBase;
import java.util.Scanner;


/* Реализация работы с вакансиями*/
public class CommandsForVacancy {

    /* Создание экземпляра класса, реализующего работу с базой данных*/
    CommandsForDataBase command = new CommandsForDataBase();

    /* Создание вакансии в БД*/
    public void createVakancy() {
        System.out.println("Вы выбрали пункт: Создание вакансии");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Введите вакансию, которую нужно создать");
        String name = scanner.next(); //Ввод имени вакансии
        System.out.println("Введите описание создаваемой вакансии");
        String duties = scanner2.next(); //Ввод описания вакансии
        System.out.println("Введите кол-во часов в неделю (от 1 до 168)");
        int conitions  = scanner3.nextInt(); //Ввод кол-во рабочих часов в неделю
        System.out.println("Введите заработную плату");
        int salary = scanner4.nextInt(); //Ввод размер заработной платы
        command.createVacancy(name, duties, conitions, salary);
        System.out.println("Вакансия успешно создана");
        this.switcher(); //Возвращение в меню работы с вакансиями
    }

    /* Поиск определенных вакансий в БД*/
    public void findVacancy() {
        System.out.println("Вы выбрали пункт: Поиск определенной вакансии");
        System.out.println("Введите вакансию, которую нужно найти");
        Scanner scanner = new Scanner(System.in);
        String vac = scanner.next(); //Ввод вакансии, которую следует найти
        command.findVacancy(vac);
        this.switcher(); //Возвращение в меню работы с вакансиями
    }

    /* Удаление вакансии*/
    public void delVacancy (){
        System.out.println("Вы выбрали пункт: Удаление вакансии");
        System.out.println("Введите id вакансии, которое нужно удалить");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt(); //Ввод id резюме, которое следует удалить
        command.delVacancy(id);
        this.switcher(); //Возвращение в меню работы с вакансиями
    }

    /* Просмотр всех вакансий в БД*/
    public void viewVacancy() {
        System.out.println("Вы выбрали пункт: Просмотр всех вакансий");
        command.viewVacancy(); //Вызов метода, отвечающего за реализацию просмотра всех вакансий
        this.switcher(); //Возвращение в меню работы с вакансиями
    }

    /* Реализация возвращения в меню работы с вакансиями*/
    private void switcher(){
        SwitсherForVacancy switchVac = new SwitсherForVacancy();
        switchVac.switcher();
    }

}


