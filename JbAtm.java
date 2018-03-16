/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbatm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author jbundang
 */
public class JbAtm {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    public static String enteredPin;
    public static String pin = "1234";
    public static double balance;
    public static double amountWithdrawn;
    public static double amountDeposited;
    
    public static String displayMenu() {

        String choice = "";
        System.out.println("-------------------------");
        System.out.println("1. Inquire balance");     
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change Pin");  
        System.out.println("0. Exit");
        
        System.out.println("");
        System.out.print("Select a transaction: ");  

              
        try {
            choice = br.readLine();
            System.out.println("-------------------------");
            
            switch(choice) {
                
                case "1" :
                    for (int i=0; i < 3; i++) {
                        System.out.print("Please enter your pin: ");
                        try {
                            enteredPin = br.readLine();
                            if (enteredPin.equals(pin)) {
                                System.out.println("Your pin: " + pin);
                                getBalance();
                                displayMenu();
                                break;
                            } else if (!enteredPin.equals(pin)) {
                                
                            }
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    exit();
                    break;
                
                case "2" :
                    deposit();
                    break;
                
                case "3" :
                    for (int i=0; i < 3; i++) {
                        System.out.print("Please enter your pin: ");
                        try {
                            enteredPin = br.readLine();
                            if (!enteredPin.equals(pin) || enteredPin.length() != 4) {
                                
                            } else if (enteredPin.equals(pin)) {
                                withdraw();
                                break;
                            } 
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    exit();
                    break;
                
                case "4" :
                    changePin();                                    
                    break;
                
                case "0":
                    try {
                        int n = 0;
                        Runtime.getRuntime().exit(n);
                        System.exit(n);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choice;
       
    }
    
    public static String changePin() {
        String newPin = "";
        int ctr = 0;
  
        for (int i=0; i < 3; i++) {
            System.out.print("Enter your current pin: ");
                try {
                    enteredPin = br.readLine();
                    if (!enteredPin.equals(pin) || enteredPin.length() !=4){
                    
                    } else if (enteredPin.equals(pin)) {
                        while (ctr != 3) {
                            System.out.print("Enter you new pin: ");
                            newPin = br.readLine();
                        
                            if (newPin.length() != 4  || newPin.matches(".*[!@#$%&*()_+=|<>?{}\\[\\]~-].*") || newPin.matches(".*[A-Za-z]")) {
                                System.out.println("Invalid format!");
                            } else if (newPin.equals(pin)){
                                System.out.println("Current pin cannot be used as new pin.");
                                System.exit(i);
                                break;
                            } else {
                                pin = newPin;
                                System.out.println("New pin: " + pin); //checks pin's new value
                                displayMenu();      
                            }
                            ctr++;
                        }
                        exit();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        exit();
       return pin;    
    }

    public static double deposit() {
        String amount = "";
        amountDeposited = 0;
        
        for (int i=0; i < 3; i++) {
            System.out.print("Enter amount: ");
            try {
                amount = br.readLine();
                amountDeposited = Double.parseDouble(amount);
            
                if (amountDeposited < 0) {
                    System.out.println("Invalid amount!");
                } else {
                    balance = balance + amountDeposited;
                    System.out.println("Amount Deposited: " + amountDeposited);
                    System.out.println("Your current balance is: " + balance);
                    displayMenu();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return balance;
    }
    
    public static double withdraw() {
        String amount = "";
        amountWithdrawn = 0;
        
        for (int i=0; i < 3; i++) {
            System.out.print("Enter amount: ");
                try {
                    amount = br.readLine();
                    amountWithdrawn = Double.parseDouble(amount);
                    if (amountWithdrawn > balance){
                        System.out.println("Insufficient Fund!");
                        exit();
                    } else if (amountWithdrawn <= 0) {
                        System.out.println("Invalid amount!");
                    } else {
                        balance = balance - amountWithdrawn;
                        System.out.println("Your current balance is: " + balance);
                        displayMenu();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }  
        return balance;   
    }
    
    public static double getBalance() {
        if (balance <= 0){
            System.out.println("Your current balance is 0.0");
        } else {
            System.out.println("Your current balance is: " + balance);
        }
        return balance;
    }
    
    public static void exit(){
        try {
            int n = 0;
            Runtime.getRuntime().exit(n);
            System.exit(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        //for (int i=0; i < 3; i++) {
           displayMenu();
       //}
    }
    
}
