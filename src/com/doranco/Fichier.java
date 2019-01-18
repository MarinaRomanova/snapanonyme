package com.doranco;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

public class Fichier implements Serializable {
    int id;
    String url;
    float size;
    String mimeType;

    private static final String FILE_PATH_FICHIER= "Fichier.ser";
    private static List idList = Utils.readIdsFromFile(FILE_PATH_FICHIER);

    public Fichier(String url) throws IOException {
        setId();
        this.url = url;
        mimeType = Files.probeContentType((new File(url)).toPath());

        Utils.saveToFile(this);
        System.out.println("Fichier list " +idList);
        System.out.println("Fichier created is " + this);
    }

    public int getId() {
        return id;
    }

    private void setId() {
        idList = Utils.readIdsFromFile(FILE_PATH_FICHIER);
        this.id = Function.generateId(idList);
    }

    public String getUrl() {
        return url;
    }

    public float getSize() {
        return size;
    }

    public String getMimeType() {
        return mimeType;
    }

    @Override
    public String toString() {
        return "Fichier{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", size=" + size +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }
}
