package com.mycom.puzzle.cube.domain;

/**
 * Class represents one face of the cube.
 * 
 */
public class CubeFace {

    private final int id;

    private Piece piece;

    public CubeFace(int id) {
        this.id = id;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isPieceSet() {
        return piece == null;
    }

    public Piece getPiece() {
        return piece;
    }
}
