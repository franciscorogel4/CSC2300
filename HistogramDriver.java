import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
//--------------------------------------------------------
//	Francisco Rogel 	Sam Cacela		February 11, 2017
// 	CSC 2300 									Dr. Joyce
//
//	Program that reads the file and creates a histogram based 
//	on the FIRST DIGIT in each of the numbers. 
//--------------------------------------------------------

public class HistogramDriver 
{
	public static int[] arraySortedNumbers = new int[254]; // Length of List is 254 because 255 numbers

	public static void main(String[] args) throws FileNotFoundException 
	{

		Histogram histogram = new Histogram(1,9);

		histogram.submit(6);

		File file = new File("/Users/franciscorogel/Documents/Villanova University/3rd year/Semester 2/CSC Stats for Computing/CSC2300Histogram.txt");
		Scanner scan = new Scanner(file);
		
		for (int i = 0; scan.hasNextLine(); i++) 
		{
			String line = scan.nextLine();
			String charLoc = line.substring(0,1); // Only using the first digit
			int intcharLoc = Integer.parseInt(charLoc); // Changing string to int
			arraySortedNumbers[i] = intcharLoc; // placing numbers into an array

			histogram.submit(Character.getNumericValue(line.charAt(0)));

		}
		scan.close();

		System.out.println(histogram.toString());


		Arrays.sort(arraySortedNumbers); // sorting the array
		histogram(); // Calling the Histogram Method
		System.out.println();
		printArray(); // Printing array 
		
	}
	
	//-------------------------------------------------------------
	//  Method histogram that formats an array of integers into a
	//  histogram
	//-------------------------------------------------------------
	public static void histogram()
	{
		int count = 0;
		int total = 0;
		
		for (int i = 1; i <= 9; i++)
		{
			for(int j=0; j < arraySortedNumbers.length; j++)
			{
				if(arraySortedNumbers[j]==i)
				{
					count++;
				}
			}
			System.out.print("Total: " + count + "	");
			System.out.print(i + ":");

			for(int k = 0; k < count; k++)
			{
				System.out.print("*");
			}

			System.out.print("\n");

			total += count;
			
			count = 0;
			//System.out.println(total);
		}
			System.out.println();
			System.out.println("Total amount of numbers in test case: " + total);

	}
	//-------------------------------------------------------------

	//-------------------------------------------------------------
	//  Method histogram that formats an array of integers into a
	//  scaled histogram
	//-------------------------------------------------------------
	public static void scaledHistogram(int scalar)
	{
		int count = 0;
		int total = 0;

		double numberOfStars = 0;
		
		for (int i = 1; i <= 9; i++)
		{
			for(int j=0; j < arraySortedNumbers.length; j++)
			{
				if(arraySortedNumbers[j]==i)
				{
					count++;
				}
			}
			System.out.print("Total: " + count + "	");
			System.out.print(i + ":");

			numberOfStars = Math.floor((count/scalar));

			for(int k = 0; k < count; k++)
			{
				System.out.print("*");
			}

			System.out.print("\n");
			//System.out.println("Test: " + numberOfStars);
			System.out.println();

			total += count;
			
			count = 0;
		}
			System.out.println();
			System.out.println("Total amount of numbers in test ccase: " + total);

	}
	//-------------------------------------------------------------


	//-------------------------------------------------------------
	// Method printArray to print the array
	//-------------------------------------------------------------
	public static void printArray(){
		for(int j = 1; j <= arraySortedNumbers.length; j++){
			System.out.println("int in array at location " + j + ": " + arraySortedNumbers[j-1]); // j-1 bc we want location 0 not 1
		}
	}
	//-------------------------------------------------------------
}