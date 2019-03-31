package com.eternal_call.projectForMediaSoft.DataBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderCfg {

    /* Считывание данных (url) для подключения из файла*/
    public String inPutUrl() throws IOException {
        File file = new File("cfg.txt"); //Определение файла, для загрузки данных
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        final String url = lines.get(1);
        bufferedReader.close();
        return url;
    }

    /* Считывание данных (login) для подключения из файла*/
    public String inPutLogin() throws IOException {
        File file = new File("cfg.txt"); //Определение файла, для загрузки данных
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        final String login = lines.get(3);
        bufferedReader.close();
        return login;
    }

    /* Считывание данных (password) для подключения из файла*/
    public String inPutPassword() throws IOException {
        File file = new File("cfg.txt"); //Определение файла, для загрузки данных
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        final String password = lines.get(5);
        bufferedReader.close();
        return password;
    }
}
