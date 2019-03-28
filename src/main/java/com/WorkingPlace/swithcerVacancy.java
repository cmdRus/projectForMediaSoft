package com.WorkingPlace;

public class swithcerVacancy {
    public swithcerVacancy (int a){
        Vacancy vac = new Vacancy();
        switch (a){
            case (1):{
                System.out.println("Создание вакансии");
                vac.createVakans();
                break;
            }case (2):{
                System.out.println("Поиск определенной вакансии");
                vac.findVakans();
                break;
            }case (3):{
                System.out.println("Просмотр всех вакансий");
                vac.viewVacancy();
                break;
            }case (4):{
                System.out.println("Удаление вакансии");
                vac.delVacancy();
                break;
            }default:
                System.out.println("Упс. Вы где-то ошиблись");
                break;
        }
    }
}
