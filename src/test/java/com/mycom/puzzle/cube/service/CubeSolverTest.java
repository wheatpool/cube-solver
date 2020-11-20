package com.mycom.puzzle.cube.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import com.mycom.puzzle.cube.domain.Cube;
import com.mycom.puzzle.cube.domain.Piece;
import org.junit.jupiter.api.Test;

public class CubeSolverTest {

	private static final String SOLUTION = 
			  "  o    o o o o "
			+ " ooo ooooo ooo "
			+ "ooooo ooo ooooo"
			+ " ooo ooooo ooo "
			+ "  o   o oo  o  "
			+ "     o o       "
			+ "     ooooo     "
			+ "      ooo      "
			+ "     ooooo     "
			+ "      o o      "
			+ "     o o o     "
			+ "     ooooo     "
			+ "      ooo      "
			+ "     ooooo     "
			+ "     o o o     "
			+ "      o o      "
			+ "     oooo      "
			+ "      oooo     "
			+ "     oooo      "
			+ "     oo o      ";

	
	@Test
	public void testCube() {
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
		
		List<Piece> pieces = Arrays.asList(piece0, piece1, piece2, piece3, piece4, piece5);
		
		CubeSolver solver = new CubeSolver();
		Cube solution = solver.solve(pieces);
		
		assertNotNull(solution);
		assertTrue(solution.isCompleted());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		solution.print(out);
		
		out.close();
		String result = baos.toString();
		
		assertEquals(SOLUTION, result.replace("\n", "").replace("\r", ""));
		System.out.println(result);
	}
}
