package com.mycom.puzzle.cube.service;

import java.util.ArrayList;
import java.util.List;

import com.mycom.puzzle.cube.domain.Cube;
import com.mycom.puzzle.cube.domain.Piece;

/**
 * The cube problem solver.
 * 
 */
public class CubeSolver {

    /**
     * The problem solver.
     * 
     * @param pieces The pieces.
     * @return the solved cube, or null if not possible to solve.
     */
    public Cube solve(List<Piece> pieces) {
        Cube cube = Cube.createCube();
        return solve(pieces, cube);
    }

    private Cube solve(List<Piece> pieces, Cube cube) {
        if (cube.isCompleted()) {
            return cube;
        }

        if (pieces.isEmpty()) {
            return null;
        }

        for (Piece piece : pieces) {
            Cube solution = solveRemaining(pieces, cube, piece);
            if (solution != null) {
                return solution;
            }

            piece.flipSide();
            solution = solveRemaining(pieces, cube, piece);
            if (solution != null) {
                return solution;
            }
        }

        return null;
    }

    private Cube solveRemaining(List<Piece> pieces, Cube cube, Piece piece) {
        for (int i = 0; i < 4; i++) {
            if (cube.matches(piece)) {
                Cube tmp = cube.copy();
                tmp.setFace(piece);
                List<Piece> subList = new ArrayList<Piece>(pieces);
                subList.remove(piece);
                Cube solution = solve(subList, tmp);
                if (solution != null) {
                    return solution;
                }
            }
            piece.rotateRight();
        }

        return null;
    }
}
