package com.doranco;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Comment implements Serializable {
    int id;
    User user;
    Article article;
    Comment subcomment;
    String content;
    Date date;

    private static final String FILE_PATH_COMMENT= "Comment.ser";
    private static List idList = Utils.readIdsFromFile(FILE_PATH_COMMENT);

    public Comment(User user, Article article) {
        setId();
        this.user = user;
        this.article = article;
        this.date = new Date();
        Utils.saveToFile(this);
    }

    public int getId() {
        return id;
    }

    private void setId() {
        idList = Utils.readIdsFromFile(FILE_PATH_COMMENT);
        this.id = Function.generateId(idList);
    }

    public User getUser() {
        return user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Comment getSubcomments() {
        return subcomment;
    }

    public void setSubcomments(Comment subcomment) {
        this.subcomment = subcomment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", article=" + article +
                ", subcomment=" + subcomment +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
