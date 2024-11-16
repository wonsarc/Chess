package Figures;

import Model.ChessBoard;
import Model.ChessPiece;
import Model.Movable;

public class Queen extends ChessPiece implements Movable {

    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isMovedOutBoard(toLine, toColumn) || isMovedToCurrent(line, column, toLine, toColumn)) {
            return false;
        }

        if (line == toLine || column == toColumn || Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            return isPathClear(chessBoard.getBoard(), line, column, toLine, toColumn) &&
                    (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor()));
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
