package com.projectForMediaSoft.eternal_call.Vacancy;
import com.projectForMediaSoft.eternal_call.Main;
import java.util.Scanner;


public class SwitсherForVacancy {

    /* Реализация выбора работы, с вакансиями */
    public void switcher (){
        CommandsForVacancy comForVac = new CommandsForVacancy();
        this.outForWindow();
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        switch (x){
            case (1):{ // Создание вакансии
                comForVac.createVakans();
                break;
            }case (2):{ // Поиск определенной вакансии
                comForVac.findVacancy();
                break;
            }case (3):{ //Просмотр всех вакансий
                comForVac.viewVacancy();
                break;
            }case (4):{ //Удаление вакансии
                comForVac.delVacancy();
                break;
            }case (5):{ //Вернутся в главное меню
                Main main = new Main();
                main.mainer();
                break;
            }default:
                System.err.println("Упс. Вы где-то ошиблись");
                break;
        }
    }

    private void outForWindow(){
        System.out.println("Вы выбрали работу с вакансиями");
        System.out.println("Создание вакансии, нажмите 1");
        System.out.println("Поиск определенной вакансии, нажмите 2");
        System.out.println("Просмотр всех вакансий, нажмите 3");
        System.out.println("Удаление вакансии, нажмите 4");
        System.out.println("Вернутся в главное меню, нажмите 5");
    }
}
