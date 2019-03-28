package dataBase;

import java.sql.*;
import java.util.Scanner;

public class jdbc {

    private final String driverName = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/mediasoft?useSSL=false";
    private final String login = "root";
    private final String password = "BVCdsa45";

    /* Просмотр всех вакансий в БД */

    public void viewVacancy() {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url, login, password);
            Statement state = connect.createStatement();
            ResultSet resSet = state.executeQuery("select * from vacancy");

            while (resSet.next()){
                System.out.print(resSet.getInt(1)+"   ");
                System.out.print(resSet.getString(2)+"   ");
                System.out.print(resSet.getString(3)+"   ");
                System.out.println(resSet.getString(4));
                System.out.println("------------------------");
            }
            connect.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /* Поиск вакансии  */
    public void findVakans (String vac) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url, login, password);
            Statement state = connect.createStatement();
            String code = "select " + vac + " from vacancy";
            ResultSet resSet = state.executeQuery(code);
            while (resSet.next()){
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
