package org.wahlzeit.model.coordinate;

public class SphericCoordinate extends AbstractCoordinate {

	protected SphericCoordinate(double latitude, double longitude, double radius) {
		super(latitude, longitude, radius);
	}

	@Override
	public double getLatitude() {
		assert assertClassInvariants();
		return latitude;
	}

	@Override
	public double getLongitude() {
		assert assertClassInvariants();
		return longitude;
	}

	@Override
	public double getRadius() {
		assert assertClassInvariants();
		return radius;
	}

}
