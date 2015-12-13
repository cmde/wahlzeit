package org.wahlzeit.model.coordinate;

public class CartesianCoordinate extends AbstractCoordinate {

	private final double x;
	private final double y;
	private final double z;

	protected CartesianCoordinate(double x, double y, double z) {
		super(calculateLatitude(x, y, z),
			calculateLongitude(x, y),
			calculateRadius(x, y, z));
		assert Double.NaN != x;
		assert Double.NaN != y;
		assert Double.NaN != z;
		this.x = x;
		this.y = y;
		this.z = z;
		assert assertClassInvariants();
	}

	private static double calculateRadius(double x, double y, double z) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
	}
	
	private static double calculateLongitude(double x, double y) {
		return Math.toRadians(Math.atan2(y, x));
	}
	
	private static double calculateLatitude(double x, double y, double z) {
		return Math.toRadians(Math.asin(z / calculateRadius(x, y, z)));
	}

	public CartesianCoordinate setX(double x) {
		assert Double.NaN != x;
		return CoordinateFactory.getCarthesianCoordinate(x, getY(), getZ());
	}
	
	public CartesianCoordinate setY(double y) {
		assert Double.NaN != y;
		return CoordinateFactory.getCarthesianCoordinate(getX(), y, getZ());
	}
	
	public CartesianCoordinate setZ(double z) {
		assert Double.NaN != z;
		return CoordinateFactory.getCarthesianCoordinate(getX(), getY(), z);
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
