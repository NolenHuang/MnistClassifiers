package test.distances;

import static org.junit.Assert.*;
import instance.IntVector;

import org.junit.Before;
import org.junit.Test;

public class TestDistances {
	protected IntVector first, second;
	
	@Before
	public void setUp() {
		this.first = new IntVector(new int[]{1,2,3});
		this.second = new IntVector(new int[]{3,2,1});
	}
	
	@Test
	public void euclideanDistance() {
		double dist = Math.sqrt( Math.pow(1-3, 2) + Math.pow(2-2, 2) + Math.pow(3-1, 2) );
		assertEquals( dist, first.getEuclideanDistance(second), 0.00001);
	}
	

}
