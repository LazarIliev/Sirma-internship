package com.sirma.javacourse.objects.hierarchyoffigures.quadrangle;

import com.sirma.javacourse.objects.hierarchyoffigures.circleellipsecurve.Figure;
import com.sirma.javacourse.objects.hierarchyoffigures.circleellipsecurve.Point;
import com.sirma.javacourse.objects.hierarchyoffigures.polyline.Line;

public class Quadrangle extends Figure {
	private Line firstSideLenght;
	private Line secondSideLenght;
	private Line thirdSideLenght;
	private Line fourthSideLenght;
	private int firstAngle;
	private int secondAngle;
	private int thirdAngle;
	private int fourthAngle;

	public Quadrangle(Line firstSideLenght, Line secondSideLenght, Line thirdSideLenght, Line fourthSideLenght,
			int firstAngle, int secondAngle, int thirdAngle, int fourthAngle) {
		this.firstSideLenght = firstSideLenght;
		this.secondSideLenght = secondSideLenght;
		this.thirdSideLenght = thirdSideLenght;
		this.fourthSideLenght = fourthSideLenght;
		this.firstAngle = firstAngle;
		this.secondAngle = secondAngle;
		this.thirdAngle = thirdAngle;
		this.fourthAngle = fourthAngle;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

}
