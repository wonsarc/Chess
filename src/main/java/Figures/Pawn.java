package Figures;

import Model.ChessBoard;
import Model.ChessPiece;
import Model.Movable;

public class Pawn extends ChessPiece implements Movable {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isMovedOutBoard(toLine, toColumn) || isMovedToCurrent(line, column, toLine, toColumn)) {
            return false;
        }

        int direction = this.getColor().equals("White") ? 1 : -1;

        if (toLine == line + direction && column == toColumn) {
            return chessBoard.board[toLine][toColumn] == null;
        }

        if (toLine == line + 2 * direction && column == toColumn && (line == 1 || line == 6)) {
            return chessBoard.board[line + direction][column] == null && chessBoard.board[toLine][toColumn] == null;
        }

        if (toLine == line + direction && Math.abs(toColumn - column) == 1) {
            ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
            return targetPiece != null && !targetPiece.getColor().equals(this.getColor());
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
