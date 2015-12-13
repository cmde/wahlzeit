package org.wahlzeit.model.coordinate;

public interface Coordinate {

	public double getDistance(Coordinate other);
	public boolean isEqual(Coordinate other);

}
