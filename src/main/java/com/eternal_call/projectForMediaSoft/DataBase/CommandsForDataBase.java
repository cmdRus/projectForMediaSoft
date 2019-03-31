package com.eternal_call.projectForMediaSoft.DataBase;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.*;


/* Реализация запросов к БД, связанных с вакансиями*/
public class CommandsForDataBase {

    /* Создание url, login, password, driverName */
    ConnectionToDataBase conn = new ConnectionToDataBase();

    /* Создание логгера, с получением имени класса*/
    private static Logger log = Logger.getLogger(CommandsForDataBase.class.getName());
    String file1 = "D:/Java/projects/git/projectForMediaSoft/logs/LogChanges.log"; // Путь файла для логирования изменений

    /* (Запрос) Удаление вакансии  */
    public void delVacancy (int id) {
        try{
            LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
            Handler fileHandlerChanges = new FileHandler(file1, true); //Объявление файла для логирования
            Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                    conn.getPassword()); // Создание подключения
            Statement state = connect.createStatement();
            String code = "DELETE FROM vacancy WHERE id LIKE '" + id + "%'"; //SQL запрос в БД
            state.executeUpdate(code); //Выполнение команды к базе данных MySQL
            log.addHandler(fileHandlerChanges);
            log.info("Удаление пользователя под id = "
                    + id + " успешно выполненно"); // Вывод логгера на экран и в файл
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /* (Запрос) Поиск вакансии  */
    public void findVacancy (String vac) {
        try{
            LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
            Handler fileHandlerChanges = new FileHandler(file1, true); //Объявление файла для логирования
            Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                    conn.getPassword()); // Создание подключения
            Statement state = connect.createStatement();
            String code = "SELECT * FROM vacancy WHERE name LIKE '" + vac + "%'" ; //SQL запрос в БД
            ResultSet resSet = state.executeQuery(code);
            log.addHandler(fileHandlerChanges);
            log.info("Поиск вакансии под именем: "
                    + vac + " успешно выполненно"); // Вывод логгера на экран и в файл
            while (resSet.next()){ //Вывод на экран результата запроса
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
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /* (Запрос) Создание вакансии */
    public void createVacancy (String nameNew, String dutiesNew, int conditionsNew, int salaryNew) {
        try{
            LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
            Handler fileHandlerChanges = new FileHandler(file1, true); //Объявление файла для логирования
            Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                    conn.getPassword()); // Создание подключения
            Statement state = connect.createStatement();
            String code = "INSERT INTO vacancy (name, duties, hoursInWeek, salary) VALUES ('"+nameNew + "', '"
                    + dutiesNew + "', '" + conditionsNew + "', '" + salaryNew + "')"; //SQL запрос в БД
            state.executeUpdate(code); //Выполнение команды к базе данных MySQL
            log.addHandler(fileHandlerChanges);
            log.info("Создание вакансии с параметрами: " + nameNew + "  " + dutiesNew + "  " + conditionsNew
                    + "  "  + salaryNew + "  " + " успешно выполненно"); // Вывод логгера на экран и в файл
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /* (Запрос) Просмотр всех вакансий в БД*/
    public void viewVacancy() {
        try{
            LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
            Handler fileHandlerChanges = new FileHandler(file1, true); //Объявление файла для логирования
            Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                    conn.getPassword()); // Создание подключения
            Statement state = connect.createStatement();
            ResultSet resSet = state.executeQuery("select * from vacancy"); //SQL запрос в БД
            log.addHandler(fileHandlerChanges);
            log.info("Просмотр всех вакансий успешно выполненно"); // Вывод логгера на экран и в файл
            while (resSet.next()){ //Вывод на экран результата запроса
                System.out.print(resSet.getInt(1) + " |  ");
                System.out.print(resSet.getString(2) + " |  ");
                System.out.print(resSet.getString(3) + " |  ");
                System.out.print(resSet.getString(4) + " |  ");
                System.out.println(resSet.getInt(5) + " |  ");
                System.out.println("--------------------------------------------------------------");
            }
            writerVacToFile(); // Метод для записи в файл результата
            connect.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e){
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
            try{ // Реализация записи вакансий в файл, которое срабатывает при нажатии 1
                Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
                Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                        conn.getPassword()); // Создание подключения
                Statement state = connect.createStatement();
                ResultSet resSet = state.executeQuery("select * from vacancy"); //SQL запрос в БД
                File fileName = new File("Vacancy.txt"); //Определение файла, для выгрузки всех вакансий
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                while (resSet.next()){ // Запись результата запроса в файл в файл
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
            LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
            Handler fileHandlerChanges = new FileHandler(file1, true); //Объявление файла для логирования
            Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                    conn.getPassword()); // Создание подключения
            Statement state = connect.createStatement();
            ResultSet resSet = state.executeQuery("select * from resume"); //SQL запрос в БД
            log.addHandler(fileHandlerChanges);
            log.info("Просмотр всех резюме успешно выполненно"); // Вывод логгера на экран и в файл
            while (resSet.next()){ //Вывод на экран результата запроса
                System.out.print(resSet.getInt(1) + " |  ");
                System.out.print(resSet.getString(2) + " |  ");
                System.out.print(resSet.getString(3) + " |  ");
                System.out.print(resSet.getString(4) + " |  ");
                System.out.println(resSet.getString(5) + " |  ");
                System.out.println("--------------------------------------------------------------");
            }
            writerResToFile(); // Метод для записи в файл результата
            connect.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e){
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
            try{ // Реализация записи резюме в файл, которое срабатывает при нажатии 1
                Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
                Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                        conn.getPassword()); // Создание подключения к БД
                Statement state = connect.createStatement();
                ResultSet resSet = state.executeQuery("select * from resume"); //SQL запрос в БД
                File fileName = new File("Resume.txt"); //Определение файла, для выгрузки всех резюме
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                while (resSet.next()){ // Запись результата запроса в файл в файл
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
            LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
            Handler fileHandlerChanges = new FileHandler(file1, true); //Объявление файла для логирования
            Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                    conn.getPassword()); // Создание подключения к БД
            Statement state = connect.createStatement();
            String code = "DELETE FROM resume WHERE id LIKE '" + id + "%'"; //SQL запрос в БД
            state.executeUpdate(code); //Выполнение команды к базе данных MySQL
            log.addHandler(fileHandlerChanges);
            log.info("Удаление резюме под id = "
                    + id + " успешно выполненно"); // Вывод логгера на экран и в файл
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /* (Запрос) Поиск резюме  */
    public void findResume (String res) {
        try{
            LogManager.getLogManager().readConfiguration(); // Чтение конфигурации логирования из файла
            Handler fileHandlerChanges = new FileHandler(file1, true); //Объявление файла для логирования
            Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                    conn.getPassword()); // Создание подключения к БД
            Statement state = connect.createStatement();
            String code = "SELECT * FROM resume WHERE specialty LIKE '" + res + "%'" ; //SQL запрос в БД
            ResultSet resSet = state.executeQuery(code);
            log.addHandler(fileHandlerChanges);
            log.info("Поиск вакансии под именем: "
                    + res + " успешно выполненно"); // Вывод логгера на экран и в файл
            while (resSet.next()){ //Вывод на экран результата запроса
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
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}