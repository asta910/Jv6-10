import com.demo.interfaces.AccountImpl;
import com.demo.interfaces.AccountInterface;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AccountInterface accountInterface = new AccountImpl();
        System.out.println("Welcome to NEDVED Bank.. ");
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while(choice!=8){
            System.out.println("1. Create new account \n2. Show balance \n3. Withdraw money \n4. Transfer money \n5. Deposit amount \n6. Change pin \n7. Delete Account \n8.Exit...");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    boolean val = accountInterface.addNewAccount();
                    if(val){
                        System.out.println("Account created successfully");
                    }else{
                        System.out.println("Operation failed");
                    }
                    break;
                case 2:
                    accountInterface.showBalance();
                    break;
                case 3:

                    val = accountInterface.withdrawMoney();
                    if (val){
                        System.out.println("Operation successfull..");
                    }else{
                        System.out.println("Operation failed..");
                    }

                    break;
                case 4:
                    boolean trans = accountInterface.fundTransfer();
                    if(trans){
                        System.out.println("Amount transferred Successfully");
                    }else{
                        System.out.println("Operation failed");
                    }
                    break;
                case 5:
                    boolean fund = accountInterface.depositAmt();
                    if(fund){
                        System.out.println("Operation successful..");
                    }else{
                        System.out.println("Operation failed..");
                    }
                    break;
                case 6:


                    break;
                case 7:
                    boolean del = accountInterface.deleteAccount();
                    if(del){
                        System.out.println("Deleted successful..");
                    }else{
                        System.out.println("Operation failed..");
                    }
                    break;
                case 9:
                    int c = accountInterface.getCount();
                    System.out.println("account count is : " + c);
                default:
                    System.out.println("Only 8 options available. ");
                    break;
            }
        }
        System.out.println("No thanks");
        sc.close();
    }
}