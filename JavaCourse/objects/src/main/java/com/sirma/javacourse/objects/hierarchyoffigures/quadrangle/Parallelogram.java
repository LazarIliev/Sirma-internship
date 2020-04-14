package com.sirma.javacourse.objects.hierarchyoffigures.quadrangle;

import com.sirma.javacourse.objects.hierarchyoffigures.polyline.Line;

public class Parallelogram extends Quadrangle {

	public Parallelogram(Line firstSideLenght, Line secondSideLenght, int firstAngle, int secondAngle) {
		super(firstSideLenght, secondSideLenght, firstSideLenght, secondSideLenght, firstAngle, secondAngle, firstAngle,
				secondAngle);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
