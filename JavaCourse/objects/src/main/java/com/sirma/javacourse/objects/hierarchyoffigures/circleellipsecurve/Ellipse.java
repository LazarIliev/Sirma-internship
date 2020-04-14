package com.sirma.javacourse.objects.hierarchyoffigures.circleellipsecurve;

public class Ellipse extends Circle {
	private int longRadius;

	public Ellipse(int shortRadius, int longRadius) {
		super(shortRadius);

		this.longRadius = longRadius;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
