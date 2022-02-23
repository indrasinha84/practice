package algopractice;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DamDesignTest {
	DamDesign dd;
	
	@Before
	public void setUp() throws Exception {
		dd = new DamDesign();

	}

	@Test
	public void testCalculateWallHeight() {
		int n = 4;
		int[] wallPositions = { 1, 2, 4, 7 };
		int[] wallHeights = { 4, 6, 8, 11 };
		int max = dd.calculateWallHeight(n, wallPositions, wallHeights);
		assertEquals(max, 10);
	}

}
