package com.eternal_call.projectForMediaSoft.DataBase;


/* Данные для подключения к БД*/
public class ConnectionToDataBase {
    private final String driverName = "com.mysql.jdbc.Driver"; // Определение имени драйвера
    private static String url = "jdbc:mysql://localhost:3306/mediasoft?useSSL=false";
    private static String login = "root";
    private static String password = "BVCdsa45";

    public String getdDriverName (){
        return driverName;
    }

    public String getdUrl (){
        return url;
    }

    public String getdLogin (){
        return login;
    }

    public String getPassword (){
        return password;
    }
}
