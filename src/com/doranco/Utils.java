package com.doranco;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void saveToFile(Object object) {
    try {
        FileOutputStream fileOutputStream = new FileOutputStream(object.getClass().getSimpleName() + ".ser", true);
        //System.out.println("save function called " + object.getClass().getSimpleName() + ".ser" );
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println(object.getClass().getSimpleName() + " was saved");
    } catch (FileNotFoundException e) {
        //exception
    } catch (IOException e) {
        e.getMessage();
    }
}

    /*
    Read all ids from file to ensure the uniqueness of new users' ids
     */
    public static List readIdsFromFile(String filepath) {

        ObjectInputStream objectIn = null;
        User user;
        boolean next = true;
        List<Object> objects = new ArrayList<Object>();
        BufferedInputStream bf = null;

        try {
            bf = new BufferedInputStream(new FileInputStream(
                    filepath));
        } catch (FileNotFoundException e) {
            //caught exception
        }

        try {
            while (next) {
                objectIn = new ObjectInputStream(bf);

                if (objectIn != null) {
                    user = (User) objectIn.readObject();
                    objects.add(user.getId());
                } else {
                    next = false;
                    objectIn.close();

                }
            }
        } catch (Exception e) {
            e.getCause();
        }
        return objects;
    }
    /*
    Read all users from file
     */
    public static List readFromFile(String filepath) {
        ObjectInputStream objectIn = null;
        Object object;
        boolean next = true;
        List<Object> objects = new ArrayList<Object>();
        BufferedInputStream bf = null;

        try {
            bf = new BufferedInputStream(new FileInputStream(
                    filepath));
        } catch (FileNotFoundException e) {
            //exception
        }

        try {
            while (next) {
                objectIn = new ObjectInputStream(bf);

                if (objectIn != null) {
                    object = objectIn.readObject();
                    objects.add(object);
                } else {
                    next = false;
                    objectIn.close();

                }
            }
        } catch (Exception e) {
            e.getCause();
        }
        return objects;
    }

    /*
    Read an element by position in the list
     */

    public static Object readFromFile(int idIndex, String filepath) {
        ObjectInputStream objectIn = null;
        Object object=null;
        //boolean next = true;
        //List<Object> objects = new ArrayList<Object>();
        BufferedInputStream bf = null;

        try {
            bf = new BufferedInputStream(new FileInputStream(
                    filepath));
        } catch (FileNotFoundException e) {
            //exception
        }

        try {
            for (int i=0; i<=idIndex; i++) {
                objectIn = new ObjectInputStream(bf);

                if (objectIn != null) {
                    object = objectIn.readObject();
                } else {
                    objectIn.close();

                }
            }
        } catch (Exception e) {
            e.getCause();
        }
        return object;
    }
}