package com.doranco;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Edition implements Serializable {
    int id;
    User user;
    Article article;
    Date date;

    private static final String FILE_PATH_EDITION= "Edition.ser";
    private static List idList = Utils.readIdsFromFile(FILE_PATH_EDITION);

    public Edition(User user, Article article) {
        setId();
        this.user = user;
        this.article = article;

        Utils.saveToFile(this);
    }

    public int getId() {
        return id;
    }

    private void setId() {
        idList = Utils.readIdsFromFile(FILE_PATH_EDITION);
        this.id = Function.generateId(idList);
    }

    public User getUser() {
        return user;
    }

    public Article getArticle() {
        return article;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", user=" + user +
                ", article=" + article +
                ", date=" + date +
                '}';
    }
}
