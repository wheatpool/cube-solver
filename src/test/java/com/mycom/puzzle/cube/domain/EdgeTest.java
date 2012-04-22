package com.mycom.puzzle.cube.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EdgeTest {

    @Test
    public void testEdge() {
        Edge edge1 = new Edge(" oo o");
        Edge edge2 = new Edge("o  o ");

        assertTrue(edge1.matches(edge2));
    }
}
