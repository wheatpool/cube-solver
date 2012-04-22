package com.mycom.puzzle.cube.domain;

import static com.mycom.puzzle.cube.util.Constants.MAX_CELLS;
import static com.mycom.puzzle.cube.util.Constants.getBody;

/**
 * The class representing the actual side of a piece.
 * A side has four edges.
 * 
 */
public class SideImpl implements Side {

    private final String name;

    protected Edge left;

    protected Edge top;

    protected Edge right;

    protected Edge bottom;

    public SideImpl(String name, String[] rows) {
        this.name = name;
        this.top = new Edge(rows[0]);
        this.bottom = new Edge(rows[MAX_CELLS - 1]);
        this.left = createLeftEdge(rows);
        this.right = createRightEdge(rows);
    }

    private SideImpl(String name) {
        this.name = name;
    }

    /**
     * Creates the opposite side of this side.
     */
    public Side createFlipSide(String name) {
        SideImpl side = new SideImpl(name);
        side.top = this.top.flipSide();
        side.bottom = this.bottom.flipSide();
        side.left = this.right;
        side.right = this.left;

        return side;
    }

    private Edge createLeftEdge(String[] rows) {
        final StringBuffer sb = new StringBuffer();

        for (String string : rows) {
            sb.append(string.charAt(0));
        }
        return new Edge(sb.toString());
    }

    private Edge createRightEdge(String[] rows) {
        final StringBuffer sb = new StringBuffer();

        for (String string : rows) {
            sb.append(string.charAt(MAX_CELLS - 1));
        }
        return new Edge(sb.toString());
    }

    public void rotateRight() {
        Edge tmp = this.top;
        this.top = this.left.flipSide();
        this.left = this.bottom;
        this.bottom = this.right.flipSide();
        this.right = tmp;
    }

    public void rotateLeft() {
        Edge tmp = this.top;
        this.top = this.right;
        this.right = this.bottom.flipSide();
        this.bottom = this.left;
        this.left = tmp.flipSide();
    }

    public Edge getTopEdge() {
        return top;
    }

    public Edge getLeftEdge() {
        return left;
    }

    public Edge getRightEdge() {
        return right;
    }

    public Edge getBottomEdge() {
        return bottom;
    }

    @Override
    public String[] getTextRepresentation() {
        String[] result = new String[MAX_CELLS];
        result[0] = top.toString();
        for (int i = 1; i < MAX_CELLS - 1; i++) {
            StringBuilder sb = new StringBuilder(MAX_CELLS);
            sb.append(left.getCell(i));
            sb.append(getBody());
            sb.append(right.getCell(i));
            result[i] = sb.toString();
        }
        result[MAX_CELLS - 1] = bottom.toString();
        return result;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bottom == null) ? 0 : bottom.hashCode());
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        result = prime * result + ((top == null) ? 0 : top.hashCode());
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
        SideImpl other = (SideImpl) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (bottom == null) {
            if (other.bottom != null)
                return false;
        } else if (!bottom.equals(other.bottom))
            return false;
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (right == null) {
            if (other.right != null)
                return false;
        } else if (!right.equals(other.right))
            return false;
        if (top == null) {
            if (other.top != null)
                return false;
        } else if (!top.equals(other.top))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name + " [left=" + left + ", top=" + top
                + ", right=" + right + ", bottom=" + bottom + "]";
    }
}
