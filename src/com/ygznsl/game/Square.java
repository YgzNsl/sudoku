package com.ygznsl.game;

public final class Square extends BoardStructure {

    public Square(Board board, int no) {
        super(board, no, "Square number is out of bounds: " + no);
    }

    public int getNo() {
        return no;
    }

}