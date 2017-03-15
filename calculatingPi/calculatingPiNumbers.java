import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class calculatingPiNumbers 
{
	static int TOTALPOINTS = 1000;
	final static int RADIUS = 300;

	public static void main(String[] args) throws FileNotFoundException
	{		
		double[] array = new double[TOTALPOINTS]; 

		File file = new File("/Users/franciscorogel/Documents/CSC2300/bin/coordinates.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; scan.hasNextLine(); i++) 
		{
			String line = scan.nextLine();
			double number = Double.parseDouble(line); // Changing string to int

			array[i] = number;
		}

		Arrays.sort(array);
		printPoints(array);

		System.out.println();
		System.out.println("Estimation of pi using the monte Carlo method (Nothing to do with the applet)");
		monteCarloPi(10000); // Number of points to generate
	}

	private static void printPoints(double[] array)
	{
		double numIn = 0;
		double numOut = 0;
		int count = 0;

		DecimalFormat numberFormat = new DecimalFormat("###.##"); // Specific Format

		System.out.println("Listing number of points IN the bullseye: \n");

		for(int i = 0; i < array.length; i++)
		{	
			if (array[i] <= RADIUS){
				System.out.println((i+1) + ": " + numberFormat.format(array[i]));
				numIn++;
			}
			
			else
			{  //radius out side the bulseye
				count++;
				
				if (count == 1){
					System.out.println("\nListing number of points NOT the bullseye: \n");
				}
				
				System.out.println((i+1) + ": " + numberFormat.format(array[i]));
				count++; // Making sure Line does not get printed more than once
				numOut++;
			}
		}
		double circleRatio = (numIn/TOTALPOINTS);
		System.out.println("\n\nRatio of point in the bullseye (entire circle): " + circleRatio);
		System.out.println("Number of points IN the circle: " + numIn + " out of " + TOTALPOINTS + " points");
		System.out.println("Number of points NOT in the circle: " + numOut + " out of " + TOTALPOINTS + " points");
		System.out.println("Estimation of Pi: " + (numIn*4/(numIn+numOut)));

	}
	
	private static void monteCarloPi(int points)
	{
		Random rand = new Random();
		double distance = 0;
		
		double totalPoints = points;

		int decimal = 1000000; // 1 million for a more accurate number
		
		double numIn = 0;
		double numOut = 0;
		
		for (int i = 0; i < totalPoints; i++)
		{
			double x = rand.nextInt(decimal);
			double y = rand.nextInt(decimal);
			
			distance = Math.sqrt((Math.pow((1-(x/decimal)),2) + Math.pow((1-(y/decimal)),2))); 

			if (distance <= 1)
				numIn++;
			else
				numOut++;
		}
		
		System.out.println("\n\nEstimation of pi using the monte Carlo method (Nothing to do with the applet)");
		
		System.out.println("\nRatio of points in the bullseye (entire circle): " + (numIn/TOTALPOINTS));
		System.out.println("Points IN the circle: " + numIn + " out of " + TOTALPOINTS + " points" );
		System.out.println("Points NOT in the circle: " + numOut + " out of " + TOTALPOINTS + " points");
		
		System.out.println("Estimate of Pi: " + ((numIn/totalPoints)*4) + " after " + TOTALPOINTS + " points generated");
	}
}

