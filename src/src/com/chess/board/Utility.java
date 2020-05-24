package com.chess.board;

public class Utility {

    private Utility(){
        throw new RuntimeException("Out of bounds!");
    }
    public static boolean isValidBox(int Coordinates) {
        return Coordinates >= 0 && Coordinates < 64;
    }
}
