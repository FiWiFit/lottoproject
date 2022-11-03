/**
 * 
 */
package uk.ac.qub.lottosimulator;

// Imports
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
 * @author 40168892
 *
 */
public class LottoSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
// Defining placeholder value to populate favourite lotto numbers array
		int favNum = 0;
// Defining favourite lotto numbers array
		int[] favNums = new int[6];
// Defining placeholder value to populate playing numbers array		
		int playNum = 0;
// Defining playing lotto numbers array		
		int[] playNums = new int[6];
// Defining winning lotto numbers array		
		int[] winningNums = new int[6];
// User responses to questions		
		String userConfirmFavs, userConfirmPlayNums, userConfirmDrawNums, playAgain;

// Calling scanners
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner3 = new Scanner(System.in);
		Scanner scanner4 = new Scanner(System.in);
		Scanner scanner5 = new Scanner(System.in);
		Scanner scanner6 = new Scanner(System.in);

		do {
// Prompting user for favourite lottery numbers
			System.out.println("Enter your favourite lotto numbers between 1-59 inclusive."
					+ " Please wait for the prompt to enter each number");

// Do while loop to repeat process in case favourite numbers are incorrect
			do {

// Capturing user entries for favourite numbers
				for (int loop = 0; loop < favNums.length; loop++) {
					System.out.println("Enter your favourite number:");
					favNum = scanner1.nextInt();

					if (favNum >= 1 && favNum <= 59) {
						favNums[loop] = favNum;
						System.out.println("Number accepted.");
					} else {
						System.out.println("Number is out of range, please start again.");
						break;
					}
				}
// Printing user favourite lottery numbers
				System.out.printf("Your favourite lottery numbers are: ");
				for (int favs = 0; favs < favNums.length; favs++) {
					System.out.printf("%d ", favNums[favs]);
				}
// Checking favourite lottery numbers are correct
// Do while loop to repeat question if answer is incompatible 
				do {
					System.out.println("Is this correct? Please enter 'Yes' or 'No'.");
					userConfirmFavs = scanner2.nextLine();

					if (userConfirmFavs.equalsIgnoreCase("Yes")) {
						System.out.println("Great, now lets play!");
					} else if (userConfirmFavs.equalsIgnoreCase("No")) {
						System.out.println("Let's try that again.");
					} else {
						System.out.println("Invalid answer!");
						userConfirmFavs = "undefined";
					}
				} while (userConfirmFavs == "undefined");
			} while (userConfirmFavs.equalsIgnoreCase("no"));

// Confirming with user if they want to use favourite numbers for this draw
// If incompatible response given for if play numbers are correct, ask again from here	
			do {
// If play numbers are incorrect, start from this point			
				do {
					System.out.println("Would you like to use your favourite lotto numbers for this draw?"
							+ " Please enter 'Yes' or 'No'.");
					userConfirmPlayNums = scanner3.nextLine();

					if (userConfirmPlayNums.equalsIgnoreCase("Yes")) {
						System.out.println("Gotcha");
					} else if (userConfirmPlayNums.equalsIgnoreCase("No")) {
						System.out.println("Okay, let's get your new numbers!");
// If they want new numbers, they are recorded here in new play numbers array
						for (int loop = 0; loop < playNums.length; loop++) {
							System.out.println("Enter your choice of number between 1-59 inclusive:");
							playNum = scanner4.nextInt();

							if (playNum >= 1 && playNum <= 59) {
								playNums[loop] = playNum;
								System.out.println("Number accepted.");
							} else {
								System.out.println("Number is out of range, please start again.");
								break;
							}
						}

// Printing new play numbers to screen					
						System.out.println("Your lottery numbers for this draw are: ");
						for (int play = 0; play < playNums.length; play++) {
							System.out.printf("%d ", playNums[play]);
						}

					} else {
						System.out.println("Sorry didn't quite catch that...");
						userConfirmPlayNums = "undefined";
					}
					if (userConfirmPlayNums.equalsIgnoreCase("Yes")) {
						break;
					}
					do {
						System.out.println("Is this correct? Please enter 'Yes' or 'No'.");
						userConfirmDrawNums = scanner5.nextLine();

						if (userConfirmDrawNums.equalsIgnoreCase("Yes")) {
							System.out.println("Great, now lets play!");
						} else if (userConfirmDrawNums.equalsIgnoreCase("No")) {
							System.out.println("Let's try that again.");
						} else {
							System.out.println("Invalid answer!");
							userConfirmDrawNums = "undefined";
						}
					} while (userConfirmDrawNums == "undefined");

				} while (userConfirmDrawNums.equalsIgnoreCase("no"));

			} while (userConfirmPlayNums == "undefined");

// Moving forward with correct play/fav numbers

			System.out.println("Ready to play?");
			System.out.println("The winning numbers are...");
			timeDelay(1000);

// Calling random number generator
			Random rand = new Random();

// Printing random winning lottery numbers and adding to array
			for (int loop = 0; loop < 6; loop++) {
				winningNums[loop] = rand.nextInt(60);
				System.out.printf("%d ", winningNums[loop]);
			}

			if (userConfirmPlayNums.equalsIgnoreCase("Yes")) {
				System.out.println();
				compareArray(favNums, winningNums);
			} else if (userConfirmPlayNums.equalsIgnoreCase("No")) {
				System.out.println();
				compareArray(playNums, winningNums);
			}

			do {
				System.out.println("Would you like to play again? Please answer with 'Yes' or 'No'.");
				playAgain = scanner6.nextLine();

				if (playAgain.equalsIgnoreCase("No")) {
					System.out.println("See you again soon!");
				} else if (playAgain.equalsIgnoreCase("Yes")) {
					System.out.println("Let's go!!!");
				} else {
					System.out.println("I didn't quite catch that. Try again.");
					playAgain = "undefined";
				}
			} while (playAgain == "undefined");
		} while (playAgain.equalsIgnoreCase("Yes"));
		
		
		scanner1.close();
		scanner2.close();
		scanner3.close();
		scanner4.close();
		scanner5.close();
		scanner6.close();
		

	} // end of main method

	// Time delay for user results
	private static void timeDelay(int millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Comparing arrays
	public static void compareArray(int[] arrayOne, int[] arrayTwo) {
		int wins = 0;

		if (Arrays.equals(arrayOne, arrayTwo)) {
			System.out.println("You're a winner! You got all the numbers correct!");
			wins ++;
		} else {
			int matches = 0;

			for (int win = 0; win < arrayOne.length; win++) {
				for (int play = 0; play < arrayTwo.length; play++) {
					if (arrayOne[win] == arrayTwo[play]) {
						matches++;
					}
				}
			}

			System.out.println("You have scored " + matches + " number matches!");
			if (matches == 0) {
				System.out.println("Unlucky!");
			} else if (matches == 1 || matches == 2) {
				System.out.println("Don't give up the day job...");
			} else if (matches == 3 || matches == 4) {
				System.out.println("Not bad!");
			} else if (matches == 5) {
				System.out.println("So close! That's gotta hurt...");
			}
			System.out.println("Sorry, looks like you're not a winner today!");
		}

	}

}