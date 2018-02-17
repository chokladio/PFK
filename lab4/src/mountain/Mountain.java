package mountain;

import java.util.HashMap;

import fractal.*;

public class Mountain extends Fractal {
	private HashMap<Side, Point> sides = new HashMap<Side, Point>();
	private double r;
	private Point p1, p2, p3;

	/**
	 * Creates an object that handles Mountain's fractal.
	 * 
	 * @param length
	 *            the length of the triangle side
	 */
	public Mountain(Point p1, Point p2, Point p3, double r) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.r = r;

	}

	/**
	 * Returns the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return "Mountains triangel";
	}

	/**
	 * Draws the fractal.
	 * 
	 * @param turtle
	 *            the turtle graphic object
	 */
	public void draw(TurtleGraphics turtle) {
		fractalTriangle(turtle, order, p1, p2, p3, r);
	}

	/*
	 * Recursive method: Draws a recursive line of the triangle.
	 */

	private void fractalTriangle(TurtleGraphics turtle, int order, Point p1, Point p2, Point p3, double r) {
		if (order == 0) {
			turtle.moveTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());

		} else {
			Point ph1 = checkMid(p1, p2, r);
			Point ph2 = checkMid(p2, p3, r);
			Point ph3 = checkMid(p3, p1, r);

			fractalTriangle(turtle, order - 1, ph1, ph2, ph3, r / 2);
			fractalTriangle(turtle, order - 1, ph1, p1, ph3, r / 2);
			fractalTriangle(turtle, order - 1, ph1, ph2, p2, r / 2);
			fractalTriangle(turtle, order - 1, p3, ph2, ph3, r / 2);

		}
	}

	private Point checkMid(Point p1, Point p2, double r) {
		Side s = new Side(p1, p2);
		Point p = sides.get(s);
		
		if (p != null) {
			return sides.remove(s);
		} else {
			p = mid(p1, p2, r);
			sides.put(s, p);
		}
		return p;
		
	}

	private Point mid(Point p1, Point p2, double r) {
		return new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2 + (int) RandomUtilities.randFunc(r));
	}

}
