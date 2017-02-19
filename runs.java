import java.text.DecimalFormat;

public class runs {

	public static void main(String[] args) 
	{
		longestRunOfHeadsorTails(8);	// 8 different N values for coin flips 
										// N values: N = 1, 10, 100, 1000, 10000, 
										// 100000, 1000000, 10000000
	}

	//------------------------------------------------------------------
	//	longestRunOfHeadsorTails(n): Method that flips a coin n times 
	//	and puts the data into an array, then calls another method to 
	//  retrieve the longest run or heads or tails. 
	//------------------------------------------------------------------
	private static void longestRunOfHeadsorTails (int trials)
	{		
		DecimalFormat decimalFormat = new DecimalFormat("0.00000"); // Specific Format

		MultiDie Die1 = new MultiDie(2); // Represents 

		final int numberOfRolls = 1;
		int countHeads = 0;
		int countTails = 0;
		final int sideHeads = 1;
		final int sideTails = 2;
		int numTrials = 1;
		int run = 0;

		String roll = "roll"; 
		String rolls = "rolls";

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
					countTails++; // if heads 
					coinArray[i] = sideTails;
				}

			}

			if (numTrials == 1) 
				rolls = rolls;
			else 
				roll = rolls; // adding a s for more than 1 roll

			System.out.println("After " + numTrials + " " + roll + " the longest run of heads or tails was: " + run(coinArray));


			countTails = 0;
			countHeads = 0;
			numTrials = numTrials * 10;
		}
	}
	
	//----------------------------------------------------
	// run() Method that takes in an array and returns the 
	// longest run of the same coin side
	//----------------------------------------------------
	private static int run(int[] array)
	{
		int count = 1; 
		int max = 1;

		for (int i = 1; i < array.length; i++) 
		{
			if (array[i] == array[i - 1]) 
				count++;
			else 
			{
				if (count > max) 
				{
					max = count;
				}
				count = 1;
			}
		}

		if (count> max)
			return count;
		else
			return max;  
	}
	//----------------------------------------------------
}


