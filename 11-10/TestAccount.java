package com.demo.test;

import com.demo.services.AccountService;
import com.demo.services.AccountServiceImpl;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;

import java.util.Scanner;

public class TestAccount {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Nedved bank..");
        System.out.print("Enter userName : ");
        String uName = scanner.next();
        System.out.print("Enter userPassword : ");
        String uPassword = scanner.next();
        LoginService loginService = new LoginServiceImpl();
        int whoIsThis = loginService.whoIsThis(uName,uPassword);

        if (whoIsThis == 1){
            int choice = 0;
            while(choice != 9){
                System.out.println("1. Open new account \n2. Display balance \n3. Withdraw cash \n4. Deposit \n5. Fund transfer");
                System.out.println("6. Change pin \n7. Close account \n8. Change question and ans \n9. Exit..  \n10. Display all");
                System.out.print("Enter your choice : " );
                choice = scanner.nextInt();

                switch (choice){
                    case 1 :
                            System.out.print("1. Savings \n2. Current \n Select : ");
                            int var = scanner.nextInt();
                            scanner.nextLine();
                            boolean res = false;
                            if(var == 1){
                               res = accountService.createAccount('S');
                            }
                            else if(var == 2){
                                res = accountService.createAccount('C');
                            }
                            if (res){
                                System.out.println("Account created successfully..");
                            }else{
                                System.out.println("Operation failed..");
                            }
                        break;
                    case 2:
                        System.out.print("Enter account number : ");
                        String acNo = scanner.next();
                        System.out.print("Enter pin : ");
                        int pin = scanner.nextInt();
                            boolean balance = accountService.displayBalance(acNo,pin);
                            if (balance){
                                System.out.println("Wrong credentials..");
                            }
                        break;
                    case 3:
                        System.out.print("Enter account number : ");
                        acNo = scanner.next();
                        System.out.print("Enter pin : ");
                        pin = scanner.nextInt();
                        System.out.print("Enter amount to withdraw : ");
                        int amount = scanner.nextInt();
                        int ans = accountService.withdrawCash(acNo,pin,amount);
                        if (ans == 1){
                            System.out.println("Operation successful...");
                        }else if(ans == 2){
                            System.out.println("Insufficient balance");
                        }else{
                            System.out.println("Wrong credentials");
                        }
                        break;
                    case 4:
                        System.out.print("Enter account number : ");
                        acNo = scanner.next();
                        System.out.print("Enter pin : ");
                        pin = scanner.nextInt();
                        System.out.print("Enter amount to deposit : ");
                        amount = scanner.nextInt();
                        boolean depositResult = accountService.depositAmount(acNo,pin,amount);
                        if (depositResult){
                            System.out.println("Amount added successfully..");
                        }else{
                            System.out.println("Wrong credentials..");
                        }
                        break;

                    case 5:
                        System.out.print("Enter account number : ");
                        acNo = scanner.next();
                        System.out.print("Enter pin : ");
                        pin = scanner.nextInt();
                        System.out.print("Enter amount to transfer : ");
                        amount = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter accountId of other person who you want to transfer : ");
                        String secondAccountId = scanner.next();
                        int fundTransfer = accountService.fundTransfer(acNo,pin,amount,secondAccountId);
                        if (fundTransfer == 1){
                            System.out.println("Fund transfer was successful..");
                        }else if(fundTransfer == 2){
                            System.out.println("Insufficient balance");
                        }else if(fundTransfer == 3){
                            System.out.println("Wrong credentials..");
                        }else{
                            System.out.println("No other user found so operation failed..");
                        }
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        accountService.showAll();

                        break;
                    default:
                        System.out.println("Only 10 options available..");
                        break;
                }
            }
        }
        else if (whoIsThis == 2){
            int choice = 0;
            while(choice != 9){
                System.out.println("1. Display all accounts  \n2. Sort by id \n3. Sort by balance \n4. Sort by name \n5. Set interest rate for savings \n6. Set min balance for savings ");
                System.out.println("7. Set interest rate for current account \n8. Set min balance for current account  \n9. Exit..");
                System.out.print("Enter your choice : " );
                choice = scanner.nextInt();

                switch (choice){
                    case 1 :
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Only 10 options available..");
                        break;
                }
            }
        }
        else{
            System.out.println("Wrong Credentials");
        }
        System.out.println("Start again.. Thank you..<3");
    }
}
