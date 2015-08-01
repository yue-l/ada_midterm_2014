package partice;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Sierpinski extends JPanel {
	// set window size here
	public static final int WINDOWSIZE = 500;
	// some static variables
	static Polygon[] polyList;
	static int count = 0;

	public static void drawTriangles(int splits, int ax, int ay, int bx,
			int by, int cx, int cy) {
		int[] p1 = { ax, ay };
		int[] p2 = { bx, by };
		int[] p3 = { cx, cy };
		if (splits == 1) {
			// create basic triangle
			int[] xs = { ax, bx, cx };
			int[] ys = { ay, by, cy };
			Polygon p = new Polygon(xs, ys, xs.length);
			polyList[count] = p;
			count++;
		} else {
			// get midpoints for each side
			int[] p4 = getMidpoint(ax, ay, bx, by);
			int[] p5 = getMidpoint(bx, by, cx, cy);
			int[] p6 = getMidpoint(ax, ay, cx, cy);
			// 3 new triangles
			drawTriangles(splits - 1, p1[0], p1[1], p4[0], p4[1], p6[0], p6[1]);
			drawTriangles(splits - 1, p4[0], p4[1], p2[0], p2[1], p5[0], p5[1]);
			drawTriangles(splits - 1, p6[0], p6[1], p5[0], p5[1], p3[0], p3[1]);
		}
	}

	// returns the midpoint as an array [x,y] of any line given the coordinates
	public static int[] getMidpoint(int ax, int ay, int bx, int by) {
		int[] mid = new int[2];
		mid[0] = (ax + bx) / 2;
		mid[1] = (ay + by) / 2;
		return mid;
	}

	public void paint(Graphics g) {
		for (int i = 0; i < polyList.length; i++) {
			g.fillPolygon(polyList[i]);
		}
	}

	public static void main(String[] args) {
		// make the base triangle based on the window size
		// point 1 -- top
		int p1x = WINDOWSIZE / 2;
		int p1y = WINDOWSIZE / 10;
		// point 2 -- bottom right
		int p2x = WINDOWSIZE - p1y;
		int p2y = WINDOWSIZE - p1y;
		// point 3 -- bottom left
		int p3x = WINDOWSIZE / 10;
		int p3y = WINDOWSIZE - p1y;
		// ask user how many splits
		Scanner keyboard = new Scanner(System.in);
		System.out.print("How many splits? ");
		int splits = keyboard.nextInt();
		polyList = new Polygon[(int) Math.pow(3, splits - 1)];
		// new window
		JFrame f = new JFrame("Sierpinski's Triangle!");
		f.setSize(WINDOWSIZE, WINDOWSIZE);
		f.setBackground(Color.white);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
		drawTriangles(splits, p1x, p1y, p2x, p2y, p3x, p3y);
		Sierpinski s = new Sierpinski();
		f.add(s);
	}
}
