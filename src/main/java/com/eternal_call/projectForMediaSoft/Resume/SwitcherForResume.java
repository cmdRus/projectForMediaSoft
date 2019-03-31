package com.eternal_call.projectForMediaSoft.Resume;
import com.eternal_call.projectForMediaSoft.DataBase.CommandsForDataBase;
import com.eternal_call.projectForMediaSoft.Main;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class SwitcherForResume {

    /* Создание логгера, с получением имени класса*/
    private static Logger log = Logger.getLogger(CommandsForDataBase.class.getName());
    static String file1 = "D:/Java/projects/git/projectForMediaSoft/logs/LogExceptions.log"; // Путь файла для логирования ошибок

    /* Реализация выбора работы, с резюме */
    public void switcher() throws IOException {
        LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
        Handler fileHandlerException = new FileHandler(file1, true); //Объявление файла для логирования
        CommandsForResume comForResume = new CommandsForResume();
        this.outForWindow();
        int x = 0;
        try{ //Обработка правильности вводимого значения для выбора работы, с резюме
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();
        } catch (Exception e) {
            log.addHandler(fileHandlerException);
            log.info("Вы ввели не корректное значение");
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
                log.addHandler(fileHandlerException);
                log.info("Вы ввели не корректное значение");
                this.switcher();
                break;
        }
    }

    /* Метод вывода сообщений на экран*/
    private void outForWindow(){
        System.out.println("Просмотр всех резюме, нажмите 1");
        System.out.println("Удалить резюме, нажмите 2");
        System.out.println("Поиск определенной вакансии, нажмите 3");
        System.out.println("Вернутся в главное меню, нажмите 4");
    }
}