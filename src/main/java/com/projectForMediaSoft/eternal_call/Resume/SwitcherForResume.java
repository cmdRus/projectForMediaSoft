package com.projectForMediaSoft.eternal_call.Resume;
import com.projectForMediaSoft.eternal_call.Main;
import java.util.Scanner;


public class SwitcherForResume {

    public void switcher(){
        CommandsForResume comForResume = new CommandsForResume();
        this.outForWindow();
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
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
                System.err.println("Упс. Вы где-то ошиблись");
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
