package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

public abstract class AbstractCoordinate extends DataObject implements Coordinate {

	protected double deg2Rad(double degree) {
		return degree * Math.PI / 180;
	}

	protected double rad2Deg(double rad) {
		return rad * 180 / Math.PI;
	}
}
