import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class NetflixEmulator
{
	public static void main(String[] args)
	{
	 	System.out.println("\n\t\t***** Welcome to Netflix Emulator v1.0 *****");
		initialize();
		System.out.println("Thank you for using Netflix Emulator :)");
	}
	
	public static void initialize()	// Creates Initial database; runs menu for user
	{
		MovieList test = new MovieList();				// Original dataset of movies
		Scanner keyboard = new Scanner(System.in);		// Read in user choice for menu options
		boolean value = true;							// Keep loop running until user quits
		
		while(value)
		{
			System.out.println("\n\n\t1.List of movies\n\t2.List of movies by year\n\t3.List of movies by time\n\t4.List of movies by rating\n\t5.Find movies by genre\n\t6.Find movie by name\n\t7.Add a movie\n\t8.Exit");
			System.out.println("\nPlease select an option (Enter 1-8): ");
			int input = keyboard.nextInt();
		
			switch(input)
			{
				case 1:		// Print out list of movies (No sorting done)
					System.out.println("\n\nHere is a list of movies to satisfy your entertainment needs: ");
					test.display();
					break;
					
				case 2:		// Print out movies by year (oldest first)
					System.out.println("\n\nList of movies by year: ");
					test.sortMovieYear();
					test.display();
					break;
				
				case 3:		// Print out list of movies by time (shortest first)
					System.out.println("\n\nList of movies by time: ");
					test.sortMovieTime();
					test.display();
					break;
				
				case 4:		// Print out list of movies by rating (highest first)
					System.out.println("\n\nList of movies by rating: ");
					test.sortMovieRating();
					test.display();
					break;
				
				case 5:		// Print out list of movies matching a genre
					test.displayGenreList();
					break;
				
				case 6:		// Search for a movie by name
					test.findMovie();
					break;
				
				case 7:		// Add a movie
					test.add();
					break;
					
				case 8:		// End the program
					value = false;
					break;
					
				default:	// In case user inputs something other than 1-8
					System.out.println("Input not recognized - Try again");
					break;
			}
		}
		
		return;
	}
}