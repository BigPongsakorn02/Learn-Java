import java.util.Scanner;
import java.util.Random;

public class MainApp {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            Random random = new Random();
            
            boolean playAgain = true;
    
            while (playAgain) {
                int number = random.nextInt(100) + 1; // Random number (1-100)
                int guessCount = 0, maxCount = 5;
                boolean guessed = false;
    
                System.out.println("Guess the number (1-100)! You have " + maxCount + " tries.");
    
                while (guessCount < maxCount) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    guessCount++;
    
                    if (guess == number) {
                        System.out.println("Correct! You win!");
                        guessed = true;
                        break;
                    } else {
                        System.out.println("Wrong! " + (guess < number ? "Too low." : "Too high."));
                    }
                }
    
                if (!guessed) {
                    System.out.println("You lose! The correct number was " + number);
                }
    
                System.out.print("Play again? (yes/no): ");
                playAgain = scanner.next().equalsIgnoreCase("yes");
            }
    
            System.out.println("Thanks for playing!");
            scanner.close();
        }
}
    

