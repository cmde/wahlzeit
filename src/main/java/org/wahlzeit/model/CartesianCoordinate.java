package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

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
	 * Calculates the distance to other CartesianCoordinates or
	 * SphericCoordinates
	 *
	 * @param other coordinate to calculate the distance to
	 * @return the distance between this and the other coordinate in kilometers
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

	/**
	 * Checks if a CarthesianCoordinate is at the same place as this one.
	 *
	 * @param other the other CathesianCoordinate
	 * @return true if other is CarthesianCoordinate and at the same place
	 */
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

		double cx = spheric.getRadius() * Math.cos(latitude) * Math.cos(longitutde);
		double cy = spheric.getRadius() * Math.cos(latitude) * Math.sin(longitutde);
		double cz = spheric.getRadius() * Math.sin(latitude);

		return new CartesianCoordinate(cx, cy, cz);
	}

}
