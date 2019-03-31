package com.projectForMediaSoft.eternal_call.DataBase;
import java.io.*;
import java.sql.*;
import java.util.Scanner;


/* Реализация запросов к БД, связанных с вакансиями*/
public class CommandsForDataBase {

    /* Создание url, login, password, driverName */
    ConnectionToDataBase conn = new ConnectionToDataBase();

    /* (Запрос) Удаление вакансии  */
    public void delVacancy (int id) {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
            Statement state = connect.createStatement();
            String code = "DELETE FROM vacancy WHERE id LIKE '" + id + "%'";
            // String code = "DELETE FROM vacancy WHERE id LIKE '" + name + "%'";
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
    public void createVacancy (String nameNew, String dutiesNew, int conditionsNew, int salaryNew) {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
            Statement state = connect.createStatement();
            String code = "INSERT INTO vacancy (name, duties, hoursInWeek, salary) VALUES ('"+nameNew + "', '" + dutiesNew + "', '" + conditionsNew + "', '" + salaryNew + "')";
            state.executeUpdate(code);
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* (Запрос) Просмотр всех вакансий в БД*/
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
            writerVacToFile();
            connect.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Реализация записи вакансий в файл*/
    private void writerVacToFile() {
        System.out.println("Хотите выгрузить всё в файл? Нажмите 1");
        System.out.println("В обратном случае, нажмите 2");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a==1) {
            try{
                Class.forName(conn.getdDriverName());
                Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
                Statement state = connect.createStatement();
                ResultSet resSet = state.executeQuery("select * from vacancy");
                File fileName = new File("Vacancy.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                while (resSet.next()){
                    writer.write(resSet.getInt(1) + " |  ");
                        writer.write(resSet.getString(2) + " |  ");
                        writer.write(resSet.getString(3) + " |  ");
                        writer.write(resSet.getString(4) + " |  ");
                        writer.write(resSet.getInt(5) + " |  \n");
                        writer.write("-------------------------------------------------------------- \n");
                }
                writer.flush();
                writer.close();
                connect.close();
            }catch (IOException ex){
                ex.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* (Запрос) Просмотр всех резюме в БД*/
    public void viewResume() {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
            Statement state = connect.createStatement();
            ResultSet resSet = state.executeQuery("select * from resume");
            while (resSet.next()){
                System.out.print(resSet.getInt(1) + " |  ");
                System.out.print(resSet.getString(2) + " |  ");
                System.out.print(resSet.getString(3) + " |  ");
                System.out.print(resSet.getString(4) + " |  ");
                System.out.println(resSet.getString(5) + " |  ");
                System.out.println("--------------------------------------------------------------");
            }
            writerResToFile();
            connect.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Реализация записи резюме в файл*/
    private void writerResToFile() {
        System.out.println("Хотите выгрузить всё в файл? Нажмите 1");
        System.out.println("В обратном случае, нажмите 2");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a==1) {
            try{
                Class.forName(conn.getdDriverName());
                Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
                Statement state = connect.createStatement();
                ResultSet resSet = state.executeQuery("select * from resume");
                File fileName = new File("Resume.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                while (resSet.next()){
                    writer.write(resSet.getInt(1) + " |  ");
                    writer.write(resSet.getString(2) + " |  ");
                    writer.write(resSet.getString(3) + " |  ");
                    writer.write(resSet.getString(4) + " |  ");
                    writer.write(resSet.getString(5) + " |  \n");
                    writer.write("-------------------------------------------------------------- \n");
                }
                writer.flush();
                writer.close();
                connect.close();
            }catch (IOException ex){
                ex.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* (Запрос) Удаление резюме  */
    public void delResume (int id) {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
            Statement state = connect.createStatement();
            String code = "DELETE FROM resume WHERE id LIKE '" + id + "%'";
            state.executeUpdate(code);
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* (Запрос) Поиск резюме  */
    public void findResume (String res) {
        try{
            Class.forName(conn.getdDriverName());
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),conn.getPassword());
            Statement state = connect.createStatement();
            String code = "SELECT * FROM resume WHERE specialty LIKE '" + res + "%'" ;
            ResultSet resSet = state.executeQuery(code);
            while (resSet.next()){
                System.out.print(resSet.getInt(1) + " |  ");
                System.out.print(resSet.getString(2) + " |  ");
                System.out.print(resSet.getString(3) + " |  ");
                System.out.print(resSet.getString(4) + " |  ");
                System.out.println(resSet.getString(5) + " |  ");
                System.out.println("--------------------------------------------------------------");
            }
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}