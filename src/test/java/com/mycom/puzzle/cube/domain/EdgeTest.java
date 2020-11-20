package com.mycom.puzzle.cube.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EdgeTest {

    @Test
    public void testEdge() {
        Edge edge1 = new Edge(" oo o");
        Edge edge2 = new Edge("o  o ");

        assertTrue(edge1.matches(edge2));
    }
}
