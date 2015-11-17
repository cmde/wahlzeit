package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

	public SphericCoordinate(double latitude, double longitude, double radius) {
		assert -180 <= latitude : "Latitude " + latitude + " too small.";
		assert 180 >= latitude : "Latitude " + latitude + " too large.";
		assert -90 <= longitude : "Latitude " + longitude + " too small.";
		assert 90 >= longitude : "Latitude " + longitude + " too large.";
		assert 0 <= radius : "Invalid radius " + radius;
		if (latitude < -180 || latitude > 180 || longitude < -90 || longitude > 90 || radius < 0) {
			throw new IllegalArgumentException("latitude needs to be between [-180,180], longitude between [-90, 90], radius > 0");
		}

		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		assert assertClassInvariants();
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
