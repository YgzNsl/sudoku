package com.ygznsl.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public final class Game implements Serializable {

    private final Level level;
    private Board board = null;
    private ArrayList<Position> openCells = null;

    public Game(Level level) {
        this.level = Objects.requireNonNull(level, "Game.Level is null");

        createBoard();
    }

    private void createBoard() {
        board = new Board();

        final List<Position> allPositions = new ArrayList<>(81);
        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y <= 9; y++) {
                allPositions.add(Position.create(x, y));
            }
        }

        openCells = new ArrayList<>(level.getOpenCells());

        final Random random = new Random();
        for (int i = 0; i < level.getOpenCells(); i++) {
            final int index = random.nextInt(allPositions.size());
            openCells.add(allPositions.get(index));
            allPositions.remove(index);
        }

        allPositions.clear();
    }

    public Level getLevel() {
        return level;
    }

    public enum Level {
        EASY(27),
        MEDIUM(20),
        HARD(15),
        ;

        private final int openCells;

        Level(int openCells) {
            this.openCells = openCells;
        }

        public int getOpenCells() {
            return openCells;
        }

    }

}