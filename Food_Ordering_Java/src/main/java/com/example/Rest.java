package com.example;

import java.util.*;
import java.lang.*;
import java.sql.*;

class Item {

        String item ;
        int price;
        int quan;
        int time;
        
        Item(String item, int price, int quan, int time) {
            this.item = item;
            this.price = price;
            this.quan = quan;
            this.time = time;
        }
    }

public class Rest {
    
    List<String> city = new ArrayList<String>();
    List<String> restaurant = new ArrayList<String>();

    List<String> cart = new ArrayList<String>();
    List<Integer> pri = new ArrayList<Integer>();
    List<Integer> timest = new ArrayList<Integer>();

    Scanner sc = new Scanner(System.in);
    HashSet<Item> set = new HashSet<Item>(); 

    Random rand = new Random();
    
    int delivery = 0;
    int count1 = 1;
    int count2 = 1;
    int bal = 0;
    int ts = 0;

    public void hardCodeCity() {
        city.add("Delhi");
        city.add("Mumbai");
        city.add("Lucknow");
        city.add("Prayagraj");
        city.add("Chennai");
    }

    public void hardCodeRestaurant() {
        restaurant.add("Keventers");
        restaurant.add("Delight");
        restaurant.add("Gourmet Wake");
        restaurant.add("Al-Baik");
        restaurant.add("Dominos");
        restaurant.add("KFC");
        restaurant.add("Behrouz Biryani");
        restaurant.add("Shri Ram Bhojnalaya");
        restaurant.add("BBQ");
    }

    public void storeMenuInDatabase() {

        Item b1 = new Item("Kit Kat Shake", 100, 100, 60);  
        set.add(b1);
        Item b2 = new Item("Cold Coffee", 150, 100, 60);  
        set.add(b2);
        Item b3 = new Item("Dark Conspiracy Sundae", 200, 100, 60);  
        set.add(b3);
        Item b4 = new Item("Unicorn Candy Sundae", 250, 100, 60);  
        set.add(b4);
        Item b5 = new Item("Hot Chocolate Fudge", 200, 100, 60);  
        set.add(b5);
        Item b6 = new Item("Black Forest Pastry", 40, 50, 45);  
        set.add(b6);
        Item b7 = new Item("Veg Chowmin", 100, 50, 45 );  
        set.add(b7);
        Item b8 = new Item("Chicken Chowmin", 150, 50, 45);  
        set.add(b8);
        Item b9 = new Item("Veg Patties", 20, 50, 45);  
        set.add(b9);
        Item b10 = new Item("Veg Roll", 50, 50, 45);  
        set.add(b10);
        Item b11 = new Item("Butter Chicken", 200, 10, 60);  
        set.add(b11);
        Item b12 = new Item("Mutton Biryani", 200, 10, 60);  
        set.add(b12);
        Item b13 = new Item("Mutton Handi", 200, 10, 60);  
        set.add(b13);
        Item b14 = new Item("Bhuna Mutton", 200, 10, 60);  
        set.add(b14);
        Item b15 = new Item("Navratan Pulao", 150, 10, 60);  
        set.add(b15);
        Item b16 = new Item("Onion Pizza", 90, 75, 30);  
        set.add(b16);
        Item b17 = new Item("Paneer Pizza", 100, 75, 30);  
        set.add(b17);
        Item b18 = new Item("Veg Pizza", 110, 75, 30);  
        set.add(b18);
        Item b19 = new Item("Non-Veg Pizza", 200, 75, 30);  
        set.add(b19);
        Item b20 = new Item("Veg Burger", 80, 75, 30);  
        set.add(b20);
        Item b21 = new Item("Mac Aloo Tikki", 80, 75, 30);  
        set.add(b21);
        Item b22 = new Item("Mac Chicken Tikki", 100, 75, 30);  
        set.add(b22);
        Item b23 = new Item("Mix Sweets", 180, 75, 30);  
        set.add(b23);
        Item b24 = new Item("Gulab Jamun", 190, 75, 30);  
        set.add(b24);
        Item b25 = new Item("Mix Fruit Icecream", 50, 75, 30);  
        set.add(b25);
        Item b26 = new Item("Butter Scotch", 80, 130, 20);  
        set.add(b26);
        Item b27 = new Item("Shahi Paneer", 80, 130, 20);  
        set.add(b27);
        Item b28 = new Item("Chola Bhatura", 200, 130, 20);  
        set.add(b28);
        Item b29 = new Item("Plain Dosa", 80, 130, 20);  
        set.add(b29);
        Item b30 = new Item("Matar Pulao", 80, 130, 20);  
        set.add(b30);
        
        try{  
          String dburl = "jdbc:mysql://localhost:3306/user";
          String user = "root";
          String password = "baqu";

          Connection con=DriverManager.getConnection(dburl,user,password); 
          Statement stmt=con.createStatement();  
          ResultSet rs=stmt.executeQuery("select * from menu_item"); 
          System.out.println("Restaurant Menu are as Follows:");
          System.out.println("DISH -----> Price -----> Available Items -----> Expected Time"); 
          while(rs.next())  
                System.out.println(rs.getString("dish")+" ----> "+rs.getInt("price")+" -----> "+rs.getInt("quantity")+ "----> "+ rs.getInt("expTime"));  
          con.close();  
          }catch(Exception e){ System.out.println(e);}  
    }

