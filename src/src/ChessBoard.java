public abstract class ChessBoard {

    int boxCoordinates;

    ChessBoard(int boxCoordinates) {
        this.boxCoordinates = boxCoordinates;
    }

    public abstract boolean isBoxOccupied();

    public abstract ChessPiece getChessPiece();

    public static final class Empty extends ChessBoard{

        Empty(int coordinates){
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

        ChessPiece piece;

        OccupiedBox(int boxCoordinates, ChessPiece piece){
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
