package com.sirma.javacourse.objects.hierarchyoffigures.polyline;

import com.sirma.javacourse.objects.hierarchyoffigures.circleellipsecurve.Curve;
import com.sirma.javacourse.objects.hierarchyoffigures.circleellipsecurve.Figure;

public class PolyLine extends Figure {

	private Line[] lines;
	private Curve[] curves;

	/**
	 * Setting the lines and the curve of the polyline.
	 *
	 * @param lines  the lines of the polyline
	 * @param curves the curve of the polyline
	 */
	public PolyLine(Line[] lines, Curve[] curves) {
		this.lines = lines;
		this.curves = curves;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
