import java.util.Scanner;
//separate class for atm operations
class ATM_MACHINE{
    public static int deposit(int bal,int amount){
        int f_bal;
        f_bal = bal + amount;
        return f_bal;
    } 
    public static int withdraw(int bal,int amount){
        int f_bal = bal - amount;
        return f_bal;
    }
    public static int bal_check(int bal){
        int f_bal = bal;
        return f_bal;
    }
}
//ATM's User Interface for verification and the processes after verification
class Users_Interface extends ATM_MACHINE{
    int[] bal,pin_nos,acc_nos,card_nos;
    String[] users;
    Scanner scanner = new Scanner(System.in);
    int con;


    public int user_validation(int card_no){
        for (int i=0; i<card_nos.length; i++){
            if(card_no==card_nos[i]){
                System.out.println("Your Name:"+users[i]);
                System.out.println("Your Account number:"+acc_nos[i]);
                operations(i);
                return 1;
            }
        }
      System.out.println("Invalid Card Number!");
      return 0;
    }


    public boolean pin_authenticator(int pos){
        System.out.println("Enter Your PIN number:");
        int pin = scanner.nextInt();
        if (pin==pin_nos[pos]){
            System.out.println("PIN verification Successfull");
            return true;
        }
        return false;
    }

    public void operations(int pos){
        do{
        System.out.println("--------MENU-----------\n 1.Deposit\n2.Withdraw\n3.Check-Balance\nEnter your choice number:");
        int choice = scanner.nextInt();
        int amount = 0;
        switch(choice){
            case 1: 
                    System.out.println("Enter the amount you want to Deposit:");
                    amount = scanner.nextInt();
                    boolean x=pin_authenticator(pos);
                    if(x){
                        int f_bal=deposit(bal[pos], amount);
                        bal[pos] = f_bal;
                        System.out.println("Amount was deposited successfully!");
                        amount = 0;
                        break;
                    }
                    break;
            case 2:
                    System.out.println("Enter the amount you want to WithDraw:");
                    amount = scanner.nextInt();
                    x=pin_authenticator(pos);
                        if(x){
                            if (amount>bal[pos]){
                            System.out.println("Your balance is low for performing withdraw for the amount you enter!\nPlease check your balance and with draw again");
                            break;
                            }
                            else{
                                int f_bal1 = withdraw(bal[pos], amount);
                                bal[pos] = f_bal1;
                                System.out.println("Amount was with drawn successfully!");
                                break;
                            }   
                        }
                    else{
                        break;
                    }

            case 3:
                    System.out.println("Your account's balance is: Rs."+bal[pos]);
                    break;
            default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");

        }
        System.out.println("Do you want to continue? 0 for continue & 1 for exit.");
        con = scanner.nextInt();
    }while(con==0);
    return;
    }
}
//main class
public class ATM_INTF {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------WELCOME TO ATM----------------");
        Users_Interface ATM =  new Users_Interface();
        int choice;
        do{
            System.out.println("Enter you card number:");
            int card_no = scanner.nextInt();
            int a = ATM.user_validation(card_no);
            if(a==0){
                System.out.println("Your card number is invalid.\n Enter the correct card number.\nIf you dont have either an account or a card please visit the bank");
            }
            System.out.println("Enter 0 to proceed next transaction or 1 to exit.");
            choice = scanner.nextInt();
        }while(choice==0);
        scanner.close();
    }
}
