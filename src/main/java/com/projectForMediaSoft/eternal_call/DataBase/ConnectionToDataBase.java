package com.projectForMediaSoft.eternal_call.DataBase;


/* Данные для подключения к БД*/
public class ConnectionToDataBase {
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/mediasoft?useSSL=false";
    private final String login = "root";
    private final String password = "BVCdsa45";

    public String getDriverName() {
        return driverName;
    }

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
