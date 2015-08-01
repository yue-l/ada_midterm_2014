
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

/* Data Structures and Algorithm 2014 - Mid Semester Test
 * Question 2. Drawing Sierpinski's triangle
 *
 * This class draws a sieprinski's triangle by recursively
 * approximating it using squares
 * You should only update paintThis method
 *
 * @ Author:Yue Li
 * @ Student ID:1251124
 */

public class RecursiveSquare extends JFrame {
	public static final int WINDOW_SIZE = 550;
	public static final int THRESHOLD = 5;
	public static int P1_x, P1_y, P2_x, P2_y, P3_x, P3_y;

	public RecursiveSquare() {
		super("Square Sierpinski");
		setSize(WINDOW_SIZE, WINDOW_SIZE);
		P1_x = 20;
		P1_y = 40;
		P2_x = (int) getSize().getWidth() - 20;
		P2_y = (int) getSize().getHeight() - 20;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * A utility method for computing the midpoint between two points The
	 * returned point is on the line segment between p1 and p2 r is the ratio of
	 * the distance between p1 and the return point against the distance between
	 * p1 and p2 when r=0.5, the returned point is exactly the midpoint between
	 * p1, p2
	 */
	public Point getMiddle(Point p1, Point p2, double r) {
		return new Point((int) (p1.getX() + r * (p2.getX() - p1.getX())),
				(int) (p1.getY() + r * (p2.getY() - p1.getY())));
	}

	// This is the method for initializing the painting
	public void paint(Graphics g) {
		super.paint(g);
		// paint a white background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int) getSize().getWidth(), (int) getSize()
				.getHeight());

		// initiate the painting
		g.setColor(Color.BLUE);
		paintThis(new Point(P1_x, P1_y), new Point(P2_x, P2_y));
	}

	/*
	 * This is the recursive method that paint the sierpinski's triangle You
	 * need to fill in the code for this method
	 */
	public void paintThis(Point p1, Point p2) {
		// ////////////////////////////////////
		// Fill in your code here
		// test if area is big enough
		int area = (p2.x - p1.x) * (p2.y - p1.y);
		// get middle point between p1 & p2
		Point midPointTopLeft = getMiddle(p1, p2, 0.5);
		if (area < THRESHOLD) {
			// if area is small
			return;
		} else {
			// recursive step
			Graphics g = super.getGraphics();
			g.setColor(Color.BLUE);
			g.fillRect(midPointTopLeft.x, midPointTopLeft.y, 2, 2);
			g.fillRect(p1.x, midPointTopLeft.y, 2, 2);
			Point topLeftPoint = new Point(p1.x, (p1.y + p2.y) / 2);
			Point bottomRightPoint = new Point((p1.x + p2.x) / 2, p2.y);
			// /////////// recursion calls
			paintThis(p1, midPointTopLeft);
			paintThis(midPointTopLeft, p2);
			paintThis(topLeftPoint, bottomRightPoint);
			// ////////////////////////////////////
		}
	}

	public static void main(String[] args) {
		RecursiveSquare gasket = new RecursiveSquare();
	}
}
