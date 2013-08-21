package com.mycom.puzzle.cube.util;

public class Constants {

    /**
     * Maximum number of cells in a row in a piece.
     */
    public static final int MAX_CELLS = 5;

    /**
     * Character representing an empty cell.
     */
    public static final char EMPTY_CELL_ID = ' ';

    /**
     * Character representing an filled cell.
     */
    public static final char FILLED_CELL_ID = 'o';

    private static String PIECE_BODY = null;

    private Constants() {

    }

    /**
     * Reverse the given string.
     */
    public static String reverse(String txt) {
        StringBuilder sb = new StringBuilder(txt);
        return sb.reverse().toString();
    }

    /**
     * Create a String with the given character repeated the given number of times.
     */
    public static String repeate(char ch, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * The middle part of a piece.
     */
    public static String getBody() {
        if (PIECE_BODY == null) {
            PIECE_BODY = repeate(FILLED_CELL_ID, (MAX_CELLS - 2));
        }

        return PIECE_BODY;
    }
}
