package com.velyhotskiy;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class BoardConsoleRenderer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public void render(Board board) {
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                line += getSpriteForTheEmptyLine(new Coordinates(file, rank));
                /*System.out.println(file + String.valueOf(rank));*/
            }

            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    @Contract(pure = true)
    private @NotNull String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark) {
        // format = background color + font color + text
        String result = sprite;
        if(pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if(isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }
        return result;
    }

    private @NotNull String getSpriteForTheEmptyLine(Coordinates coordinates) {
        return colorizeSprite("   ", Color.WHITE, Board.isSquareDark(coordinates));
    }
}
