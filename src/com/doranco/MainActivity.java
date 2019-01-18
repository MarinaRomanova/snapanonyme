package com.doranco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity {
    static Scanner sc;

    public MainActivity() {
         sc = new Scanner(System.in);
        displayWelcomeScreen();
    }

    public static void login(){
        System.out.println();
        System.out.println(("Log in").toUpperCase());
        System.out.println("Enter your login");
        String login = sc.nextLine();
        List objects = Utils.readFromFile("User.ser");
        List<User> users = new ArrayList<User>();
        for (Object obj : objects){
            users.add((User)obj);
        }
        List logins = new ArrayList();
        List passwords = new ArrayList();
        for ( User user : users ){
            logins.add(user.getLogin());
            passwords.add(user.getPassword());
        }
        //System.out.println("LOGINS: " + logins);
        /*
        Verify if login exists
        */

        if(!(logins.contains(login))) {
            System.out.println("User with such login is not found");
            System.out.println("1 - Try again\n2 - Sign Up\n0 - EXIT");
            String choice = sc.nextLine();
            switch (choice){
                case "1" : login();
                    break;
                case "2" : subscribe();
                    break;
                case "0" : System.exit(-1);
                default:
                    System.out.println("Incorrect input, return to main screen");
                    displayWelcomeScreen();
                    break;
            }
        }
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        int index = logins.indexOf(login); // index of entered login in order to match with the password
        String passVerify =  passwords.get(index).toString();
        if(password.equals(passVerify)){
            System.out.println("You are logged in with success");
            /*------------------------------------------------
            Log in successful and starting Articles Activity
            --------------------------------------------------
             */
            new ArticlesActivity();
            //System.out.println(Utils.readFromFile("Article.ser"));
        }
        else {
            System.out.println("Password is not correct");
            login();
        }
    }

    public static void subscribe(){
        System.out.println();
        System.out.println(("Let sign you up").toUpperCase());
        System.out.println("Enter your login");
        String login = sc.nextLine();
        String password, confirmedPassword;
        do{
            System.out.println("Enter password");
            password = sc.nextLine();
            System.out.println("Confirm password");
            confirmedPassword = sc.nextLine();
        } while (!password.equals(confirmedPassword));
        System.out.println("Login: " + login + " Password: " + password);
        User u = new User(login, password);
        System.out.println("New user: " + u);
        System.out.println("Users saved: "+ Utils.readFromFile("User.ser"));
        login();
    }

    public static void displayWelcomeScreen() {
        System.out.println("Welcome to SnapAnonyme!\n1 - To subscribe\n2 - To login\n0 -EXIT");
        switch (sc.nextLine()) {
            case "1":
                subscribe();
                break;
            case "2":
                login();
                break;
            case "0":
                System.out.println("EXIT");
                System.exit(-1);
                break;
            default:
                System.out.println("Incorrect input");
                displayWelcomeScreen();
                break;
        }
    }
}
