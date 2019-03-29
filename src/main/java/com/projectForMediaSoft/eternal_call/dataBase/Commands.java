package com.projectForMediaSoft.eternal_call.dataBase;
import java.sql.*;


/* Реализация запросов к БД, связанных с вакансиями*/
public class Commands {

    //Создания URL, Login, password, driverName
    Connect conn = new Connect();

    /* (Запрос) Просмотр всех вакансий в БД */
    public void viewVacancy() {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getdPassword());
            Statement state = connect.createStatement();
            ResultSet resSet = state.executeQuery("select * from vacancy");
            while (resSet.next()){
                System.out.print(resSet.getInt(1) + " |  ");
                System.out.print(resSet.getString(2) + " |  ");
                System.out.print(resSet.getString(3) + " |  ");
                System.out.print(resSet.getString(4) + " |  ");
                System.out.println(resSet.getInt(5) + " |  ");
                System.out.println("------------------------");
            }
            connect.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* (Запрос) Поиск вакансии  */
    public void findVakans (String vac) {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getdPassword());
            Statement state = connect.createStatement();
            String code = "select " + vac + " from vacancy";
            ResultSet resSet = state.executeQuery(code);
            while (resSet.next()){ //лямба
                System.out.print(resSet.getInt(1)+"   ");
                System.out.print(resSet.getString(2)+"   ");
                System.out.print(resSet.getString(3)+"   ");
                System.out.println(resSet.getString(4));
                System.out.println("------------------------");
            }
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
