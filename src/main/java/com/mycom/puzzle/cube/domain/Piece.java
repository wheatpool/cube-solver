package com.mycom.puzzle.cube.domain;

/**
 * The class represents a single piece.
 * A piece could have two {@link Side}s, and four {@link Edge}s.
 * 
 */
public class Piece implements Side {

    private final String name;

    private Side currentSide;

    private Side otherSide;

    public Piece(String name, String[] rows) {
        this.name = name;
        SideImpl side = new SideImpl(name + ": Outside", rows);
        currentSide = side;
        otherSide = side.createFlipSide(name + ": Inside");
    }

    /**
     * Flip the sides.
     */
    public void flipSide() {
        Side tmp = currentSide;
        currentSide = otherSide;
        otherSide = tmp;
    }

    @Override
    public void rotateLeft() {
        currentSide.rotateLeft();
        otherSide.rotateLeft();
    }

    @Override
    public void rotateRight() {
        currentSide.rotateRight();
        otherSide.rotateRight();
    }

    @Override
    public Edge getTopEdge() {
        return currentSide.getTopEdge();
    }

    @Override
    public Edge getLeftEdge() {
        return currentSide.getLeftEdge();
    }

    @Override
    public Edge getRightEdge() {
        return currentSide.getRightEdge();
    }

    @Override
    public Edge getBottomEdge() {
        return currentSide.getBottomEdge();
    }

    /**
     * Returns true if the North West Corner is filled.
     * 
     * @return true if the North West Corner is filled.
     */
    public boolean isNWCornerFilled() {
        return currentSide.getTopEdge().isFirstCornerFilled();
    }

    /**
     * Returns true if the North East Corner is filled.
     * 
     * @return true if the North East Corner is filled.
     */
    public boolean isNECornerFilled() {
        return currentSide.getTopEdge().isSecondCornerFilled();
    }

    /**
     * Returns true if the South West Corner is filled.
     * 
     * @return true if the South West Corner is filled.
     */
    public boolean isSWCornerFilled() {
        return currentSide.getBottomEdge().isFirstCornerFilled();
    }

    /**
     * Returns true if the South East Corner is filled.
     * 
     * @return true if the South East Corner is filled.
     */
    public boolean isSECornerFilled() {
        return currentSide.getBottomEdge().isSecondCornerFilled();
    }

    @Override
    public String[] getTextRepresentation() {
        return currentSide.getTextRepresentation();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((otherSide == null) ? 0 : otherSide.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Piece other = (Piece) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (otherSide == null) {
            if (other.otherSide != null)
                return false;
        } else if (!otherSide.equals(other.otherSide))
            return false;
        return true;
    }
}
