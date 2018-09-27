package com.ygznsl.game;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Cell implements Serializable, Comparable<Cell> {

    private final Position position;
    private Integer value = null;
    private CellValueChangedEventHandler onValueChanged = null;

    public Cell(int x, int y) {
        this(x, y, null);
    }

    public Cell(int x, int y, Integer value) {
        this(Position.create(x, y), value);
    }

    public Cell(Position position) {
        this(position, null);
    }

    public Cell(Position position, Integer value) {
        this.position = Objects.requireNonNull(position, "Position is null");
        setValue(value, false);
    }

    public Position getPosition() {
        return position;
    }

    public Integer getValue() {
        return value;
    }

    private void setValue(Integer value, boolean fireEvent) {
        if (value != null && (value < 1 || value > 9))
            throw new IllegalArgumentException("Value is out of bounds: " + value);

        final Integer oldValue = this.value;
        this.value = value;

        if (fireEvent && onValueChanged != null) {
            onValueChanged.changed(position, oldValue, this.value);
        }
    }

    protected void setValue(Integer value) {
        setValue(value, true);
    }

    public CellValueChangedEventHandler getOnValueChanged() {
        return onValueChanged;
    }

    public void setOnValueChanged(CellValueChangedEventHandler onValueChanged) {
        this.onValueChanged = onValueChanged;
    }

    public int row() {
        return position.getX();
    }

    public int column() {
        return position.getY();
    }

    public int square() {
        for (Map.Entry<Integer, List<Position>> entry : Board.SQUARE_POSITIONS.entrySet())
            if (entry.getValue().contains(position))
                return entry.getKey();

        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Cell cell = (Cell) o;
        return Objects.equals(position, cell.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "position=" + position +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Cell o) {
        return Position.compare(position, o.position);
    }

}