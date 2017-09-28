import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

class MovieList
{	
	//30 slots for default data; 5 extra for insertable data
	Movie[] list = new Movie[35];
	
	int[] temp4Random = new int[150];
	int[] temp4Title = new int[31];
	int[] temp4Year = new int[100];
	int[] temp4Time= new int[145];
	
	String[] genreOptions = {"comedy", "drama", "sci-fi", "documentary", "action"};
	Random rnd = new Random();
	
	public MovieList()
	{	
		for(int i=0;i < list.length - 5;i++)
		{
			list[i] = new Movie(rndTitleMaker(),rndYearMaker(1920,2017),rndTime(),rnd.nextDouble()*9 + rnd.nextDouble(),rndGenre());
		}
		
		for(int j = 30; j < list.length; j++)
		{
			list[j] = new Movie();
		}
	}
	
	public int rndTime()		// Generate a random Time
	{
		int gen = rnd.nextInt(140) + 1;		// Generate initial random int 1-140
		int total = 0;						// Counter to reset counting array
				
		while((temp4Time[gen] > 0) == true)	// Keep generating a new random until a unique int shows up
		{
			gen = rnd.nextInt(140) + 1;
		}
		for(int i = 0; i < temp4Time.length; i++)	// Loop to check if counting array should be reset
		{
			total += temp4Time[i];
			if(total != 30)
				continue;
			Arrays.fill(temp4Time,0);		// Return counting array to all 0s
		}
		
		temp4Time[gen]++;					// Increment counting array at index matching random int
		
		return 59 + gen;					// Return unique int in range 60-200
	}
	
	public String rndGenre()		// Generate a random Genre
	{
		int gen = rnd.nextInt(5);		// Generate random int in range 0-4
		int total = 0;				// Counter to reset counting array
				
		while((temp4Random[gen] > 9) == true)		// Keep generating a new random after 9 of same value have been created
		{
			gen = rnd.nextInt(5);
		}
		for(int i=0;i<temp4Random.length;i++)		// Loop to check if counting array should be reset
		{
			total += temp4Random[i];
			if(total != 30)					// If 30 values have been created, reset
				continue;
			Arrays.fill(temp4Random,0);		// Return counting array to all 0s
		}
		
		temp4Random[gen]++;			// Increment counting array at index matching random int
		
		return genreOptions[gen];		// Return String genre
	}
	
	public int rndYearMaker(int earliest, int latest)		// Generates a random Year
	{
		int Y = rnd.nextInt(latest - earliest) + 1;			// Generate random int in range 1-(difference of latest and earliest)
		int total = 0;
		
		while((temp4Year[Y] > 0) == true)					// Keep generating a new random until unique int appears
		{
			Y = rnd.nextInt(latest - earliest) + 1;
		}
		for(int i=0;i<temp4Year.length;i++)			// Loop to check if counting array should be reset
		{
			total += temp4Year[i];
			if(total != 30)
				continue;
			Arrays.fill(temp4Year,0);				// Return counting array to all 0s
		}
		
		temp4Year[Y]++;				// Increment counting array at index matching random int
		
		return earliest + Y;		// Return int in range of earliest - earliest plus random int generated from difference
	}
	
	public String rndTitleMaker()		//Generates a random movie Title
	{
		int x = rnd.nextInt(30) + 1;		// Generate random int suffix for movie title
		int total = 0;
		
		while((temp4Title[x] > 0) == true)
		{
			x = rnd.nextInt(30) + 1;
		}
		for(int i=0;i<temp4Title.length;i++)
		{
			total += temp4Title[i];
			if(total != 29)
				continue;
			Arrays.fill(temp4Title,0);
		}
		
		temp4Title[x]++;		// Increment counting array
		return "Movie" + x;			// Return String title with random suffix attached
	}
	
	public void sortMovieYear()		// Go through the array and sort based on year (oldest first)
	{
		for(int i=1; i < this.list.length; i++) 
		{
			Movie temp = new Movie();		// Temp movie object to store data during swap

			if(!(this.list[i-1].year == -1))		// Check if object at index is fully equipped movie
			{	
				if(this.list[i-1].year > this.list[i].year)		// Check if swap in list should occur
				{
					temp = this.list[i-1];						// Store larger number in temp
					this.list[i-1] = this.list[i];				// Move smaller number into lower index
					this.list[i] = temp;						// Move temp into larger index
				}
			}
		}
		for(int i=1; i < this.list.length; i++)		// Check to see if Movie[] is fully sorted by year
		{
			if(!(this.list[i-1].year == -1))		// Don't check non-fully equipped movie objects
			{	
				if(this.list[i-1].year > this.list[i].year)		// If still not fully sorted, call sort method again
				{
					sortMovieYear();
				}
			}
		}
		
    }
	
	public void sortMovieTime()		// Go through the array and sort based on time (shortest first)
	{
		for(int i=1; i < this.list.length; i++) 
		{
			Movie temp = new Movie();		// Temp movie object to store data during swap

			if(!(this.list[i-1].runningTime == -1))		// Check if object at index is fully equipped movie
			{	
				if(this.list[i-1].runningTime > this.list[i].runningTime)
				{
					temp = this.list[i-1];
					this.list[i-1] = this.list[i];
					this.list[i] = temp;
				}
			}
		}
		for(int i=1; i < this.list.length; i++)		// Check to see if Movie[] is fully sorted by time
		{
			if(!(this.list[i-1].runningTime == -1))		// Don't check non-fully equipped movie objects
			{	
				if(this.list[i-1].runningTime > this.list[i].runningTime)		// If still not fully sorted, call sort method again
				{
					sortMovieTime();
				}
			}
		}
    }
	
