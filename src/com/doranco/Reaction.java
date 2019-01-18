package com.doranco;

import java.io.Serializable;
import java.util.List;

public class Reaction implements Serializable {
    int id;
    User user;
    Article article;
    ReactionType reactionType;


    private static final String FILE_PATH_REACTION= "Reaction.ser";
    private static List idList = Utils.readIdsFromFile(FILE_PATH_REACTION);

    public Reaction(User user, Article article) {
        setId();
        this.user = user;
        this.article = article;

        Utils.saveToFile(this);
    }

    public int getId() {
        return id;
    }

    private void setId() {
        idList = Utils.readIdsFromFile(FILE_PATH_REACTION);
        this.id = Function.generateId(idList);
    }

    public User getUser() {
        return user;
    }

    public Article getArticle() {
        return article;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }
}
