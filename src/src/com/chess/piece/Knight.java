package com.chess.piece;

import com.chess.board.Board;
import com.chess.board.ChessBoard;
import com.chess.board.Move;
import com.chess.board.Utility;
import com.chess.colorGroup;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece{

    // Board is made of 64 squares and if move is possible then Knight can move currentSquare + one of the possible move.
    // The cases where it is not possible is either there is friendly piece or that square is out of bounds.
    // For example, 3-17 doesn't make any sense.
    private final static int[] possibleMove = { -17, -15, -10, -6, 6, 10, 15, 17};

    Knight(int position, colorGroup pieceColor) {
        super(position, pieceColor);
    }


    /**
     * LegalMoves
     *
     * @param board
     * @return List of legal moves
     */
    @Override
    public List<Move> legalMoves(Board board) {
        int moveCoordinates;
        final List<Move> legalMove = new ArrayList<>();

        for (final int move:possibleMove){
            moveCoordinates = this.position + move;

            if (Utility.isValidBox(moveCoordinates)){

                final ChessBoard newSquare = board.getTile(moveCoordinates);
                if (!newSquare.isBoxOccupied()){legalMove.add(new Move());}
                else{
                    final ChessPiece occupiedPiece = newSquare.getChessPiece();
                    final colorGroup occupiedColor = occupiedPiece.getPieceColor();

                    if (this.pieceColor!=occupiedColor){legalMove.add(new Move());}
                }


            }
        }

        return ImmutableList.copyOf(legalMove);
    }

}
