package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

public class CartesianCoordinate extends DataObject implements Coordinate {

	private double x;
	private double y;
	private double z;

	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	/**
	 * Calculates the distance for cartesian coordinates
	 *
	 * @param other coordinate to calculate the distance to
	 * @return the distance between this and the other coordinate
	 */
	@Override
	public double getDistance(Coordinate other) {
		if (other == null) {
			throw new NullPointerException("the provided coordinate is null!");
		}
		CartesianCoordinate cartesianOther;
		if (other instanceof CartesianCoordinate) {
			cartesianOther = (CartesianCoordinate) other;
		} else if (other instanceof SphericCoordinate) {
			cartesianOther = convertSphericalToCartesian((SphericCoordinate) other);
		} else {
			throw new IllegalArgumentException("Provide an CartesiancCoordinate or SphericCoordinate to calculate a distance.");
		}
		double xDistancePowed = Math.pow(this.getX() - cartesianOther.getX(), 2);
		double yDistancePowed = Math.pow(this.getY() - cartesianOther.getY(), 2);
		double zDistancePowed = Math.pow(this.getZ() - cartesianOther.getZ(), 2);

		return Math.sqrt(xDistancePowed + yDistancePowed + zDistancePowed);

	}

	@Override
	public boolean isEqual(Coordinate other) {
		if (other instanceof CartesianCoordinate) {
			CartesianCoordinate cartesianOther = (CartesianCoordinate) other;
			return this.getX() == cartesianOther.getX()
				&& this.getY() == cartesianOther.getY()
				&& this.getZ() == cartesianOther.getZ();
		}
		return false;
	}

	private CartesianCoordinate convertSphericalToCartesian(SphericCoordinate spheric) {
		double latitude = deg2Rad(spheric.getLatitude());
		double longitutde = deg2Rad(spheric.getLongitude());
		
		double cx = spheric.getRadius() * Math.cos(latitude)*Math.cos(longitutde);
		double cy = spheric.getRadius() * Math.cos(latitude)*Math.sin(longitutde);
		double cz = spheric.getRadius() * Math.sin(latitude);
		
		return new CartesianCoordinate(cx, cy, cz);
	}
	
	private double deg2Rad(double degree) {
		return degree * Math.PI / 180;
	}
}
