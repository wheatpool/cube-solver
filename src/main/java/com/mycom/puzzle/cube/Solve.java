package com.mycom.puzzle.cube;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.mycom.puzzle.cube.domain.Cube;
import com.mycom.puzzle.cube.domain.Piece;
import com.mycom.puzzle.cube.service.Container;
import com.mycom.puzzle.cube.service.CubeSolver;

/**
 * The main class
 * Usage: Solve filename
 * 
 */
public class Solve {

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            FileInputStream file = null;
            try {
                file = new FileInputStream(args[0]);
                List<Piece> pieces = Container.getPieces(file);
                CubeSolver cubeSolver = new CubeSolver();
                Cube solution = cubeSolver.solve(pieces);
                if (solution != null) {
                    solution.print(System.out);
                } else {
                    System.err.println("No solution found.");
                }
            } finally {
                if (file != null) {
                    file.close();
                }
            }
        } else {
            System.out.println("Expected format: Solve filename");
        }
    }
}
