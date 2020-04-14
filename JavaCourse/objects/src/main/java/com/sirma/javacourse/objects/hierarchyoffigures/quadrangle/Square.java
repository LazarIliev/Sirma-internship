package com.sirma.javacourse.objects.hierarchyoffigures.quadrangle;

import com.sirma.javacourse.objects.hierarchyoffigures.polyline.Line;

public class Square extends Rhombus {
	private static final int ANGLE = 90;

	public Square(Line sideLenght) {
		super(sideLenght, ANGLE, ANGLE);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
