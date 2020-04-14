package com.sirma.javacourse.objects.hierarchyoffigures.quadrangle;

import com.sirma.javacourse.objects.hierarchyoffigures.polyline.Line;

public class Rectangle extends Parallelogram {
	private static final int ANGLE = 90;

	public Rectangle(Line firstSideLenght, Line secondSideLenght) {
		super(firstSideLenght, secondSideLenght, ANGLE, ANGLE);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
