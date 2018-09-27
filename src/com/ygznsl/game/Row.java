package com.ygznsl.game;

public final class Row extends BoardStructure {

    protected Row(Board board, int x) {
        super(board, x, "x is out of bounds: " + x);
    }

    public int getX() {
        return no;
    }

}