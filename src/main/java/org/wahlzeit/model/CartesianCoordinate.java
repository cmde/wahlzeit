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

	@Override
	public double getLatitude() {
		return Math.toRadians(Math.asin(getZ() / getRadius()));
	}
	
	@Override
	public double getLongitude() {
		return Math.toRadians(Math.atan2(getY(), getX()));
	}
	
	@Override
	public double getRadius() {
		return Math.sqrt(
			Math.pow(getX(), 2)
			+ Math.pow(getY(), 2)
			+ Math.pow(getZ(), 2));
	}
}
