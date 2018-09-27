package com.ygznsl;

import com.ygznsl.game.Game;

import java.io.*;

public final class GameGenerator {

    private static final File OUTPUT_DIRECTORY = new File(System.getProperty("user.dir"), "games");

    static {
        if (!OUTPUT_DIRECTORY.exists() && !OUTPUT_DIRECTORY.mkdir())
            System.out.println("Output directory could not be created.");
    }

    private GameGenerator() {
    }

    public static void main(String[] args) throws IOException {
        for (Game.Level level : Game.Level.values()) {
            for (int i = 1; i <= 25; i++) {
                System.out.println(String.format("%s_%d", level, i));

                final Game game = new Game(level);

                try (
                        FileOutputStream fos = new FileOutputStream(new File(OUTPUT_DIRECTORY, String.format("%s_%d.dat", level, i)));
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
                        ObjectOutputStream oos = new ObjectOutputStream(bos)
                ) {
                    oos.writeObject(game);
                    oos.flush();
                }
            }
        }
    }

}