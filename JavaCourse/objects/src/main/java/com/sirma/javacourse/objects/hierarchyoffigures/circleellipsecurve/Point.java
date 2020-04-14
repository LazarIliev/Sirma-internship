package com.sirma.javacourse.objects.hierarchyoffigures.circleellipsecurve;

public class Point {
	private int x;
	private int y;

	/**
	 * Creates new point with given coordinates X and Y.
	 *
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 */
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Gets X coordinate.
	 *
	 * @return the X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets X coordinate.
	 *
	 * @param x the X coordinate to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets Y coordinate.
	 *
	 * @return the Y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets Y coordinate.
	 *
	 * @param y the Y coordinate to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}
