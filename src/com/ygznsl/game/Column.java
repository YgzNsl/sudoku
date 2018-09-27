package com.ygznsl.game;

public final class Column extends BoardStructure {

    public Column(Board board, int y) {
        super(board, y, "y is out of bounds: " + y);
    }

    public int getY() {
        return no;
    }

}