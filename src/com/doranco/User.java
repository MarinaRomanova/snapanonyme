package com.doranco;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User implements Serializable {
    private int id;
    private String login;
    private String password;
    private static final String FILE_PATH= "User.ser";
    private static List idList = Utils.readIdsFromFile(FILE_PATH);


    public User(String login, String password) {
        //
        setId();
        this.login = login;
        this.password = password;
        Utils.saveToFile(this);
        System.out.println(idList);
    }

    public int getId() {
        return id;
    }

    private void setId() {
        idList = Utils.readIdsFromFile(FILE_PATH);
        this.id = Function.generateId(idList);
        System.out.println("Users list: " + idList);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return '{'+ this.getClass().getSimpleName() +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

