# Food_Ordering_App
CSE600A Project - Java Command Line Application For Food Ordering

# Project Description: 

An online food ordering system accepts orders from customers and delivers at
customer’s address. Items are selected from a menu and the total bill amount is
calculated. Selected items may be put in a cart and addition, deletion of items in the cart
is possible. Once the order is confirmed, the time taken for delivery is intimated and the
order can be tracked. There are several payment modes, cash/wallet/bank
transfer/credit/debit card on delivery or pre-paid. Orders placed may be cancelled if
delivery time exceeds 10% of specified time.

# Technologies used:

JAVA

MY SQL

JProfiler

# Flow of the Program:

Initially the Main file is executed Main.java, then which following steps are taken place.
1) Sign Up is done in the SignUp.java, where authentication is done.
2) After singing up, menu is shown to the user where user can see the menu, which
is present in the ParentMenu, where View and adding on the cart such
functionalities are executed.
3) Then comes to the payment part which contains the functionalities such as
applying promo codes, checking minimum cart value etc, this part is present in
the Rest.java file

# How to run the Project

-> javac Main.java
-> java Main
