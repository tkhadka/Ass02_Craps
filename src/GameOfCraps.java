// Pseudocode:
// 1. Generate two random numbers for the dice rolls.
// 2. Calculate the sum of the dice.
// 3. Check the sum against the game rules:
//    a. If the sum is 2, 3, or 12, display "craps" message and game over with a loss.
//    b. If the sum is 7 or 11, display "natural" message and game over with a win.
//    c. Otherwise, the sum becomes "the point", and the player continues to roll until they either:
//       i. Roll a 7 and lose.
//       ii. Roll the point again and win.
// 4. Prompt the user to play again after each game ends.
// 5. Repeat the process if the user chooses to play again.

import java.util.Random;
import java.util.Scanner;

public class GameOfCraps {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        Random randomNumberGenerator = new Random();
        boolean continuePlaying = true;

        while (continuePlaying) {
            int dieOne = randomNumberGenerator.nextInt(6) + 1;
            int dieTwo = randomNumberGenerator.nextInt(6) + 1;
            int rollSum = dieOne + dieTwo;

            System.out.println("Rolled: " + dieOne + " + " + dieTwo + " = " + rollSum);

            switch (rollSum) {
                case 2:
                case 3:
                case 12:
                    System.out.println("Craps! You lost.");
                    break;
                case 7:
                case 11:
                    System.out.println("Natural! You won.");
                    break;
                default:
                    System.out.println("The point is now " + rollSum + ".");
                    int point = rollSum;
                    boolean pointAchieved = false;

                    while (true) {
                        dieOne = randomNumberGenerator.nextInt(6) + 1;
                        dieTwo = randomNumberGenerator.nextInt(6) + 1;
                        rollSum = dieOne + dieTwo;

                        System.out.println("Rolled: " + dieOne + " + " + dieTwo + " = " + rollSum);

                        if (rollSum == point) {
                            System.out.println("Made point and won!");
                            pointAchieved = true;
                            break;
                        } else if (rollSum == 7) {
                            System.out.println("Got a seven and lost.");
                            break;
                        } else {
                            System.out.println("Trying for point...");
                        }
                    }

                    if (pointAchieved) break;
            }

            System.out.print("Play again? (yes/no): ");
            String userResponse = userInputScanner.next();
            continuePlaying = userResponse.equalsIgnoreCase("yes");
        }

        userInputScanner.close();
        System.out.println("Game over. Thanks for playing!");
    }
}
