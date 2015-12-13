package org.wahlzeit.model.coordinate;

import java.util.HashMap;
import java.util.Map;

public class CoordinateFactory {

	private static final Map<String, Coordinate> instances = new HashMap<>();

	public static SphericCoordinate getSphericCoordinate(double latitude, double longitude, double radius) {
		SphericCoordinate tempCoord = new SphericCoordinate(latitude, longitude, radius);
		return (SphericCoordinate) checkAndGetInstance(tempCoord);
	}

	public static CartesianCoordinate getCarthesianCoordinate(double x, double y, double z) {
		CartesianCoordinate tempCoord = new CartesianCoordinate(x, y, z);
		return (CartesianCoordinate) checkAndGetInstance(tempCoord);
	}

	private static Coordinate checkAndGetInstance(AbstractCoordinate tempCoord) {
		String key = tempCoord.toString();
		synchronized (instances) {
			Coordinate instance = instances.get(key);

			if (instance == null) {
				instance = tempCoord;

				instances.put(key, instance);
			}

			return instance;
		}
	}

}
