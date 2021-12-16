package com.example;
import java.util.*;

public class ParentMenu {
    public static void parentmenu() {
        System.out.println("Welcome to Tomato: ");
        System.out.println("    1) Sign Up ");
        System.out.println("    2) Log in ");
        System.out.println("    3) Exit ");
    }

    public void query1(Set<String> s1, Set<String> s2) {

        Signup s = new Signup();
        s.registerUserInDatabase(s1,s2);
    }

    public void query2(Set<String> s1, Set<String> s2) {

        Signup s = new Signup();
        s.loginUserFromDatabase(s1,s2);
    }

}
