import java.util.Random;
import java.util.Scanner;


public class NumberGame{
    //step-1 : generating a random number from 1-100
    //lets create a fucntion for this
    public static int generateRandom(){
        int rannum;
        Random random = new Random();
        rannum = random.nextInt(100);
        return rannum+1;
            
    }
    //main function section
    public static void main(String[] args){
        //getting user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to number game!");
        System.out.println("Guess a number from 1 - 100.");
        System.out.println("You have 5 attempts per round.");
        System.out.println("If your guessed number is matched with our guessed number than you won the round and scored some points");
        System.out.println("Based on your attempt number you get scores(1st:50points, 2nd:40points, ..,5th:10points)");
        System.out.println("Otherwise You can quit with your current score");
        int choice;
        final int totatt = 5;
        int score = 0;
        int rounds = 0;
        do{ 
            rounds = rounds + 1;
            int attempts = 0;
            System.out.println("Round number:"+rounds);
            //function call
            int x = generateRandom();//target
            boolean won = false;
            do{
                attempts = attempts+1;
                System.out.println("Attempt number:"+attempts);
                if(attempts==totatt){
                    System.out.println("Your last attempt on this round");
                }
                System.out.println("Enter your guessed number:");
                int number = scanner.nextInt();//guessed number
                if (number==x){
                    System.out.println("You won in attempt:"+attempts+"!");
                    switch(attempts){
                        case 1: score = score + 50; break;
                        case 2: score = score + 40; break;
                        case 3: score = score + 30; break;
                        case 4: score = score + 20; break;
                        case 5: score = score + 10; break;
                    }
                    won=true;
                    break;
                }
                else if(number>x)
                    System.out.println("You lose! Your guessed number is Greater.");
                else
                    System.out.println("You lose! Your guessed number is smaller.");

                
            }while(attempts<totatt);
            if (!won){
                System.out.println("You failed to guess the correct number is :"+x);
            }
            System.out.println("Want to go for next round? 0 for yes & 1 for no");
            choice = scanner.nextInt();
            if(choice==1){
                System.out.println("For "+rounds+" you have scored "+score+"points.");
                break;
            }
            
            
        }while(choice == 0);
        System.out.println("Game over! You played "+rounds+" rounds  and scored "+score+"points.");
        scanner.close();
    }
}