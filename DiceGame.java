import java.util.Scanner;

/**
 * The DiceGame program generates a random number between 1 and 6
 * and asks the user to guess that number.
 *
 * @author Layla Michel
 * @version 1.0
 * @since 2022-02-28
 */

final class DiceGame {
    /**
    * Create a constant for min of range.
    */
    public static final int MIN = 1;
    /**
    * Create a constant for max of range.
    */
    public static final int MAX = 6;

    /**
    * Creating private constructor due to
    * public/default constructor error.
    *
    * @throws IllegalStateException if there is an issue
    */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    */
    public static void main(String[] args) {
        final Scanner myObj = new Scanner(System.in);
        // Initialize guess to 1
        int guesses = 1;
        // generate random number between min and max
        final int randomInt = (int) Math.floor(Math.random()
            * (MAX - MIN + 1) + MIN);

        outerloop: {
            while (true) {
                // Ask user for guess
                System.out.print("Guess an integer from 1 to 6: ");
                final String userString = myObj.nextLine();

                try {
                    // Check if guess is an integer
                    final int userInt = Integer.parseInt(userString);

                    // Check if guess is within range
                    if (userInt > MAX || userInt < MIN) {
                        // Error message if guess isn't within range
                        System.out.println("Must be between 1 and 6,"
                            + " try again.");
                    } else {
                        while (true) {
                            // Check if guess is the same
                            // as the generated number
                            if (userInt == randomInt) {
                                if (guesses == 1) {
                                    // Congratulation message if
                                    // user guessed only once
                                    System.out.println("You guessed correctly!"
                                        + " It took you " + guesses + " try!");
                                    break outerloop;
                                } else {
                                    // Congratulation message if
                                    // user guessed more than once
                                    System.out.println("You guessed correctly"
                                        + "! It took you " + guesses
                                        + " tries!");
                                    break outerloop;
                                }
                            } else if (userInt < randomInt) {
                                // Outputted message if guess is
                                // lower than generated number
                                System.out.println("The number is higher.");
                                // Increase guess value by 1
                                guesses++;
                                break;
                            } else {
                                // Outputted message if guess is higher
                                // than generated number
                                System.out.println("The number is lower.");
                                // Increase guess value by 1
                                guesses++;
                                break;
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    // Error message if guess isn't an integer
                    System.out.print("Please enter a valid integer.\n");
                }
            }
        }
        myObj.close();
    }
}
