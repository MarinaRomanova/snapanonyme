package com.doranco;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ArticlesActivity {
    List<Article> articles = new ArrayList();

    public ArticlesActivity() {
        setArticles();
        System.out.println("\n-------------PHOTOS-----------------");
        int count = 0;
        for (Article art : articles){
            count++;
            System.out.println( count +". " + art);
        }
        chooseArticle();

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
