import javax.swing.JApplet;
import javax.swing.JFrame;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Random;

@SuppressWarnings("serial")
public class calculatingPi extends JApplet
{
	static final int WIDTH = 600; // circle
	static final int HEIGHT = 600; // circle
	
	static final int totalPoints = 1000;
	
	static int rowWidth = 100; // 2d array length 
	static int colHeight = 2; // 2d array width

	static Random rand = new Random();
	
	public void paint (Graphics g)
	{
		drawBullseye(g);

		double distance = 0;
		int count = 0;

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("coordinates.txt"), "utf-8"))) 
		{
			for (int i = 0; i < totalPoints; i++)
			{
				try {
					Thread.sleep(10); // gives it a better effect but not needed
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				int x = rand.nextInt(WIDTH) + 1;
				int y = rand.nextInt(HEIGHT) + 1;

				distance = Math.sqrt((Math.pow(((WIDTH/2)-x),2) + Math.pow(((HEIGHT/2)-y),2))); 
				String dis = Double.toString(distance); //Printing the distance

				if (distance <= (WIDTH/2))
				{
					g.setColor(Color.cyan);;
					g.fillOval(x-1, y-1, 12, 12);

					g.setColor(Color.black);;
					g.fillOval(x, y, 10, 10);
					//g.drawString(dis, x, y);
				}
				else
				{ 
					this.drawX(g, x, y);
					//g.drawString(dis, x, y);
				}

				if(distance <= (WIDTH/2))
					count ++;

				writer.write(dis + "\n");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		drawCircle(g,1,60,count); // Printing the Number of points in the circle
	}

	private void drawBullseye(Graphics g)
	{
		Color customIndigo = new Color(43,43,59);
		Color customRed = new Color(248,67,74);
		Color customTan = new Color(251,242,208);

		g.setColor(Color.BLACK);

		g.setColor(customIndigo);
		g.fillOval(0, 0, 600, 600);

		g.setColor(customRed);
		g.fillOval(20, 20, 560, 560);

		g.setColor(customIndigo);
		g.fillOval(100, 100, 400, 400);

		g.setColor(customTan);
		g.fillOval(120, 120, 360, 360);

		g.setColor(customIndigo);
		g.fillOval(200, 200, 200, 200);

		g.setColor(customRed);
		g.fillOval(220, 220, 160, 160);

		g.setColor(customIndigo);
		g.fillOval(285, 285, 30, 30);
	}

	private void drawX (Graphics g, int x1, int y1)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.red);

		g2.drawLine(x1,y1,x1+10,y1+10); 
		g2.drawLine(x1+10,y1,x1,y1+10); 
	}

	private void drawCircle(Graphics g, int x, int y, int count)
	{
		String total = Double.toString(count);
		g.setColor(Color.green);
		g.setFont(new Font("default", Font.BOLD, 75));
		g.drawString(total, x, y);
	}
}