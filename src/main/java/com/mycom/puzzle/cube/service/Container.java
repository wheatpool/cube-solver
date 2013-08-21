package com.mycom.puzzle.cube.service;

import static com.mycom.puzzle.cube.util.Constants.MAX_CELLS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.mycom.puzzle.cube.domain.Piece;

/**
 * Container contains all the pieces.
 * 
 */
public class Container {

    public static List<Piece> getPieces(InputStream is) throws IOException {
        List<Piece> pieces = new ArrayList<Piece>();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        String[] piece = new String[MAX_CELLS];
        int pieceNumber = 0;
        int i = 0;
        // Assumed the file is in correct format.
        while ((line = br.readLine()) != null) {
            piece[i] = line;
            i++;

            if (i == MAX_CELLS) {
                Piece p = new Piece("Piece: " + pieceNumber, piece);
                pieces.add(p);
                i = 0;
                pieceNumber++;
            }
        }
        return pieces;
    }

}
