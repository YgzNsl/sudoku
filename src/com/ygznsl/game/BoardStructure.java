package com.ygznsl.game;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class BoardStructure implements Serializable, Comparable<BoardStructure> {

    protected final ArrayList<Cell> cells = new ArrayList<>(9);
    protected final Board board;
    protected final int no;

    protected BoardStructure(Board board, int no, String errorMessage) {
        this.board = Objects.requireNonNull(board, "Board is null");

        if (no < 1 || no > 9)
            throw new IllegalArgumentException(errorMessage);

        this.no = no;
    }

    public final Board getBoard() {
        return board;
    }

    protected final void add(Cell cell) {
        cells.add(cell);
    }

    protected final void sort() {
        cells.sort(Comparator.naturalOrder());
    }

    public final Cell[] getCells() {
        return cells.toArray(new Cell[9]);
    }

    public final int size() {
        return cells.size();
    }

    public final boolean isEmpty() {
        return cells.isEmpty();
    }

    public final boolean isOkay() {
        final int[] array1 = cells
                .stream()
                .map(Cell::getValue)
                .filter(Objects::nonNull)
                .mapToInt(i -> i)
                .sorted()
                .toArray();

        final int[] array2 = IntStream
                .range(1, 10)
                .sorted()
                .toArray();

        return Arrays.equals(array1, array2);
    }

    protected final List<Integer> usedNumbers() {
        return cells
                .stream()
                .map(Cell::getValue)
                .filter(Objects::nonNull)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BoardStructure that = (BoardStructure) o;
        return no == that.no && Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, no);
    }

    @Override
    public final int compareTo(BoardStructure o) {
        return Integer.compare(no, o.no);
    }

}