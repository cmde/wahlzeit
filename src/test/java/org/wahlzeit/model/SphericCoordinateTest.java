package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SphericCoordinateTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	int earthRadius = 6367; //radius in km
	
	private Coordinate c1, c2, c3, c4;
	private double precisionDelta;

	@Before
	public void setUp() {
		c1 = new SphericCoordinate(49.4360936, 11.1011233, earthRadius); //Nuremberg
		c2 = new SphericCoordinate(49.5891771, 10.9844836, earthRadius); //Erlangen
		c3 = new SphericCoordinate(42.0, 42.0, 17); //somwhere below Georgia

		precisionDelta = 0.0000000001;

	}

	@Test
	public void testDistances() {
		assertEquals(0.0, c1.getDistance(c1), precisionDelta);
		assertEquals(18.97926325781515, c1.getDistance(c2), precisionDelta);

	}

	@Test
	public void distanceCommutativity() {
		double distance1 = c1.getDistance(c2);
		double distance2 = c2.getDistance(c1);
		assertEquals(distance1, distance2, precisionDelta);
		assertEquals(distance2, distance1, precisionDelta);
	}

	@Ignore
	@Test
	public void distanceNullPointer() {
		thrown.expect(NullPointerException.class);
		c1.getDistance(null);
	}
	
	@Test
	public void notOnEarthSurface(){
		thrown.expect(IllegalArgumentException.class);
		c1.getDistance(c3);
	}
}
