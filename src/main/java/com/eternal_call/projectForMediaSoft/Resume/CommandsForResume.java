package com.eternal_call.projectForMediaSoft.Resume;
import com.eternal_call.projectForMediaSoft.DataBase.CommandsForDataBase;

import java.util.Scanner;


public class CommandsForResume {

    /* Создание экземпляра класса, реализующего работу с базой данных*/
    CommandsForDataBase command = new CommandsForDataBase();

    /* Просмотр всех резюме*/
    public void viewResume(){
        System.out.println("Вы выбрали пункт: Просмотр всех резюме");
        command.viewResume(); //Вызов метода, отвечающего за реализацию просмотра всех резюме
        this.switcher(); //Возвращение в меню работы с вакансиями
    }

    /* Удаление резюме*/
    public void delResume(){
        System.out.println("Вы выбрали пункт: Удаление резюме");
        System.out.println("Введите резюме, которое нужно удалить");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt(); //Ввод id резюме, которое следует удалить
        command.delResume(id); //Вызов метода, отвечающего за реализацию удаления резюме
        this.switcher(); //Возвращение в меню работы с вакансиями
    }

    /* Поиск определенного резюме*/
    public void findResume(){
        System.out.println("Вы выбрали пункт: Поиск определенного резюме");
        System.out.println("Введите резюме, которое нужно найти");
        Scanner scanner = new Scanner(System.in);
        String res = scanner.next(); //Ввод имени резюме, которое следует удалить
        command.findResume(res); //Вызов метода, отвечающего за реализацию поиска резюме
        this.switcher(); //Возвращение в меню работы с вакансиями
    }

    /* Реализация возвращения в меню работы с резюме*/
    private void switcher(){
        SwitcherForResume switchRes = new SwitcherForResume();
        switchRes.switcher();
    }
}
