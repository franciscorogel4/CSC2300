import java.util.Random;
//-------------------------------------------------
// Code provided by Dr. Joyce	CSC 2300 Spring
//-------------------------------------------------
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

}