package com.ygznsl.game;

import java.io.Serializable;
import java.util.Objects;

public final class Position implements Serializable, Comparable<Position> {

    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    @Override
    public int compareTo(Position o) {
        return x != o.x
                ? Integer.compare(x, o.x)
                : Integer.compare(y, o.y);
    }

    public static Position create(int x, int y) {
        if (x < 1 || x > 9)
            throw new IllegalArgumentException("x is out of bounds: " + x);

        if (y < 1 || y > 9)
            throw new IllegalArgumentException("y is out of bounds: " + y);

        return new Position(x, y);
    }

    public static int compare(Position p1, Position p2) {
        return p1.compareTo(p2);
    }

}