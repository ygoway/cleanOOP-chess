package com.velyhotskiy.figures;

import com.velyhotskiy.Color;
import com.velyhotskiy.Coordinates;

abstract public class Piece {

    public final Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}
