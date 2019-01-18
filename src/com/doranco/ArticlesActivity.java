package com.doranco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ArticlesActivity {
    List<Article> articles = new ArrayList();
    int index;

    public ArticlesActivity(int index) {
        this.index = index;
        setArticles();
        System.out.println(Utils.readFromFile(index, "User.ser"));
        displayArticles();
        chooseAction(index);
    }

    private void chooseAction(int index){
        System.out.println("\n************\nChoose between\n1 - View Photo Details\n2 - Upload photo\n3 - Home screen\n0 - EXIT");
        switch ((new Scanner(System.in)).nextLine()){
            case "1": chooseArticle();
            break;
            case "2": createArticle(index);
            break;
            case "3": new MainActivity(index);
            case"0": System.exit(-1);
            break;
            default: chooseAction(index);
            break;

        }
    }

    private void createArticle(int index){
        User user = (User)Utils.readFromFile(index, "User.ser");
        Fichier f = null;
        try {
            f = new Fichier("brand_new_file.jpg");
            Article art = new Article(f, user);
            articles= new ArrayList<>();
            setArticles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayArticles();
        chooseAction(index);
    }
    private void displayArticles(){
        System.out.println("\n-------------PHOTOS-----------------");
        int count = 0;
        for (Article art : articles){
            count++;
            System.out.println( count +". " + art);
        }
    }

    private void setArticles() {
        List objects = Utils.readFromFile("Article.ser");
        for (Object object : objects){
            articles.add((Article)object);
        }
    }

    private void chooseArticle() {
        int listLength = articles.toArray().length; //number of articles available
        System.out.println("\nChoose file. Enter number between 1 and " + listLength);
        int choice = 0;
        try{
            choice = (new Scanner(System.in)).nextInt();
        }catch (InputMismatchException e) {
            System.out.println("Incorrect input");
            chooseArticle();
        }

        if(choice >0 && Integer.valueOf(choice)<=listLength){
            System.out.println("You chose:\n" + articles.get(Integer.valueOf(choice) -1));

        }else{
            System.out.println("Incorrect input");
            chooseArticle();
        }

    }
}
