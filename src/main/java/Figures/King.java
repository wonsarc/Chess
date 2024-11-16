package Figures;

import Model.ChessBoard;
import Model.ChessPiece;
import Model.Movable;

public class King extends ChessPiece implements Movable {

    public King(String color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        String opponentColor = super.getColor().equals("White") ? "Black" : "White";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = chessBoard.getBoard()[i][j];
                if (piece != null && piece.getColor().equals(opponentColor)) {
                    if (piece.canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isMovedOutBoard(toLine, toColumn) || isMovedToCurrent(line, column, toLine, toColumn)) {
            return false;
        }

        if (Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1) {
            ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
            return targetPiece == null || !targetPiece.getColor().equals(this.getColor());
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
