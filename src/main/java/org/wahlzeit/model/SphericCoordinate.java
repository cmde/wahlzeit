package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

	public SphericCoordinate(double latitude, double longitude, double radius) {
		if (latitude < -180 || latitude > 180 || longitude < -90 || longitude > 90 || radius < 0) {
			throw new IllegalArgumentException("latitude needs to be between [-180,180], longitude between [-90, 90], radius > 0");
		}

		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	@Override
	public double getLatitude() {
		return latitude;
	}

	@Override
	public double getLongitude() {
		return longitude;
	}

	@Override
	public double getRadius() {
		return radius;
	}

}
