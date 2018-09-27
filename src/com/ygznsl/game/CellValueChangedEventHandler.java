package com.ygznsl.game;

public interface CellValueChangedEventHandler {
    void changed(Position position, Integer oldValue, Integer newValue);
}