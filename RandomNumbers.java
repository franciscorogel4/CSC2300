import java.text.DecimalFormat;
import java.util.Random;

public class RandomNumbers 
{

	final static int sizeOfArray = 100;	//Size of the array 
	final static int range = 100;	// Range of Numbers
	final public static int[] arrayOfRandomNumbers = new int[sizeOfArray];	// Creating an array with a declared size
	final static Random rand = new Random();


	// Making the Array 
	private static void MakeRandomArray ()
	{
		for (int i = 0; i < arrayOfRandomNumbers.length; i++)
		{
			int number = rand.nextInt(range) + 1;
			arrayOfRandomNumbers[i] = number;
		}
	}
	public static void main(String[] args) 
	{
		MakeRandomArray(); // Creating the arry of random numbers
		//PrintArray(arrayOfRandomNumbers); // Printing array for testing
		
		DecimalFormat decimalFormat = new DecimalFormat("##.#"); // Specific Format

		System.out.println("Generated 100 numbers between 1 and 100.");

		System.out.println();
		System.out.println("Min:     " + MinInt(arrayOfRandomNumbers));
		System.out.println("Max:     " + MaxInt(arrayOfRandomNumbers));
		System.out.println("Mean:    " + decimalFormat.format(MeanInt(arrayOfRandomNumbers)));
		System.out.println("Std dev: " + decimalFormat.format(StandardDeviation(arrayOfRandomNumbers)));	
		
	}

	//-------------------------------------------------------------
	//Method to find the Min
	//-------------------------------------------------------------
	private static int MinInt(int[] array)
	{
		int LeastInt = 0;

		LeastInt = arrayOfRandomNumbers[0];

		for (int i = 0; i < arrayOfRandomNumbers.length; i++)
		{
			if(arrayOfRandomNumbers[i] < LeastInt)
			{
				LeastInt = arrayOfRandomNumbers[i];
			}
		}

		return LeastInt;
	}
	//-------------------------------------------------------------


	//-------------------------------------------------------------
	//Method to find the Max
	//-------------------------------------------------------------
	private static int MaxInt(int[] array)
	{
		int maxInt = 0;

		for(int i = 0; i < arrayOfRandomNumbers.length; i++)
		{
			if (arrayOfRandomNumbers[i] > maxInt)
			{
				maxInt = arrayOfRandomNumbers[i];
			}
		}
		return maxInt;
	}
	//-------------------------------------------------------------


	//-------------------------------------------------------------
	// Method for finding the Mean/Average
	//-------------------------------------------------------------

	private static double MeanInt(int[] array)
	{
		double meanInt = 0;

		for (int i = 0; i < arrayOfRandomNumbers.length; i++)
		{
			meanInt = meanInt + arrayOfRandomNumbers[i];
		}

		double finalAverage = 0;

		finalAverage = (meanInt/sizeOfArray);

		return finalAverage;
	}
	//-------------------------------------------------------------


	//-------------------------------------------------------------
	// Method for finding the Standard Deviation
	//-------------------------------------------------------------
	private static double StandardDeviation(int[] array)
	{
		double mean = MeanInt(arrayOfRandomNumbers);
		double newInt = 0;

		for(int i = 0; i < array.length; i++)
		{
			newInt  += ((array[i] - mean) *  (array[i] - mean));
		}

		double squareRoot = Math.sqrt((newInt/(sizeOfArray-1))); // size-1 (n-1) to account for Bessel's correction for sample
		return squareRoot;										 // Simply remove the -1 if we are using the whole 
																 // population and not a sample
	}
	//-------------------------------------------------------------


	//-------------------------------------------------------------
	// Printing the array (For testing purposes)...
	// This made it easier when copying the array into an online 
	// calculator to test the program 
	//-------------------------------------------------------------
	private static void PrintArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i]+ ","); // Calculators asked for 
		}									 // comma separation
	}
	//-------------------------------------------------------------
}
