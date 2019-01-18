package com.doranco;

import java.util.ArrayList;
import java.util.List;

public class ArticlesActivity {
    List<Article> articles = new ArrayList();

    public ArticlesActivity() {
        setArticles();
        for (Article art : articles){
            System.out.println(art);
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
        System.out.println("Choose file. Enter number between 1 and " + articles.toArray().length);
    }
}
