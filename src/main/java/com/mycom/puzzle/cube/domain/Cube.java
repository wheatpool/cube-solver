package com.mycom.puzzle.cube.domain;

import static com.mycom.puzzle.cube.util.Constants.MAX_CELLS;
import static com.mycom.puzzle.cube.util.Constants.repeate;

import java.io.PrintStream;

/**
 * The class represents the Cube.
 * 
 */
public class Cube {
	private static final int MAX_FACES = 6;
	private static final String SPACER = repeate(' ', MAX_CELLS);
	
	/**
	 * Holds each face of the Cube.
	 */
	private CubeFace[] faces = new CubeFace[MAX_FACES];
	/**
	 * The index of the current face.
	 */
	private int currentFace = 0;

	private Cube() {
	}

	/**
	 * The factory method for creating the Cube.
	 * 
	 * @return
	 */
	public static Cube createCube() {
		final Cube cube = new Cube();
		for (int i = 0; i < MAX_FACES; i++) {
			cube.faces[i] = new CubeFace(i);
		}
		return cube;
	}

	/**
	 * Makes a copy of this Cube.
	 * 
	 * @return
	 */
	public Cube copy() {
		final Cube cube = new Cube();
		System.arraycopy(faces, 0, cube.faces, 0, MAX_FACES);
		cube.currentFace = currentFace;
		return cube;
	}

	/**
	 * Checks if the current face is set.
	 * @return
	 */
	public boolean isFaceSet() {
		return faces[currentFace].isPieceSet();
	}

	/**
	 * Checks if the given piece would fit in the current face.
	 * 
	 * @param piece
	 * @return
	 */
	public boolean matches(final Piece piece) {
		switch (currentFace) {
		case 0:
			return true;
		case 1:
			return faces[0].getPiece().getRightEdge().matches(piece.getLeftEdge());
		case 2:
			return faces[1].getPiece().getRightEdge().matches(piece.getLeftEdge());
		case 3:
			return faces[0].getPiece().getBottomEdge().matches(piece.getLeftEdge())
					&& faces[1].getPiece().getBottomEdge().matches(piece.getTopEdge())
					&& faces[2].getPiece().getBottomEdge().matches(piece.getRightEdge())
					&& matchCorners(faces[0].getPiece().isSECornerFilled(), 
							faces[1].getPiece().isSWCornerFilled(), piece.isNWCornerFilled())
					&& matchCorners(faces[1].getPiece().isSECornerFilled(), 
							faces[2].getPiece().isSWCornerFilled(), piece.isNECornerFilled());
		case 4:
			return faces[3].getPiece().getBottomEdge().matches(piece.getTopEdge())
					&& faces[0].getPiece().getLeftEdge().matches(piece.getLeftEdge())
					&& faces[2].getPiece().getRightEdge().matches(piece.getRightEdge())
					&& matchCorners(faces[3].getPiece().isSWCornerFilled(), 
							faces[0].getPiece().isSWCornerFilled(), piece.isNWCornerFilled())
					&& matchCorners(faces[3].getPiece().isSECornerFilled(), 
							faces[2].getPiece().isSECornerFilled(), piece.isNECornerFilled());
		case 5:
			return faces[0].getPiece().getTopEdge().matches(piece.getLeftEdge())
					&& faces[1].getPiece().getTopEdge().matches(piece.getBottomEdge())
					&& faces[2].getPiece().getTopEdge().matches(piece.getRightEdge())
					&& faces[4].getPiece().getBottomEdge().matches(piece.getTopEdge())
					&& matchCorners(faces[0].getPiece().isNWCornerFilled(), 
							faces[4].getPiece().isSWCornerFilled(), piece.isNWCornerFilled())
					&& matchCorners(faces[4].getPiece().isSECornerFilled(), 
							faces[2].getPiece().isNECornerFilled(), piece.isNECornerFilled())
					&& matchCorners(faces[0].getPiece().isNECornerFilled(), 
							faces[1].getPiece().isNWCornerFilled(), piece.isSWCornerFilled())
					&& matchCorners(faces[1].getPiece().isNECornerFilled(), 
							faces[2].getPiece().isNWCornerFilled(), piece.isSECornerFilled());
		}
		return false;
	}

	/**
	 * Check if one and only one corner of the three corners is set.
	 */
	private boolean matchCorners(final boolean corner1, final boolean corner2, final boolean corner3) {
		return (corner1 && !corner2 && !corner3)
				|| (!corner1 && corner2 && !corner3)
				|| (!corner1 && !corner2 && corner3);
	}
	
	/**
	 * Returns true if the piece was set.
	 * 
	 * @param piece the piece to be set.
	 * @return true if the piece was set.
	 */
	public boolean setFace(final Piece piece) {
		boolean result = false;
		if (!isCompleted() && matches(piece)) {
			faces[currentFace].setPiece(piece);
			currentFace++;
			result = true;
		}
		
		return result;
	}

	/**
	 * Checks if the cube is complete.
	 * 
	 * @return
	 */
	public boolean isCompleted() {
		return currentFace == MAX_FACES;
	}

	/**
	 * Print the Cube.
	 * 
	 * @param out
	 */
	public void print(PrintStream out) {
		if (!isCompleted()) {
			return;
		}
		
		final String[] piece0 = faces[0].getPiece().getTextRepresentation();
		final String[] piece1 = faces[1].getPiece().getTextRepresentation();
		final String[] piece2 = faces[2].getPiece().getTextRepresentation();
		for (int i = 0; i < MAX_CELLS; i++) {
			out.print(piece0[i]);
			out.print(piece1[i]);
			out.println(piece2[i]);
		}
		
		print(out, faces[3].getPiece().getTextRepresentation());
		print(out, faces[4].getPiece().getTextRepresentation());
		print(out, faces[5].getPiece().getTextRepresentation());
	}
	
	private void print(PrintStream out, String[] piece) {
		for (int i = 0; i < MAX_CELLS; i++) {
			out.print(SPACER);
			out.print(piece[i]);
			out.println(SPACER);
		}
	}
}
