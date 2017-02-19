//------------------------------------------------------------------
// Francisco Rogel	    CSC2300       field.java 	February 19,2017
//
// Program: That simulates betting $10 on the Field of 
// a craps table, over and over 1,000,000 times. 
// Output: How much money is won or lost, and the average 
// amount of money won/lost per roll.
//------------------------------------------------------------------
public class field 
{
	public static void main(String[] args)
	{		
		final int totalRolls = 1000000;
		double averageMoneyWon = ((double)gameOfCraps(totalRolls)/(double)totalRolls);

		System.out.println();
		System.out.println("Net money won: " + gameOfCraps(totalRolls));
		System.out.println("Average amount of money won: " + averageMoneyWon);
	}	

	//----------------------------------------------------------------
	// twoDiceRolledValue(): Method that rolls two separate dice and 
	// returns the sum.
	//----------------------------------------------------------------
	private static int twoDiceRollValue()
	{
		MultiDie Die1 = new MultiDie(6); 
		MultiDie Die2 = new MultiDie(6); 

		Die1.roll(); 		Die2.roll();

		int totalValue = (Die1.getFaceValue() + Die2.getFaceValue());

		return totalValue;
	}
	//----------------------------------------------------------------

	//----------------------------------------------------------------
	// gameOfCraps(x): Method that returns the total money won after 
	// playing a game of craps x times with a bet of $10.00 each roll
	//----------------------------------------------------------------
	private static int gameOfCraps(int totalRolls)
	{
		int totalMoneyWon = 10;

		for(int i = 0; i <= totalRolls; i++)
		{			
			int totalOfATwoDiceRoll = twoDiceRollValue();

			switch(totalOfATwoDiceRoll)
			{
			case (3):
			case (4):
			case (9):
			case (10):
			case (11):
				totalMoneyWon += 10; // Roll: 3,4,9,10,11
			break;
			case  (2):
			case (12):
				totalMoneyWon += 20; // Roll: 2 or 12
			break;

			case (5):
			case (6):
			case (7):
			case (8):
				totalMoneyWon -= 10; // Roll: 5,6,7,8
			break;
			}
		}
		return totalMoneyWon;
	}
	//----------------------------------------------------------------
}
