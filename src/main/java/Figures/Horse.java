package Figures;

import Model.ChessBoard;
import Model.ChessPiece;
import Model.Movable;

public class Horse extends ChessPiece implements Movable {

    final int[][] MOVES = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isMovedOutBoard(toLine, toColumn) || isMovedToCurrent(line, column, toLine, toColumn)) {
            return false;
        }

        for (int[] move : MOVES) {
            int newLine = line + move[0];
            int newColumn = column + move[1];
            if (newLine == toLine && newColumn == toColumn) {
                ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
                return targetPiece == null || !targetPiece.getColor().equals(this.getColor());
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}

