package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

public class Coordinate extends DataObject{

	private final double latitude;
	private final double longitude;

	public Coordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Calculates the distance for cartesian coordinates
	 *
	 * @param other coordinate to calculate the distance to
	 * @return the distance between this and the other coordinate
	 */
	public double getDistance(Coordinate other) {
		double latitudePowed = Math.pow(getLatitudinalDistance(other),2);
		double longitudePowed = Math.pow(getLongitudinalDistance(other),2);
		return Math.sqrt(latitudePowed+longitudePowed);
	}

	/**
	 * Calculates the latitudinal distance for cartesian coordinates
	 *
	 * @param other coordinate to calculate the distance to
	 * @return the distance between this and the other coordinate as a positive
	 * value
	 */
	public double getLatitudinalDistance(Coordinate other) {
		return Math.abs(this.latitude - other.latitude);
	}

	/**
	 * Calculates the longitudinal distance for cartesian coordinates
	 *
	 * @param other coordinate to calculate the distance to
	 * @return the distance between this and the other coordinate as a positive
	 * value
	 */
	public double getLongitudinalDistance(Coordinate other) {
		return Math.abs(this.longitude - other.longitude);
	}

}