	public void sortMovieRating()		// Go through the array and sort based on rating (highest first)
	{
		for(int i=1; i < this.list.length; i++) 
		{
			Movie temp = new Movie();

			if(this.list[i-1].rating == -1.0)
				continue;
			
			if(this.list[i].rating > this.list[i-1].rating)
			{
				temp = this.list[i-1];
				this.list[i-1] = this.list[i];
				this.list[i] = temp;
			}
		}
		for(int i=1; i < this.list.length; i++) 
		{
			if(this.list[i-1].rating == -1.0)
				continue;
			
			if(this.list[i].rating > this.list[i-1].rating)
			{
				sortMovieRating();
			}
		}
    }
	
	public int[] genreMatcher(String x)		// Return an array of index values that match the location of movies with desired genre
	{
		int[] matches = new int[10];		// Store index of Movie object that matches desired genre
		int count = 0;		// Index for storing array
		
		for(int i=0; i < this.list.length; i++)		// Loop through array
		{
			if(x.equals(this.list[i].genre))		// Check if genre matches search
			{
				matches[count] = i;		// Store index of match in storing array
				count++;		// Store index of next match in next array slot
			}
		}
		return matches;		// Return array of indexes of Movie objects that match search
	}
	
	//Display list of all movies (must have a Title)
	public void display()
	{
		System.out.println("\n          TITLE               GENRE               YEAR   TIME(min.)  RATING");
		int count = 1;
		
		for(int i=0;i<this.list.length;i++)
		{
			if(!(this.list[i].name.equals("a")))
			{
				System.out.println(count + Movie.diff(count) + "" + this.list[i]);
				count++;
			}
		}
	}
	
	public void displayGenreList()		// Find and display movies matching a genre
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\nEnter a genre: ");
		String user = keyboard.next();
		int[] temp = genreMatcher(user);		// Returns an array with indexes of matching movies
		int loc;
		boolean matched = true;
		
		System.out.println("\n\nList of " + user + " films: ");
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i] != 0)
			{
				loc = temp[i];
				System.out.println(this.list[loc]);
				matched = false;
			}
			
			if((i == temp.length - 1) && matched)
				System.out.println("NO MOVIES MATCH DEFINED GENRE - CHECK SPELLING(all lowercase)");
		}
	}
	
	
	public void add()
	{
		Scanner keyboard = new Scanner(System.in);
		
		for(int i = 0; i < this.list.length; i++)
		{
			if((i == 34) && !(this.list[i].year == -1))
			{
				System.out.println("ERROR - NOT ENOUGH MEMORY\n");
				break;
			}
			
			if(this.list[i].year == -1)
			{
				System.out.println("Enter a name for the new movie: ");
				String temporary = keyboard.next();
				if(temporary.length() < 20)
					this.list[i].name = temporary;
				else
				{
					System.out.println("NAME IS TOO LONG - TRY AGAIN\n");
					this.add();
				}
				System.out.println("Enter a year: ");
				if(keyboard.hasNextInt())
				{
					int temp = keyboard.nextInt();
					if(temp > 1920 && temp < 2018)
						this.list[i].year = temp;
					else
					{
						System.out.println("INPUT OUT OF RANGE (1920-2017)\n");
						this.add();
					}
				}
				else
				{
					System.out.println("ERROR - PLEASE INPUT A NUMBER FOR THE YEAR\n");
					keyboard.next();
					this.add();
				}
				System.out.println("Enter length of the movie: ");
				if(keyboard.hasNextInt())
				{
					int temp = keyboard.nextInt();
					if(temp > 60 && temp < 201)
						this.list[i].runningTime = temp;
					else
					{
						System.out.println("ERROR - TIME OUT OF RANGE (60-200)\n");
						this.add();
					}
				}
				else
				{
					System.out.println("ERROR - PLEASE INPUT A NUMBER FOR THE TIME\n");
					keyboard.next();
					this.add();
				}
				System.out.println("Enter movie genre: ");
				temporary = keyboard.next();
				for(int j = 0; j < this.genreOptions.length; j++)
				{
					if(temporary.equals(this.genreOptions[j]))
						this.list[i].genre = temporary;
					if((j == this.genreOptions.length - 1) && !(temporary.equals(this.genreOptions[j])))
					{
						System.out.println("NOT A VALID GENRE - OPTIONS: comedy, action, sci-fi, documentary, drama");
						this.add();
					}	
				}
				System.out.println("Enter a movie rating: ");
				if(keyboard.hasNextDouble())
				{
					double tempD = keyboard.nextDouble();
					if(tempD < 0.1 || tempD > 10.0)
					{
						System.out.println("RATING IS OUT OF RANGE (0.1-10.0) - TRY AGAIN");
						this.add();
					}
					else
						this.list[i].rating = tempD;
					
					System.out.println(list[i] + "\n\n Is this correct? (y/n): ");
					String correct = keyboard.next();
					if(correct.equals("y"))
						break;
					else
					{
						this.list[i].year = -1;
						add();
					}
				}
				else
				{
					System.out.println("ERROR - PLEASE INPUT A NUMBER OF TYPE DOUBLE FOR THE RATING\n");
					keyboard.next();
					this.add();
				}
			}
		}
		return;
	}
	
	public int search(String x)
	{
		int index = -1;
		for(int i = 0; i < this.list.length; i++)
		{
			if(x.equals(this.list[i].name))
				index = i;
		}
		return index;
	}
	
	public void findMovie()		// Search for a Movie by name
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\nEnter a name to search for: ");
		String user = keyboard.next();
		int index = search(user);
		if(index != -1)
		{
			System.out.println("\nMovie found: ");
			System.out.println("\n\t" + this.list[index]);
			return;
		}
		System.out.println("Title not found - Try again");
	}
}