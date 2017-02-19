//----------------------------------------------------
// Francisco Rogel		CSC 2300		2/1/2017
// 
//						longestRun.java
//
// Program Description: Program that “flips a coin” N times 
// and prints out the length of the longest "run" of
// heads or tails. For example, HHTTTTHHTH returns 4
//----------------------------------------------------

public class longestRun 
{
	public static void main(String[] args) 
	{
		coinFlipToArray(8); // 8 different N values for coin flips 
		// N values: N = 1, 10, 100, 1000, 10000, 
		// 100000, 1000000, 10000000
	}

	//----------------------------------------------------
	// run() Method that takes in an array and returns the 
	// longest run of the same coin side
	//----------------------------------------------------
	private static void coinFlipToArray (int trials) 
	{		
		MultiDie Die1 = new MultiDie(2); // Represents 

		final int numberOfRolls = 1;
		final int sideHeads = 1, sideTails = 2;

		int countHeads = 0, countTails = 0;
		int numTrials = 1;
		int run = 0;

		String roll = "roll", rolls = "rolls";

		for (int j = 1; j <= trials; j++ )
		{
			int[] coinArray = new int[numTrials];

			for(int i = 0; i < numberOfRolls*numTrials; i++)
			{
				Die1.roll();
				if (Die1.getFaceValue() == sideHeads){
					countHeads++;
					coinArray[i] = sideHeads;
				}
				else{
					countTails++; 
					coinArray[i] = sideTails;
				}

			}
			if (numTrials == 1) 
				rolls = rolls;
			else 
				roll = rolls; // adding a s for more than 1 roll

			System.out.println("After " + numTrials + " " + roll + 
					" the longest run of heads or tails was: " + 
					coinLongestRun(coinArray));

			countTails = 0;
			countHeads = 0;
			numTrials = numTrials * 10;
		}
	}
	//----------------------------------------------------

	//----------------------------------------------------
	// run() Method that takes in an array and returns the 
	// longest run of the same coin side
	//----------------------------------------------------
	private static int coinLongestRun(int[] array)
	{
		int longestCurrentRun = 1; 
		int LongestRunCanidate = 1;

		for (int i = 1; i < array.length; i++) 
		{
			if (array[i] == array[i - 1]) 
				longestCurrentRun++;
			else 
			{
				if (longestCurrentRun > LongestRunCanidate) 
				{
					LongestRunCanidate = longestCurrentRun;
				}
				longestCurrentRun = 1; //
			}
		}

		if (longestCurrentRun> LongestRunCanidate) // final consecutive run 
			return longestCurrentRun;			   // compared to longest
		else									   // run candidate						
			return LongestRunCanidate;
	}
	//----------------------------------------------------
}
