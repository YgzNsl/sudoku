package com.ygznsl.game;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Board {

    protected static final HashMap<Integer, Position> SQUARE_STARTING_POSITIONS = new HashMap<>();

    protected static final HashMap<Integer, List<Position>> SQUARE_POSITIONS = new HashMap<>();

    static {
        SQUARE_STARTING_POSITIONS.put(1, Position.create(1, 1));
        SQUARE_STARTING_POSITIONS.put(2, Position.create(1, 4));
        SQUARE_STARTING_POSITIONS.put(3, Position.create(1, 7));
        SQUARE_STARTING_POSITIONS.put(4, Position.create(4, 1));
        SQUARE_STARTING_POSITIONS.put(5, Position.create(4, 4));
        SQUARE_STARTING_POSITIONS.put(6, Position.create(4, 7));
        SQUARE_STARTING_POSITIONS.put(7, Position.create(7, 1));
        SQUARE_STARTING_POSITIONS.put(8, Position.create(7, 4));
        SQUARE_STARTING_POSITIONS.put(9, Position.create(7, 7));

        for (int i = 1; i <= 9; i++) {
            SQUARE_POSITIONS.put(i, new ArrayList<>(9));
        }

        SQUARE_POSITIONS.get(1).add(Position.create(1, 1));
        SQUARE_POSITIONS.get(1).add(Position.create(1, 2));
        SQUARE_POSITIONS.get(1).add(Position.create(1, 3));
        SQUARE_POSITIONS.get(1).add(Position.create(2, 1));
        SQUARE_POSITIONS.get(1).add(Position.create(2, 2));
        SQUARE_POSITIONS.get(1).add(Position.create(2, 3));
        SQUARE_POSITIONS.get(1).add(Position.create(3, 1));
        SQUARE_POSITIONS.get(1).add(Position.create(3, 2));
        SQUARE_POSITIONS.get(1).add(Position.create(3, 3));
        SQUARE_POSITIONS.get(2).add(Position.create(1, 4));
        SQUARE_POSITIONS.get(2).add(Position.create(1, 5));
        SQUARE_POSITIONS.get(2).add(Position.create(1, 6));
        SQUARE_POSITIONS.get(2).add(Position.create(2, 4));
        SQUARE_POSITIONS.get(2).add(Position.create(2, 5));
        SQUARE_POSITIONS.get(2).add(Position.create(2, 6));
        SQUARE_POSITIONS.get(2).add(Position.create(3, 4));
        SQUARE_POSITIONS.get(2).add(Position.create(3, 5));
        SQUARE_POSITIONS.get(2).add(Position.create(3, 6));
        SQUARE_POSITIONS.get(3).add(Position.create(1, 7));
        SQUARE_POSITIONS.get(3).add(Position.create(1, 8));
        SQUARE_POSITIONS.get(3).add(Position.create(1, 9));
        SQUARE_POSITIONS.get(3).add(Position.create(2, 7));
        SQUARE_POSITIONS.get(3).add(Position.create(2, 8));
        SQUARE_POSITIONS.get(3).add(Position.create(2, 9));
        SQUARE_POSITIONS.get(3).add(Position.create(3, 7));
        SQUARE_POSITIONS.get(3).add(Position.create(3, 8));
        SQUARE_POSITIONS.get(3).add(Position.create(3, 9));
        SQUARE_POSITIONS.get(4).add(Position.create(4, 1));
        SQUARE_POSITIONS.get(4).add(Position.create(4, 2));
        SQUARE_POSITIONS.get(4).add(Position.create(4, 3));
        SQUARE_POSITIONS.get(4).add(Position.create(5, 1));
        SQUARE_POSITIONS.get(4).add(Position.create(5, 2));
        SQUARE_POSITIONS.get(4).add(Position.create(5, 3));
        SQUARE_POSITIONS.get(4).add(Position.create(6, 1));
        SQUARE_POSITIONS.get(4).add(Position.create(6, 2));
        SQUARE_POSITIONS.get(4).add(Position.create(6, 3));
        SQUARE_POSITIONS.get(5).add(Position.create(4, 4));
        SQUARE_POSITIONS.get(5).add(Position.create(4, 5));
        SQUARE_POSITIONS.get(5).add(Position.create(4, 6));
        SQUARE_POSITIONS.get(5).add(Position.create(5, 4));
        SQUARE_POSITIONS.get(5).add(Position.create(5, 5));
        SQUARE_POSITIONS.get(5).add(Position.create(5, 6));
        SQUARE_POSITIONS.get(5).add(Position.create(6, 4));
        SQUARE_POSITIONS.get(5).add(Position.create(6, 5));
        SQUARE_POSITIONS.get(5).add(Position.create(6, 6));
        SQUARE_POSITIONS.get(6).add(Position.create(4, 7));
        SQUARE_POSITIONS.get(6).add(Position.create(4, 8));
        SQUARE_POSITIONS.get(6).add(Position.create(4, 9));
        SQUARE_POSITIONS.get(6).add(Position.create(5, 7));
        SQUARE_POSITIONS.get(6).add(Position.create(5, 8));
        SQUARE_POSITIONS.get(6).add(Position.create(5, 9));
        SQUARE_POSITIONS.get(6).add(Position.create(6, 7));
        SQUARE_POSITIONS.get(6).add(Position.create(6, 8));
        SQUARE_POSITIONS.get(6).add(Position.create(6, 9));
        SQUARE_POSITIONS.get(7).add(Position.create(7, 1));
        SQUARE_POSITIONS.get(7).add(Position.create(7, 2));
        SQUARE_POSITIONS.get(7).add(Position.create(7, 3));
        SQUARE_POSITIONS.get(7).add(Position.create(8, 1));
        SQUARE_POSITIONS.get(7).add(Position.create(8, 2));
        SQUARE_POSITIONS.get(7).add(Position.create(8, 3));
        SQUARE_POSITIONS.get(7).add(Position.create(9, 1));
        SQUARE_POSITIONS.get(7).add(Position.create(9, 2));
        SQUARE_POSITIONS.get(7).add(Position.create(9, 3));
        SQUARE_POSITIONS.get(8).add(Position.create(7, 4));
        SQUARE_POSITIONS.get(8).add(Position.create(7, 5));
        SQUARE_POSITIONS.get(8).add(Position.create(7, 6));
        SQUARE_POSITIONS.get(8).add(Position.create(8, 4));
        SQUARE_POSITIONS.get(8).add(Position.create(8, 5));
        SQUARE_POSITIONS.get(8).add(Position.create(8, 6));
        SQUARE_POSITIONS.get(8).add(Position.create(9, 4));
        SQUARE_POSITIONS.get(8).add(Position.create(9, 5));
        SQUARE_POSITIONS.get(8).add(Position.create(9, 6));
        SQUARE_POSITIONS.get(9).add(Position.create(7, 7));
        SQUARE_POSITIONS.get(9).add(Position.create(7, 8));
        SQUARE_POSITIONS.get(9).add(Position.create(7, 9));
        SQUARE_POSITIONS.get(9).add(Position.create(8, 7));
        SQUARE_POSITIONS.get(9).add(Position.create(8, 8));
        SQUARE_POSITIONS.get(9).add(Position.create(8, 9));
        SQUARE_POSITIONS.get(9).add(Position.create(9, 7));
        SQUARE_POSITIONS.get(9).add(Position.create(9, 8));
        SQUARE_POSITIONS.get(9).add(Position.create(9, 9));
    }

    private final Cell[][] cells = new Cell[9][9];
    private final HashMap<Integer, Row> rows = new HashMap<>(9);
    private final HashMap<Integer, Column> columns = new HashMap<>(9);
    private final HashMap<Integer, Square> squares = new HashMap<>(9);

    public Board() {
        this(null);
    }

    public Board(CellValueChangedEventHandler onValueChanged) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                final Cell cell = new Cell(x + 1, y + 1);
                cell.setOnValueChanged(onValueChanged);

                cells[x][y] = cell;
            }
        }

        setRows();
        setColumns();
        setSquares();

        fill();
    }

    private void setRows() {
        for (int r = 1; r <= 9; r++) {
            final Row row = new Row(this, r);

            for (int y = 0; y < 9; y++) {
                row.add(cells[r - 1][y]);
            }

            row.sort();
            rows.put(r, row);
        }
    }

    private void setColumns() {
        for (int c = 1; c <= 9; c++) {
            final Column col = new Column(this, c);

            for (int x = 0; x < 9; x++) {
                col.add(cells[x][c - 1]);
            }

            col.sort();
            columns.put(c, col);
        }
    }

    private void setSquares() {
        for (int s = 1; s <= 9; s++) {
            final Position starting = SQUARE_STARTING_POSITIONS.get(s);
            final Square square = new Square(this, s);

            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    square.add(cells[starting.getX() - 1 + x][starting.getY() - 1 + y]);
                }
            }

            square.sort();
            squares.put(s, square);
        }
    }

    public Row getRow(int row) {
        if (row < 1 || row > 9)
            throw new IllegalArgumentException("Row number is out of bounds: " + row);

        return rows.get(row);
    }

    public Column getColumn(int column) {
        if (column < 1 || column > 9)
            throw new IllegalArgumentException("Column number is out of bounds: " + column);

        return columns.get(column);
    }

    public Square getSquare(int square) {
        if (square < 1 || square > 9)
            throw new IllegalArgumentException("Square number is out of bounds: " + square);

        return squares.get(square);
    }

    private void fill() {
        final Random random = new Random();
        final HashMap<Position, HashSet<Integer>> tried = new HashMap<>();
        final List<Integer> allNumbers = IntStream
                .range(1, 10)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                try {
                    Thread.sleep(250L);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                final Cell cell = cells[x][y];
                final HashSet<Integer> alreadyTried = tried.computeIfAbsent(cell.getPosition(), k -> new HashSet<>());

                final Row row = getRow(cell.row());
                final Column column = getColumn(cell.column());
                final Square square = getSquare(cell.square());

                final List<Integer> numbers = setDifference(setIntersect(
                        setDifference(allNumbers, row.usedNumbers()),
                        setDifference(allNumbers, column.usedNumbers()),
                        setDifference(allNumbers, square.usedNumbers())
                ), alreadyTried);

                if (numbers.isEmpty()) {
                    cell.setValue(null);

                    y -= 2;

                    if (y < 0) {
                        y = 7;

                        x--;
                        if (x < 0)
                            x = 0;
                    }

                    if (!alreadyTried.isEmpty())
                        alreadyTried.clear();
                } else {
                    final int index = random.nextInt(numbers.size());
                    final int number = numbers.get(index);

                    alreadyTried.add(number);
                    cell.setValue(number);
                }
            }
        }
    }

    @Override
    public String toString() {
        final Function<Cell[], String> rowToString = arr -> Arrays
                .stream(arr)
                .map(Cell::getValue)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        return Arrays
                .stream(cells, 0, 9)
                .map(rowToString)
                .collect(Collectors.joining("\r\n"));
    }

    private static <T> List<T> setDifference(Collection<T> set, Collection<T> exclude) {
        return set
                .stream()
                .filter(t -> !exclude.contains(t))
                .collect(Collectors.toList());
    }

    private static <T> List<T> setIntersect(Collection<T>... collections) {
        if (collections.length == 0)
            return Collections.emptyList();

        if (collections.length == 1)
            return new ArrayList<>(collections[0]);

        final ArrayList<T> list = new ArrayList<>(collections[0].size());
        for (T t : collections[0]) {
            boolean b = true;

            for (int i = 1; i < collections.length; i++) {
                if (!collections[i].contains(t)) {
                    b = false;
                    break;
                }
            }

            if (b) {
                list.add(t);
            }
        }

        list.trimToSize();
        return list;
    }

}