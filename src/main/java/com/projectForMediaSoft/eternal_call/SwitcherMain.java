package com.projectForMediaSoft.eternal_call;
import com.projectForMediaSoft.eternal_call.Vacancy.SwithcerVacancy;


/* Реализация выбора работы с вакансиями или с резюме*/
public class SwitcherMain {
        public void switcher (int a) {
            switch (a){
                case (1):{ //Реализация работы с вакансиями
                    SwithcerVacancy swithcerVac = new SwithcerVacancy();
                    swithcerVac.swith();
                    break;
                }case (2):{ //Реализация работы с резюме
                    System.err.println("В разработке");
                    break;
                }case(3):{ //Выход из программы
                    break;
                }default:
                    System.err.println("Упс. Вы где-то ошиблись");
                    break;
            }
        }
}
