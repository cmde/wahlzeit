package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

public class SphericCoordinate extends DataObject implements Coordinate {

	private double latitude;
	private double longitude;
	private double radius;

	public SphericCoordinate(double latitude, double longitude, double radius) {
		if (latitude < -180 || latitude > 180 || longitude < -90 || longitude > 90 || radius < 0) {
			throw new IllegalArgumentException("latitude needs to be between [-180,180], longitude between [-90, 90], radius > 0");
		}

		this.latitude = latitude;
		this.longitude = longitude;
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getDistance(Coordinate other) {
		if (other == null) {
			throw new NullPointerException("the provided coordinate is null!");
		}
		SphericCoordinate sphericOther;
		if (other instanceof SphericCoordinate) {
			sphericOther = (SphericCoordinate) other;
		} else if (other instanceof CartesianCoordinate) {
			sphericOther = convertCartesianToSpheric((CartesianCoordinate) other);
		} else {
			throw new IllegalArgumentException("Provide a SphericCoordinate or CartesianCoordinate to calculate a distance.");
		}

		if (sphericOther.getRadius() != this.getRadius()) {
			throw new IllegalArgumentException("Provide a SphericCoordinate from the same planet to get a valid result. "
				+ "The radius (" + this.getRadius() + ") from this Coordinate differst from the other Coordinate's radius (" + sphericOther.getRadius() + ").");
		}
		double latitudeRad = deg2Rad(this.latitude);
		double longitudeRad = deg2Rad(this.longitude);
		double otherLatitudeRad = deg2Rad(sphericOther.latitude);
		double otherLongitutdeRad = deg2Rad(sphericOther.longitude);

		return Math.acos(Math.sin(latitudeRad) * Math.sin(otherLatitudeRad)
			+ Math.cos(latitudeRad) * Math.cos(otherLatitudeRad)
			* Math.cos(otherLongitutdeRad - longitudeRad)) * radius;
	}

	@Override
	public boolean isEqual(Coordinate other) {
		if (other instanceof SphericCoordinate) {
			SphericCoordinate sphericOther = (SphericCoordinate) other;
			return this.getLatitude() == sphericOther.getLatitude()
				&& this.getLongitude() == sphericOther.getLongitude()
				&& this.getRadius() == sphericOther.getRadius();
		}
		return false;
	}

	private double deg2Rad(double degree) {
		return degree * Math.PI / 180;
	}
	
	private double rad2Deg(double rad) {
		return rad * 180 / Math.PI;
	}

	private SphericCoordinate convertCartesianToSpheric(CartesianCoordinate cartCoord) {
		double newRadius = Math.sqrt(
			Math.pow(cartCoord.getX(), 2)
			+ Math.pow(cartCoord.getY(), 2)
			+ Math.pow(cartCoord.getZ(), 2));

		double newLat = rad2Deg(Math.asin(cartCoord.getZ()/newRadius));
		double newLon = rad2Deg(Math.atan2(cartCoord.getY(), cartCoord.getX()));

		return new SphericCoordinate(newLat, newLon, newRadius);
	}
}
