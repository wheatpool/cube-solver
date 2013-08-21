package com.mycom.puzzle.cube.domain;

import static com.mycom.puzzle.cube.util.Constants.EMPTY_CELL_ID;
import static com.mycom.puzzle.cube.util.Constants.FILLED_CELL_ID;
import static com.mycom.puzzle.cube.util.Constants.MAX_CELLS;

/**
 * Class represents one edge of a piece.
 * 
 */
public class Edge {

    private static final int LAST_CHAR_POS = MAX_CELLS - 1;

    /**
     * The pattern representing the edge.
     */
    private final String pattern;

    /**
     * The inverted representation of the edge.
     * (A perfect match for the given edge)
     */
    private final String inverted;

    public Edge(final String pattern) {
        this.pattern = pattern;
        this.inverted = invert(pattern);
    }

    private String invert(String pattern) {
        final char tmp = '#';

        return pattern.replace(EMPTY_CELL_ID, tmp)
                .replace(FILLED_CELL_ID, EMPTY_CELL_ID)
                .replace(tmp, FILLED_CELL_ID);
    }

    /**
     * Checks if the given edge is a match for this edge.
     * 
     * @param edge
     * @return
     */
    public boolean matches(Edge edge) {
        return matchMiddle(edge) && matchCorners(edge);
    }

    private boolean matchCorners(Edge edge) {
        return !(isFirstCornerFilled() && edge.isFirstCornerFilled())
                && !(isSecondCornerFilled() && edge.isSecondCornerFilled());
    }

    private boolean matchMiddle(Edge edge) {
        return getMiddle(pattern).equals(getMiddle(edge.inverted));
    }

    private String getMiddle(String txt) {
        return txt.substring(1, MAX_CELLS - 2);
    }

    public Edge flipSide() {
        return new Edge(new StringBuffer(pattern).reverse().toString());
    }

    private char getFirstCorner() {
        return pattern.charAt(0);
    }

    private char getSecondCorner() {
        return pattern.charAt(LAST_CHAR_POS);
    }

    /**
     * Check if the left corner is filled.
     */
    public boolean isFirstCornerFilled() {
        return getFirstCorner() == FILLED_CELL_ID;
    }

    /**
     * Check if the right corner is filled.
     */
    public boolean isSecondCornerFilled() {
        return getSecondCorner() == FILLED_CELL_ID;
    }

    char getCell(int cellId) {
        return pattern.charAt(cellId);
    }

    @Override
    public String toString() {
        return pattern;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
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
        Edge other = (Edge) obj;
        if (pattern == null) {
            if (other.pattern != null)
                return false;
        } else if (!pattern.equals(other.pattern))
            return false;
        return true;
    }
}
