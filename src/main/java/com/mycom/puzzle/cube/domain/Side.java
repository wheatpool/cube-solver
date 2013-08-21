package com.mycom.puzzle.cube.domain;

/**
 * Interface representing a side of a piece.
 * 
 */
public interface Side {

    /**
     * Rotate the piece (90 deg) to the left.
     */
    void rotateLeft();

    /**
     * Rotate the piece (90 deg) to the right.
     */
    void rotateRight();

    /**
     * Return the top {@link Edge}.
     */
    Edge getTopEdge();

    /**
     * Return the left {@link Edge}.
     */
    Edge getLeftEdge();

    /**
     * Return the right {@link Edge}.
     */
    Edge getRightEdge();

    /**
     * Return the bottom {@link Edge}.
     */
    Edge getBottomEdge();

    /**
     * Recreate the text representation based on the current state of the Side.
     * 
     * @return
     */
    String[] getTextRepresentation();
}
