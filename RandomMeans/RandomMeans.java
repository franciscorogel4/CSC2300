import java.util.Random;
//------------------------------------------------------------
//	Francisco Rogel        						     CSC 2300
//	
//	RandomMeans.java							April 4, 2017
//------------------------------------------------------------
public class RandomMeans 
{
	final static int NUMTRIALS = 10000; //10,000 times 
	static Random rand = new Random();

	public static void main(String[] args) 
	{
		System.out.println("Part 1: ");
		ThreeRandNums(); // Part 1
		System.out.println("Part 2: ");
		TenRandNums();	// Part 2
		System.out.println("Part 3: ");
		WeightedRandNums();	// Part 3
	}

	public static void TenRandNums()
	{
		final int NUMRANDNUMS = 10; // for three random numbers

		Histogram histogram = new Histogram(1,20);

		for(int i = 0; i < NUMTRIALS; i++)
		{
			int total = 0;

			for(int j = 0; j < NUMRANDNUMS; j++)
				total += rand.nextInt(20) + 1;

			double average = ((total)/NUMRANDNUMS);

			histogram.submit((int)average);
		}

		System.out.println(histogram.toString());
	}
	
	public static void ThreeRandNums()
	{
		final int NUMRANDNUMS = 3; // for three random numbers

		Histogram histogram = new Histogram(1,20);

		for(int i = 0; i < NUMTRIALS; i++)
		{
			int total = 0;

			for(int j = 0; j < NUMRANDNUMS; j++)
				total += rand.nextInt(20) + 1;

			double average = ((total)/NUMRANDNUMS);

			histogram.submit((int)average);
		}

		System.out.println(histogram.toString());
	}

	public static void WeightedRandNums()
	{
		Histogram histogram = new Histogram(1,20);

		final int NUMRANDNUMS = 10;
		
		for(int i = 0; i <NUMTRIALS; i++)
		{			
			int num15 = 0; int num1120 = 0; int total = 0;
			
			for(int j = 0; j<NUMRANDNUMS; j++)
			{
				int num = rand.nextInt(2);

				if (num == 0){
					num15 = rand.nextInt(10) + 11;
					total += num15;
				}
				else{
					num1120 = rand.nextInt(5) + 1;
					total += num1120;
				}
			}
			
			double average = ((total)/NUMRANDNUMS);
			histogram.submit((int)average);
		}
		System.out.println(histogram.toString());
	}
}





