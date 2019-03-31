package com.eternal_call.projectForMediaSoft.Vacancy;
import com.eternal_call.projectForMediaSoft.Main;
import java.util.Scanner;


public class SwitсherForVacancy {

    /* Реализация выбора работы, с вакансиями */
    public void switcher (){
        CommandsForVacancy comForVac = new CommandsForVacancy();
        this.outForWindow();
        int x = 0;
        try{ //Обработка правильности вводимого значения для выбора работы, с вакансиями
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели не корректное число");
            this.switcher();
        }
        switch (x){
            case (1):{ // Создание вакансии
                comForVac.createVakancy();
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
                System.out.println("Вы ввели не корректное число");
                this.switcher();
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