    public void findCity(String city1) {
        Rest b = new Rest();
        boolean var = city.contains(city1);
        if(var) {
            System.out.println("Available Restaurant in your city");
            System.out.println();
            b.hardCodeRestaurant();
            b.findRestaurant(city1);
        } else {
            System.out.println("Sorry! we are currently not delivering in your city. We will update you soon");
        }
    }

    public void findRestaurant(String City) {
        hardCodeCity();
        boolean var = city.contains(City);
        if(var) {
            for(String st: restaurant) {
                System.out.println(st);
            }
            System.out.println();
            System.out.println("Choose any Restaurant");
            String rest = sc.next();
            System.out.println();

            boolean v = restaurant.contains(rest);
            if(v) {
                for(Item i: set) {
                   System.out.println(i.item + "------>  " +  i.price + "----->  " + i.quan+ "----->  " + i.time);
                }
                addItem();
            }

        }
    }

    public void addItem() {
        storeMenuInDatabase();
        System.out.println("How many Item you wants to buy ?");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.println("Enter Your item name?");
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");
            String name = scanner.nextLine();
            for(Item j: set) {
                if(j.item.equals(name)) {
                    cart.add(j.item);
                    System.out.println("How much this item you want to order?");
                    int q = sc.nextInt();
                    if(q > j.quan) {
                        System.out.println("Sorry! we have only " + j.quan + " item left");
                    }
                    int price = j.price * q;
                    j.quan = j.quan - q;
                    pri.add(price);
                    timest.add(j.time);
                    break;
                }
            }
        }
        // Items in Cart
        System.out.println("Items In Cart are as follows");
        for(String k: cart) {
            System.out.println(k);
        }
        // Amount in Cart
        System.out.println("Prices of Items are as follows");
        for(int L: pri) {
            System.out.println(L);
            bal += L;
        }
        System.out.println("Your amount sum is" + " " +bal);
        // Expected Delivery Time
        for(int M: timest) {
            ts = Math.max(ts, M);   
        }
        System.out.println("Your Expected Delivery Time in mins are" + " " + ts);  
        calculatePrice(bal);
        tracking(ts);
    }

    public void calculatePrice(int ans) {
        if(ans <= 100) {
            System.out.println("OOPs the minimum price to order is 100");
        }
        System.out.println("Please Enter your address");
        String addr = sc.next();
        delivery = calculatedistance();
        System.out.println("Based on your address and restaurant distance your delivery charges are " + delivery);
        System.out.println("Enter Your Coupon code, It is valid for one time only");
        String coupen = sc.next();
        if(coupen.equals("SAVE50")) {
            ans = ans + delivery - 50;
            count1 -= 1;
        }else if(coupen.equals("SAVE20")) {
            ans = ans + delivery - 20;
            count2 -= 2;
        } else {
            ans = ans + delivery;
        }

        System.out.println("Your total amount is  "+ ans);

        // Payment via UPI

        System.out.println("Click here to pay the amount via UPI/credit/debit");
        System.out.println("https://razorpay.com/pay");
        System.out.println("Payment Done");

    }

    public int calculatedistance() {
        int dis = rand.nextInt(50);
        if(dis < 10) {
            return 0;
        } else if (dis >= 10 && dis < 20) {
            return 10;
        } else if(dis >= 20 && dis < 30) {
            return 20;
        } else {
            return 30;
        }
    }

    public void tracking(int timestamp) {
        int up = rand.nextInt(3);
        int fin = timestamp + up;
        if(fin > timestamp  + (0.1*timestamp)) {
            System.out.println("Sorry! We are trying our best to deliver your order soon");
            System.out.println("Do You wish to cancle your order? If so contact our executive..");

        } else {
            System.out.println("Hurray! Your order is delivered");
            System.out.println("Thank You!");
        }
    }
}
