package com.projectForMediaSoft.eternal_call.dataBase;
import java.sql.*;
import java.util.Scanner;


/* Реализация запросов к БД, связанных с вакансиями*/
public class Commands {

    //Создание url, login, password, driverName
    Connect conn = new Connect();

    /* (Запрос) Просмотр всех вакансий в БД */
    public void viewVacancy() {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
            Statement state = connect.createStatement();
            ResultSet resSet = state.executeQuery("select * from vacancy");
            while (resSet.next()){
                System.out.print(resSet.getInt(1) + " |  ");
                System.out.print(resSet.getString(2) + " |  ");
                System.out.print(resSet.getString(3) + " |  ");
                System.out.print(resSet.getString(4) + " |  ");
                System.out.println(resSet.getInt(5) + " |  ");
                System.out.println("--------------------------------------------------------------");
            }
            connect.close();

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* (Запрос) Удаление вакансии  */
    public void delVacancy (String vac) {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
            Statement state = connect.createStatement();
            String code = "DELETE FROM vacancy WHERE name LIKE '" + vac + "%'";
            state.executeUpdate(code);
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* (Запрос) Поиск вакансии  */
    public void findVacancy (String vac) {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
            Statement state = connect.createStatement();
            String code = "SELECT * FROM vacancy WHERE name LIKE '" + vac + "%'" ;
            ResultSet resSet = state.executeQuery(code);
            while (resSet.next()){
                System.out.print(resSet.getInt(1)+"   ");
                System.out.print(resSet.getString(2)+"   ");
                System.out.print(resSet.getString(3)+"   ");
                System.out.println(resSet.getString(4));
                System.out.println(resSet.getInt(5) + " |  ");
                System.out.println("--------------------------------------------------------------");
            }
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* (Запрос) Создание вакансии */
    public void createVacancy (String nameNew, String dutiesNew, String conditionsNew, int salaryNew) {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
            Statement state = connect.createStatement();
            String code = "INSERT INTO vacancy (name, duties, conditions, salary) VALUES ('"+nameNew + "', '" + dutiesNew + "', '" + conditionsNew + "', '" + salaryNew + "')";
            state.executeUpdate(code);
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

