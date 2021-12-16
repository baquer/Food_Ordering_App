package com.example;
import java.util.*;
import java.lang.*;

/**
 * Hello world!
 */
public class App {
    public App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ParentMenu p = new ParentMenu();
        Rest r = new Rest();
        Set<String> Set = new HashSet<String>();
        Set<String> Set1 = new HashSet<String>();
        p.parentmenu();
        int option = in.nextInt();
        while(option!= 3) {
            if(option == 1) {
                p.query1(Set,Set1);
                p.parentmenu();
                option = in.nextInt();
            } else if(option == 3 ) {
                System.exit(1);
            } else if(option == 2) {
                p.query2(Set,Set1);
                System.out.println("Enter Current City");
                String currC = in.next();
                r.hardCodeCity();
                r.findCity(currC);
                break;
            }
        }

    }
}
