package com.example;
import java.util.*;
import java.lang.*;
import java.sql.*;

public class Signup {
    private String userName;
    private String city;
    private String password;

    Rest r = new Rest();

    public String getUName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getCity() {
        return city;
    }

    public void setUserName(String newUserName) {
        userName = newUserName;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public void setCity(String newCity) {
        city = newCity;
    }

    public static void registerUserInDatabase(Set<String> user_list, Set<String> pass_list ){
        Signup s = new Signup();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter UserName:");
        s.setUserName(sc.next());
        System.out.println("Enter City:");
        s.setCity(sc.next());
        System.out.println("Enter Password:");
        s.setPassword(sc.next());
        System.out.println("Customer has been registered");
        System.out.println("Username - " + s.getUName());
        System.out.println("City - " + s.getCity());
        //user_list.add(s.getUName()); 
        String u = s.getUName();
        String c = s.getCity();
        String p = s.getPassword();
        try {
        String dburl = "jdbc:mysql://localhost:3306/user";
        String user = "root";
        String password = "baqu";

        Connection con = DriverManager.getConnection(dburl,user,password); 
        Statement stmt=con.createStatement();  
        String query = " insert into user_details(username, city, password)" + "values (?, ?, ?)"; 
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString (1,u );
        preparedStmt.setString (2,c);
        preparedStmt.setString (3,p);
        preparedStmt.execute();
        
        ResultSet rs=stmt.executeQuery("select * from user_details");  
        while(rs.next())  {
             user_list.add(rs.getString("username"));
             pass_list.add(rs.getString("password"));
             
        } 
        con.close();
        }catch(Exception e){ System.out.println(e);}    
    }

    public  void loginUserFromDatabase(Set<String> user_list,Set<String> pass_list ){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter registered UserName:");
        String uName = sc.next();
        System.out.println("Enter Password:");
        String pass = sc.next();
        try {
        String dburl = "jdbc:mysql://localhost:3306/user";
        String user = "root";
        String password = "baqu";

        Connection con = DriverManager.getConnection(dburl,user,password); 
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from user_details");  
        while(rs.next())  {
             user_list.add(rs.getString("username"));
             pass_list.add(rs.getString("password"));
             
        } 
        con.close();
        }catch(Exception e){ System.out.println(e);} 
        boolean val = user_list.contains(uName);
        boolean val1 = pass_list.contains(pass);
        if(val && val1){
            System.out.println("Welcome " + uName + ",");
        }
        else {
            System.out.println("Enter Valid Details");
            System.exit(1);
        }
    }
}
