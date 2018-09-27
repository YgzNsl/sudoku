package com.ygznsl;

import com.ygznsl.game.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

public final class BoardUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Parent createUI() {
        final HashMap<Position, TextField> textFields = new HashMap<>();
        final GridPane grid = new GridPane();

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                final TextField txt = new TextField();
                txt.setEditable(false);
                txt.setPrefWidth(40d);
                txt.setPrefHeight(40d);
                txt.setAlignment(Pos.CENTER);
                txt.setFont(new Font(16d));

                grid.add(txt, y, x);
                textFields.put(Position.create(x + 1, y + 1), txt);
            }
        }

        final Button btnFill = new Button("Doldur");
        btnFill.setPrefWidth(160d);

        grid.add(btnFill, 0, 9);

        GridPane.setMargin(btnFill, new Insets(10d, 0d, 10d, 0d));
        GridPane.setColumnSpan(btnFill, 4);

        btnFill.setOnAction(e -> {
            final CellValueChangedEventHandler eventHandler = (position, oldValue, newValue) -> {
                final TextField txt = textFields.get(position);
                if (txt != null) {
                    Platform.runLater(() -> txt.setText(Optional.ofNullable(newValue).map(String::valueOf).orElse("")));
                }
            };

            btnFill.setDisable(true);

            new Thread(() -> {
                final Board board = new Board(eventHandler);

                for (int x = 1; x <= 9; x++) {
                    final Row row = board.getRow(x);
                    final Cell[] cells = row.getCells();

                    for (int y = 1; y <= 9; y++) {
                        final TextField txt = textFields.get(Position.create(x, y));
                        final Cell cell = cells[y - 1];

                        if (txt != null) {
                            Platform.runLater(() -> txt.setText(Optional.ofNullable(cell.getValue()).map(String::valueOf).orElse("")));
                        }
                    }
                }

                Platform.runLater(() -> btnFill.setDisable(false));
            }).start();
        });

        return grid;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createUI(), 360d, 400d));
        primaryStage.setResizable(false);
        primaryStage.setTitle("SUDOKU");
        primaryStage.show();
    }

}