package com.eternal_call.projectForMediaSoft;
import com.eternal_call.projectForMediaSoft.Resume.SwitcherForResume;
import com.eternal_call.projectForMediaSoft.Vacancy.SwitсherForVacancy;


/* Реализация выбора работы с вакансиями или с резюме*/
public class SwitcherMain {
        public void switcher (int a) {
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
                    System.out.println("Вы ввели не корректное число");
                    Main main = new Main();
                    main.mainer();
                    break;
            }
        }
}
