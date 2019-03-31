package com.eternal_call.projectForMediaSoft;
import com.eternal_call.projectForMediaSoft.DataBase.CommandsForDataBase;
import com.eternal_call.projectForMediaSoft.Resume.SwitcherForResume;
import com.eternal_call.projectForMediaSoft.Vacancy.SwitсherForVacancy;
import java.io.IOException;
import java.util.logging.*;


/* Реализация выбора работы с вакансиями или с резюме*/
public class SwitcherMain {

    /* Создание логгера, с получением имени класса*/
    private static Logger log = Logger.getLogger(CommandsForDataBase.class.getName());
    static String file1 = "D:/Java/projects/git/projectForMediaSoft/logs/LogExceptions.log"; // Путь файла для логирования ошибок

    /* Реализация работы главного меню*/
    public void switcher (int a) throws IOException {
        LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
        Handler fileHandlerException = new FileHandler(file1, true); //Объявление файла для логирования
        switch (a){
            case (1):{ //Реализация работы с вакансиями
                SwitсherForVacancy switcherVac = new SwitсherForVacancy();
                switcherVac.switcher();
                break;
            }case (2):{ //Реализация работы с резюме
                SwitcherForResume switcherRes = new SwitcherForResume();
                switcherRes.switcher();
                break;
            }case(3):{ //Выход из программы
                break;
            }default:
                log.addHandler(fileHandlerException);
                log.info("Вы ввели не корректное значение");
                Main main = new Main();
                main.mainer();
                break;
        }
    }
}