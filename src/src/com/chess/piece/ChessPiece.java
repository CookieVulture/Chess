package com.chess.piece;
import com.chess.board.Board;
import com.chess.board.Move;
import com.chess.colorGroup;
import java.util.List;

/*
Date - 21st May, 2020
Author - Dhairya Patel
Module - ChessPiece
Info - The Chess Piece implementation.
*/


public abstract class ChessPiece {

    protected final int position;
    protected final colorGroup pieceColor;

    ChessPiece(final int position, final colorGroup pieceColor){
        this.position = position;
        this.pieceColor = pieceColor;
    }

    public abstract List<Move> legalMoves(final Board board);
}
