package org.wahlzeit.model;

public class Coordinate {

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
	 * @return the distance between this and the other coordinate as new
	 * coordinate object
	 */
	public Coordinate getDistance(Coordinate other) {
		return new Coordinate(getLatitudinalDistance(other),
			getLongitudinalDistance(other));
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
