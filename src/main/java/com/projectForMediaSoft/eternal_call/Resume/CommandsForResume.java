package com.projectForMediaSoft.eternal_call.Resume;
import com.projectForMediaSoft.eternal_call.DataBase.CommandsForDataBase;
import java.util.Scanner;


public class CommandsForResume {

    /* Просмотр резюме*/
    public void viewResume(){
        System.out.println("Вы выбрали пункт: Просмотр всех резюме");
        CommandsForDataBase command = new CommandsForDataBase();
        command.viewResume();
        SwitcherForResume switchRes = new SwitcherForResume();
        switchRes.switcher();
    }

    /* Удаление резюме*/
    public void delResume(){
        System.out.println("Вы выбрали пункт: Удаление резюме");
        System.out.println("Введите резюме, которое нужно удалить");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        CommandsForDataBase command = new CommandsForDataBase();
        command.delResume(id);
        System.err.println("Удаление успешно выполенно");
        SwitcherForResume switchRes = new SwitcherForResume();
        switchRes.switcher();
    }

    /* Поиск определенной вакансии*/
    public void findResume(){
        System.out.println("Вы выбрали пункт: Поиск определенного резюме");
        System.out.println("Введите резюме, которое нужно найти");
        Scanner scanner = new Scanner(System.in);
        String res = scanner.next();
        CommandsForDataBase command = new CommandsForDataBase();
        command.findResume(res);
        SwitcherForResume switchRes = new SwitcherForResume();
        switchRes.switcher();
    }
}
