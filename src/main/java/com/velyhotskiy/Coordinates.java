package com.velyhotskiy;

public class Coordinates {

    public final File file; // the vertical lines on the chessboard are called files
    public final Integer rank; // the horizontal lines are called ranks

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (file != that.file) return false;
        return rank.equals(that.rank);
    }

    @Override
    public int hashCode() {
        int result = file.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }
}
