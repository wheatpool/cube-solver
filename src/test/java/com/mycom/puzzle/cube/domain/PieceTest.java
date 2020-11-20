package com.mycom.puzzle.cube.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PieceTest {

	@Test
	public void testPiece() {
		String[] tPiece1 = {"  o  ",  
							" ooo ",
							"ooooo", 
							" ooo ",
							"  o  "};
		String[] tPiece2 = {"o o o",
							"ooooo",
							" ooo ",
							"ooooo",
							"o o o"};
		String[] tPiece3 = {"  o  ",
							" oooo",
							"oooo ",
							" oooo",
							"  o  "};
		
		Piece piece1 = new Piece("piece1", tPiece1);
		Piece piece2 = new Piece("piece2", tPiece2);
		Piece piece3 = new Piece("piece3", tPiece3);
		
		assertTrue(piece1.getRightEdge().matches(piece2.getRightEdge()));
		assertTrue(piece2.getRightEdge().matches(piece1.getLeftEdge()));
		assertTrue(piece2.getRightEdge().matches(piece3.getLeftEdge()));
		
		piece1.rotateRight();
		piece2.rotateRight();
		piece3.rotateRight();
		
		assertTrue(piece1.getBottomEdge().matches(piece2.getTopEdge()));
		assertTrue(piece2.getBottomEdge().matches(piece1.getTopEdge()));
		assertTrue(piece2.getBottomEdge().matches(piece3.getTopEdge()));
		
		piece1.rotateRight();
		piece2.rotateRight();
		piece3.rotateRight();
		
		assertTrue(piece1.getLeftEdge().matches(piece2.getRightEdge()));
		assertTrue(piece2.getLeftEdge().matches(piece1.getRightEdge()));
		assertTrue(piece2.getLeftEdge().matches(piece3.getRightEdge()));
		
		piece1.rotateRight();
		piece2.rotateRight();
		piece3.rotateRight();
		
		assertTrue(piece1.getTopEdge().matches(piece2.getBottomEdge()));
		assertTrue(piece2.getTopEdge().matches(piece1.getBottomEdge()));
		assertTrue(piece2.getTopEdge().matches(piece3.getBottomEdge()));
	}
	
	@Test
	public void testPieceAsCube() {
		String[] tPiece0 = {"  o  ",
							" ooo ",
							"ooooo",
							" ooo ",
							"  o  "};
		String[] tPiece1 = {"  o o",				
							"ooooo",
							" ooo ",
							"ooooo",
							" o oo"};
		String[] tPiece2 = {" o o ",
							" ooo ",
							"ooooo",
							" ooo ",
							"  o  "};
		String[] tPiece3 = {"o o  ",     
						    "ooooo",
						    " ooo ",
						    "ooooo",
						    " o o "};
		String[] tPiece4 = {"o o o",     
						    "ooooo",
						    " ooo ",
						    "ooooo",
						    "o o o"};
		String[] tPiece5 = {" o o ",     
						    "oooo ",
						    " oooo",
						    "oooo ",
						    "oo o "};
		Piece piece0 = new Piece("piece0", tPiece0);
		Piece piece1 = new Piece("piece1", tPiece1);
		Piece piece2 = new Piece("piece2", tPiece2);
		Piece piece3 = new Piece("piece3", tPiece3);
		Piece piece4 = new Piece("piece4", tPiece4);
		Piece piece5 = new Piece("piece5", tPiece5);
		
		assertTrue(piece0.getRightEdge().matches(piece1.getLeftEdge()));
		assertTrue(piece1.getRightEdge().matches(piece2.getLeftEdge()));
		
		assertTrue(piece0.getBottomEdge().matches(piece3.getLeftEdge()));
		assertTrue(piece1.getBottomEdge().matches(piece3.getTopEdge()));
		assertTrue(piece2.getBottomEdge().matches(piece3.getRightEdge()));
		
		assertTrue(piece0.getLeftEdge().matches(piece4.getLeftEdge()));
		assertTrue(piece2.getRightEdge().matches(piece4.getRightEdge()));
		assertTrue(piece3.getBottomEdge().matches(piece4.getTopEdge()));
		
		assertTrue(piece0.getTopEdge().matches(piece5.getLeftEdge()));
		assertTrue(piece1.getTopEdge().matches(piece5.getBottomEdge()));
		assertTrue(piece2.getTopEdge().matches(piece5.getRightEdge()));
		assertTrue(piece4.getBottomEdge().matches(piece5.getTopEdge()));
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
		Piece piece1 = new Piece("piece1", pos1);
		Piece piece2 = new Piece("piece2", pos2);
		Piece piece3 = new Piece("piece3", pos3);
		Piece piece4 = new Piece("piece4", pos4);
		
		piece1.rotateRight();
		assertPieceEquals(piece2,piece1);
		
		piece1.rotateRight();
		assertPieceEquals(piece3,piece1);
		
		piece1.rotateRight();
		assertPieceEquals(piece4,piece1);

		piece1.rotateLeft();
		assertPieceEquals(piece3,piece1);
		
		piece1.rotateLeft();
		assertPieceEquals(piece2,piece1);
	}
	
	private void assertEdgeEquals(Edge expected, Edge edge) {
		assertNotNull(expected);
		assertNotNull(edge);
		assertEquals(expected.toString(), edge.toString());
	}
	
	private void assertPieceEquals(Piece expected, Piece side) {
		assertNotNull(expected);
		assertNotNull(side);
		assertEdgeEquals(expected.getTopEdge(), side.getTopEdge());
		assertEdgeEquals(expected.getRightEdge(), side.getRightEdge());
		assertEdgeEquals(expected.getBottomEdge(), side.getBottomEdge());
		assertEdgeEquals(expected.getLeftEdge(), side.getLeftEdge());
	}
}
