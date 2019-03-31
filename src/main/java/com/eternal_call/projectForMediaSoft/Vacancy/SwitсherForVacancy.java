package com.eternal_call.projectForMediaSoft.Vacancy;
import com.eternal_call.projectForMediaSoft.DataBase.CommandsForDataBase;
import com.eternal_call.projectForMediaSoft.Main;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;


public class SwitсherForVacancy {

    /* Создание логгера, с получением имени класса*/
    private static Logger log = Logger.getLogger(CommandsForDataBase.class.getName());
    static String file1 = "D:/Java/projects/git/projectForMediaSoft/logs/LogExceptions.log"; // Путь файла для логирования ошибок

    /* Реализация выбора работы, с вакансиями */
    public void switcher () throws IOException {
        LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
        Handler fileHandlerException = new FileHandler(file1, true); //Объявление файла для логирования
        CommandsForVacancy comForVac = new CommandsForVacancy(); // Создание объекта с командами, для работы с вакансиями
        this.outForWindow();
        int x = 0;
        try{ //Обработка правильности вводимого значения для выбора работы, с вакансиями
            Scanner scanner = new Scanner(System.in);
            x = scanner.nextInt();
        } catch (Exception e) {
            log.addHandler(fileHandlerException);
            log.info("Вы ввели не корректное значение");
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
            }default: // Обработка логером ошибки
                log.addHandler(fileHandlerException);
                log.info("Вы ввели не корректное значение");
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
