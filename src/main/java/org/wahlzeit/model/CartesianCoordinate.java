package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

	private double x;
	private double y;
	private double z;

	public CartesianCoordinate(double x, double y, double z) {
		assert Double.NaN != x;
		assert Double.NaN != y;
		assert Double.NaN != z;
		this.x = x;
		this.y = y;
		this.z = z;
		updateSuperClassFields();
		assert assertClassInvariants();
	}

	/**
	 * updates the fields radius, longitutde and latitude of the super class.
	 * Always use this method when you change X, Y, Z to make sure the state
	 * remains consistent!
	 */
	private void updateSuperClassFields() {
		//no input parameters -> no assertions
		this.radius = Math.sqrt(
			Math.pow(getX(), 2)
			+ Math.pow(getY(), 2)
			+ Math.pow(getZ(), 2));
		this.longitude = Math.toRadians(Math.atan2(getY(), getX()));
		this.latitude = Math.toRadians(Math.asin(getZ() / getRadius()));

		assert assertClassInvariants();
	}

	public void setX(double x) {
		assert Double.NaN != x;
		this.x = x;
		updateSuperClassFields();
		assert assertClassInvariants();
	}
	public void setY(double y) {
		assert Double.NaN != y;
		this.y = y;
		updateSuperClassFields();
		assert assertClassInvariants();
	}
	public void setZ(double z) {
		assert Double.NaN != z;
		this.z = z;
		updateSuperClassFields();
		assert assertClassInvariants();
	}

	public double getX() {
		assert assertClassInvariants();
		return x;
	}

	public double getY() {
		assert assertClassInvariants();
		return y;
	}

	public double getZ() {
		assert assertClassInvariants();
		return z;
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

	@Override
	protected boolean assertClassInvariants() {
		boolean xValid = Double.NaN != x;
		boolean yValid = Double.NaN != y;
		boolean zValid = Double.NaN != z;
		return xValid && yValid && zValid && super.assertClassInvariants();
	}

}
