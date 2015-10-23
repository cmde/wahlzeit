package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CoordinateTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private Coordinate c1, c2, c3, c4;
	private double precisionDelta;

	@Before
	public void setUp() {
		c1 = new Coordinate(0, 4);
		c2 = new Coordinate(1, 5);
		c3 = new Coordinate(2, 6);
		c4 = new Coordinate(3, 7);

		precisionDelta = 0.00001;

	}

	@Test
	public void testLongitudinalDistance() {
		assertEquals(0.0, c1.getDistance(c1).getLongitude(), precisionDelta);
		assertEquals(1.0, c1.getDistance(c2).getLongitude(), precisionDelta);
		assertEquals(2.0, c1.getDistance(c3).getLongitude(), precisionDelta);
		assertEquals(3.0, c1.getDistance(c4).getLongitude(), precisionDelta);
	}

	@Test
	public void testLatitudinalDistance() {
		assertEquals(0.0, c1.getDistance(c1).getLatitude(), precisionDelta);
		assertEquals(1.0, c1.getDistance(c2).getLatitude(), precisionDelta);
		assertEquals(2.0, c1.getDistance(c3).getLatitude(), precisionDelta);
		assertEquals(3.0, c1.getDistance(c4).getLatitude(), precisionDelta);
	}

	@Test
	public void distanceCommutativity() {
		Coordinate distance1 = c1.getDistance(c2);
		Coordinate distance2 = c2.getDistance(c1);
		assertEquals(distance1.getLatitude(), distance2.getLatitude(), precisionDelta);
		assertEquals(distance1.getLongitude(), distance2.getLongitude(), precisionDelta);
	}

	@Test
	public void distanceNullPointer() {
		thrown.expect(NullPointerException.class);
		c1.getDistance(null);
	}
}
