package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CartesianCoordinateTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private Coordinate c1, c2, c3, c4;
	private double precisionDelta;

	@Before
	public void setUp() {
		c1 = new CartesianCoordinate(0, 4, 0);
		c2 = new CartesianCoordinate(1, 5, 0);
		c3 = new CartesianCoordinate(2, 6, 0);
		c4 = new CartesianCoordinate(3, 7, 0);

		precisionDelta = 0.0000000001;

	}

	@Ignore
	@Test
	public void testDistances() {
		assertEquals(0.0, c1.getDistance(c1), precisionDelta);
		assertEquals(1.4142135624, c1.getDistance(c2), precisionDelta);
		assertEquals(2.8284271247, c1.getDistance(c3), precisionDelta);
		assertEquals(4.2426406871, c1.getDistance(c4), precisionDelta);

	}

	@Ignore
	@Test
	public void distanceCommutativity() {
		double distance1 = c1.getDistance(c2);
		double distance2 = c2.getDistance(c1);
		assertEquals(distance1, distance2, precisionDelta);
		assertEquals(distance1, distance2, precisionDelta);
	}

	@Ignore
	@Test
	public void distanceNullPointer() {
		thrown.expect(NullPointerException.class);
		c1.getDistance(null);
	}
}
