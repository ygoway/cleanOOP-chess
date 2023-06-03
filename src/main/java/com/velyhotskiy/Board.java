package com.velyhotskiy;

import com.velyhotskiy.figures.Pawn;
import com.velyhotskiy.figures.Piece;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Board {

    HashMap<Coordinates, Piece> boardPieces = new HashMap<>();

    public void setPiece(Coordinates coordinates, @NotNull Piece piece) {
        piece.coordinates = coordinates;
        boardPieces.put(coordinates, piece);
    }

    public void setupDefaultPiecesPositions() {
        for(File file : File.values()) {
            setPiece(new Coordinates(file, 2), new Pawn(Color.WHITE, new Coordinates(file, 2)));
            setPiece(new Coordinates(file, 7), new Pawn(Color.BLACK, new Coordinates(file, 7)));
        }
    }

    @Contract(pure = true)
    public static boolean isSquareDark(@NotNull Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }
}
