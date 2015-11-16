package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

public abstract class AbstractCoordinate extends DataObject implements Coordinate {

	private final double DELTA = 0.00001;

	protected double latitude;
	protected double longitude;
	protected double radius;

	public abstract double getLatitude();
	public abstract double getLongitude();
	public abstract double getRadius();

	/**
	 * Calculates the distance to other Coordinates in kilometres
	 *
	 * @param other coordinate to calculate the distance to
	 * @return the distance between this and the other coordinate in kilometers
	 */
	@Override
	public double getDistance(Coordinate other) {
		if (other == null) {
			throw new NullPointerException("the provided coordinate is null!");
		}
		AbstractCoordinate abstractOther = (AbstractCoordinate) other;

		if (abstractOther.getRadius() != this.getRadius()) {
			throw new IllegalArgumentException("Provide a Coordinate from the same planet to get a valid result. "
				+ "The radius (" + this.getRadius() + ") from this Coordinate differs from the other Coordinate's radius (" + abstractOther.getRadius() + ").");
		}
		double latitudeRad = Math.toRadians(this.getLatitude());
		double longitudeRad = Math.toRadians(this.getLongitude());
		double otherLatitudeRad = Math.toRadians(abstractOther.getLatitude());
		double otherLongitutdeRad = Math.toRadians(abstractOther.getLongitude());

		return Math.acos(Math.sin(latitudeRad) * Math.sin(otherLatitudeRad)
			+ Math.cos(latitudeRad) * Math.cos(otherLatitudeRad)
			* Math.cos(otherLongitutdeRad - longitudeRad)) * getRadius();
	}

	/**
	 * Checks if a Coordinate is at the same place as this one.
	 *
	 * @param other the other Coordinate
	 * @return true if other is not null and at the same place
	 */
	@Override
	public boolean isEqual(Coordinate other) {
		if (other != null) {
			Double distance = getDistance(other);
			return distance.compareTo(DELTA) <= 0;
		}
		return false;
	}

}
