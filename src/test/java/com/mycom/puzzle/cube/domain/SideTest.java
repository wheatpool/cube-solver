package com.mycom.puzzle.cube.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SideTest {

	@Test
	public void testSide() {
		String[] piece1 = { "  o  ",  
							" ooo ",
							"ooooo", 
							" ooo ",
							"  o  "};
		String[] piece2 = { "o o o",
							"ooooo",
							" ooo ",
							"ooooo",
							"o o o"};
		String[] piece3 = { "  o  ",
							" oooo",
							"oooo ",
							" oooo",
							"  o  "};
		
		SideImpl side1 = new SideImpl("side1", piece1);
		SideImpl side2 = new SideImpl("side2", piece2);
		SideImpl side3 = new SideImpl("side3", piece3);
		
		assertTrue(side1.right.matches(side2.left));
		assertTrue(side2.right.matches(side1.left));
		assertTrue(side2.right.matches(side3.left));
		
		side1.rotateRight();
		side2.rotateRight();
		side3.rotateRight();
		
		assertTrue(side1.bottom.matches(side2.top));
		assertTrue(side2.bottom.matches(side1.top));
		assertTrue(side2.bottom.matches(side3.top));
		
		side1.rotateRight();
		side2.rotateRight();
		side3.rotateRight();
		
		assertTrue(side1.left.matches(side2.right));
		assertTrue(side2.left.matches(side1.right));
		assertTrue(side2.left.matches(side3.right));
		
		side1.rotateRight();
		side2.rotateRight();
		side3.rotateRight();
		
		assertTrue(side1.top.matches(side2.bottom));
		assertTrue(side2.top.matches(side1.bottom));
		assertTrue(side2.top.matches(side3.bottom));
	}
	
	@Test
	public void testSideAsCube() {
		String[] piece0 = { "  o  ",
							" ooo ",
							"ooooo",
							" ooo ",
							"  o  "};
		String[] piece1 = { "  o o",				
							"ooooo",
							" ooo ",
							"ooooo",
							" o oo"};
		String[] piece2 = { " o o ",
							" ooo ",
							"ooooo",
							" ooo ",
							"  o  "};
		String[] piece3 = { "o o  ",     
						    "ooooo",
						    " ooo ",
						    "ooooo",
						    " o o "};
		String[] piece4 = { "o o o",     
						    "ooooo",
						    " ooo ",
						    "ooooo",
						    "o o o"};
		String[] piece5 = { " o o ",     
						    "oooo ",
						    " oooo",
						    "oooo ",
						    "oo o "};
		SideImpl side0 = new SideImpl("side0", piece0);
		SideImpl side1 = new SideImpl("side1", piece1);
		SideImpl side2 = new SideImpl("side2", piece2);
		SideImpl side3 = new SideImpl("side3", piece3);
		SideImpl side4 = new SideImpl("side4", piece4);
		SideImpl side5 = new SideImpl("side5", piece5);
		
		assertTrue(side0.right.matches(side1.left));
		assertTrue(side1.right.matches(side2.left));
		
		assertTrue(side0.bottom.matches(side3.left));
		assertTrue(side1.bottom.matches(side3.top));
		assertTrue(side2.bottom.matches(side3.right));
		
		assertTrue(side0.left.matches(side4.left));
		assertTrue(side2.right.matches(side4.right));
		assertTrue(side3.bottom.matches(side4.top));
		
		assertTrue(side0.top.matches(side5.left));
		assertTrue(side1.top.matches(side5.bottom));
		assertTrue(side2.top.matches(side5.right));
		assertTrue(side4.bottom.matches(side5.top));
	}
	
	@Test
	public void testRotation() {
		// 0 deg
		String[] pos1 = { "abcde",
						  "pxxxf",
						  "oxxxg",
						  "nxxxh",
						  "mlkji"};
		// 90 deg
		String[] pos2 = { "mnopa",
						  "lxxxb",
						  "kxxxc",
						  "jxxxd",
						  "ihgfe"};
		// 180 deg
		String[] pos3 = { "ijklm",
						  "hxxxn",
						  "gxxxo",
						  "fxxxp",
						  "edcba"};
		// 270 deg
		String[] pos4 = { "efghi",
						  "dxxxj",
						  "cxxxk",
						  "bxxxl",
						  "aponm"};
		SideImpl side1 = new SideImpl("side1", pos1);
		SideImpl side2 = new SideImpl("side2", pos2);
		SideImpl side3 = new SideImpl("side3", pos3);
		SideImpl side4 = new SideImpl("side4", pos4);
		
		side1.rotateRight();
		assertSideEquals(side2,side1);
		
		side1.rotateRight();
		assertSideEquals(side3,side1);
		
		side1.rotateRight();
		assertSideEquals(side4,side1);

		side1.rotateLeft();
		assertSideEquals(side3,side1);
		
		side1.rotateLeft();
		assertSideEquals(side2,side1);
	}
	
	private void assertEdgeEquals(Edge expected, Edge edge) {
		assertNotNull(expected);
		assertNotNull(edge);
		assertEquals(expected.toString(), edge.toString());
	}
	
	private void assertSideEquals(SideImpl expected, SideImpl side) {
		assertNotNull(expected);
		assertNotNull(side);
		assertEdgeEquals(expected.top, side.top);
		assertEdgeEquals(expected.right, side.right);
		assertEdgeEquals(expected.bottom, side.bottom);
		assertEdgeEquals(expected.left, side.left);
	}
}
