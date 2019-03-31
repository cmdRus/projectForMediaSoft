package com.eternal_call.projectForMediaSoft.Resume;
import com.eternal_call.projectForMediaSoft.Main;
import java.util.Scanner;


public class SwitcherForResume {

    /* Реализация выбора работы, с резюме */
    public void switcher(){
        CommandsForResume comForResume = new CommandsForResume();
        this.outForWindow();
        int x = 0;
        try{ //Обработка правильности вводимого значения для выбора работы, с резюме
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели не корректное число");
            this.switcher();
        }
        switch (x){
            case(1):{ // Просмотр всех резюме
                comForResume.viewResume();
                break;
            }case(2):{ // Удаление резюме
                comForResume.delResume();
                break;
            }case(3):{ // Поиск определенной вакансии
                comForResume.findResume();
                break;
            }case(4):{ //Вернутся в главное меню
                Main main = new Main();
                main.mainer();
                break;
            }default:
                System.err.println("Вы ввели не корректное число");
                this.switcher();
                break;
        }
    }

    /* Вывод на экран сообщений*/
    private void outForWindow(){
        System.out.println("Просмотр всех резюме, нажмите 1");
        System.out.println("Удалить резюме, нажмите 2");
        System.out.println("Поиск определенной вакансии, нажмите 3");
        System.out.println("Вернутся в главное меню, нажмите 4");
    }
}