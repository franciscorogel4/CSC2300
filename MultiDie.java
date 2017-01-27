import java.util.Random;
import java.text.DecimalFormat;

public class MultiDie
{
	private final int MAX;   
	private int faceValue;

	private Random rand = new Random();

	public MultiDie()
	{
		MAX = 6;
		faceValue = 1;
	}

	public MultiDie(int numSides)
	{
		MAX = numSides;
		faceValue = 1;
	}

	public String toString()
	{
		String result;
		result = "Face value: " + faceValue;
		result = result + "  Number of sides: " + MAX;

		return result;
	}

	public void roll()
	{
		faceValue = rand.nextInt(MAX) + 1;
	}

	public int getFaceValue()
	{
		return faceValue;
	}

	public void setFaceValue(int value)
	{
		faceValue = value;
	}

	public static void main(String[] args) 
	{
		coinFlips(8); // 8 different N values for coin flips 
		// N values: N = 1, 10, 100, 1000, 10000, 
		// 100000, 1000000, 10000000
	}

	private static void coinFlips (int trials) 
	{
		DecimalFormat decimalFormat = new DecimalFormat("0.00000"); // Specific Format

		MultiDie Die1 = new MultiDie(2); // Represents 

		final int numberOfRolls = 1;
		int countHeads = 0;
		int countTails = 0;
		final int sideHeads = 1;
		int numTrials = 1;

		String roll = "roll"; 
		String rolls = "rolls";

		for (int j = 1; j <= trials; j++ )
		{
			for(int i = 0; i < numberOfRolls*numTrials; i++)
			{
				Die1.roll();
				if (Die1.getFaceValue() == sideHeads)
					countHeads++;
				else
					countTails++; // if heads 
			}
			if (numTrials == 1) 
				rolls = rolls;
			else 
				roll = rolls; // adding a s for more than 1 roll

			System.out.println("Ratio of times Heads appears in " + numTrials + " " + roll + ": " + decimalFormat.format((double)countHeads/numTrials));	
			System.out.println();

			countTails = 0;
			countHeads = 0;
			numTrials = numTrials * 10;
		}
	}
}