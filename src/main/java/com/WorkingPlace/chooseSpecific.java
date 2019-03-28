package com.WorkingPlace;

import java.util.Scanner;

public class chooseSpecific {

    public void chech (int a) {
        switch (a){
            case (1):{
                System.out.println("Создание вакансии, нажмите 1");
                System.out.println("Поиск определенной вакансии, нажмите 2");
                System.out.println("Просмотр всех вакансий, нажмите 3");
                System.out.println("Удаление вакансии, нажмите 4");
                Scanner scanner = new Scanner(System.in);
                int x = scanner.nextInt();
                swithcerVacancy sV = new swithcerVacancy(x);
                break;
            }case (2):{
                break;
            }default:
                System.out.println("Упс. Вы где-то ошиблись");
                break;
        }
    }
}
