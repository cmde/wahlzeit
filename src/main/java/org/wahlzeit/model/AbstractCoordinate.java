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
		assert other != null : "Coordinate should not be null";

		AbstractCoordinate abstractOther = (AbstractCoordinate) other;

		if (abstractOther.getRadius() != this.getRadius()) {
			throw new IllegalArgumentException("Provide a Coordinate from the same planet to get a valid result. "
				+ "The radius (" + this.getRadius() + ") from this Coordinate differs from the other Coordinate's radius (" + abstractOther.getRadius() + ").");
		}
		double latitudeRad = Math.toRadians(this.getLatitude());
		double longitudeRad = Math.toRadians(this.getLongitude());
		double otherLatitudeRad = Math.toRadians(abstractOther.getLatitude());
		double otherLongitutdeRad = Math.toRadians(abstractOther.getLongitude());

		double result = Math.acos(Math.sin(latitudeRad) * Math.sin(otherLatitudeRad)
			+ Math.cos(latitudeRad) * Math.cos(otherLatitudeRad)
			* Math.cos(otherLongitutdeRad - longitudeRad)) * getRadius();

		assert result >= 0;
		assert Double.NaN != result;
		assert abstractOther.assertClassInvariants();
		assert assertClassInvariants();

		return result;
	}

	/**
	 * Checks if a Coordinate is at the same place as this one.
	 *
	 * @param other the other Coordinate
	 * @return true if other is not null and at the same place
	 */
	@Override
	public boolean isEqual(Coordinate other) {
		assert other != null : "Coordinate should not be null";

		Double distance = getDistance(other);
		boolean equality = distance.compareTo(DELTA) <= 0;

		assert equality == true || equality == false;
		assert ((AbstractCoordinate) other).assertClassInvariants();
		assert assertClassInvariants();

		return equality;

	}

	/**
	 * Tells you whether this object is in a valid state or not. For usage in
	 * assert statements!
	 *
	 * @return whethter the object is in a valid state or not as boolean value
	 */
	protected boolean assertClassInvariants() {
		boolean validLatitude = Double.NaN != latitude && -180 <= latitude && 180 >= latitude;
		boolean validLongitude = Double.NaN != longitude && -90 <= longitude && 90 >= longitude;
		boolean validRadius = Double.NaN != radius && 0 <= radius;
		return validLatitude && validLongitude && validRadius;
	}

}
