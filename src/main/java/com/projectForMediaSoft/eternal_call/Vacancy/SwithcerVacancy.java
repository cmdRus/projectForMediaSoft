package com.projectForMediaSoft.eternal_call.Vacancy;

import com.projectForMediaSoft.eternal_call.dataBase.Commands;
import java.util.Scanner;


public class SwithcerVacancy {
    final static String ESC = "\033[";

    /* Реализация выбора работы, с вакансиями */
    public void swith (){
        System.out.print(ESC + "2J");
        VacancyMechanic vac = new VacancyMechanic();
        System.out.println("Создание вакансии, нажмите 1");
        System.out.println("Поиск определенной вакансии, нажмите 2");
        System.out.println("Просмотр всех вакансий, нажмите 3");
        System.out.println("Удаление вакансии, нажмите 4");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        switch (x){
            case (1):{ // Создание вакансии
                System.err.println("В разработке");
                break;
            }case (2):{ // Поиск определенной вакансии
                System.err.println("В разработке");
                break;
            }case (3):{ //Просмотр всех вакансий
                vac.viewVacancy();
                break;
            }case (4):{ //Удаление вакансии
                System.err.println("В разработке");
                break;
            }default:
                System.err.println("Упс. Вы где-то ошиблись");
                break;
        }
    }
}
