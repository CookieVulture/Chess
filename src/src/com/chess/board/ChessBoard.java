
package com.chess.board;

import com.chess.piece.ChessPiece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/*
Date - 21st May, 2020
Author - Dhairya Patel
Module - ChessBoard
Info - The Chess Board implementation.
*/

public abstract class ChessBoard {

    protected final int boxCoordinates; //Not allowed to change once set

    private static final Map<Integer, Empty> EMPTY_MAP = allPossibleTiles();

    private static Map<Integer, Empty> allPossibleTiles() {

        final Map<Integer, Empty> tileMap = new HashMap<>();

        for (int i=0; i<64; i++){
            tileMap.put(i, new Empty(i));
        }

        return ImmutableMap.copyOf(tileMap);
    }

    public static ChessBoard newBoard(final int boxCoordinates, final ChessPiece chessPiece){
        return chessPiece != null ? new OccupiedBox(boxCoordinates, chessPiece) : EMPTY_MAP.get(boxCoordinates);
    }

    private ChessBoard(int boxCoordinates) {
        this.boxCoordinates = boxCoordinates;
    }

    public abstract boolean isBoxOccupied();

    public abstract ChessPiece getChessPiece();

    public static final class Empty extends ChessBoard{

        private Empty(final int coordinates){
            super(coordinates);
        }

        @Override
        public boolean isBoxOccupied(){
            return false;        // Return True if tile is not empty
        }

        @Override
        public ChessPiece getChessPiece(){
            return null;            //Return null if no chess piece available
        }
    }

    public static final class OccupiedBox extends ChessBoard{

        private final ChessPiece piece;

        private OccupiedBox(int boxCoordinates, ChessPiece piece){
            super(boxCoordinates);
            this.piece = piece;
        }

        @Override
        public boolean isBoxOccupied(){
            return true;        // Return True if tile is not empty
        }

        @Override
        public ChessPiece getChessPiece(){
            return this.piece;            //Return null if no chess piece available
        }
    }
}
