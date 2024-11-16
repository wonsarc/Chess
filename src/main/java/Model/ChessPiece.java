package Model;

public abstract class ChessPiece {

    String color;
    boolean check;

    public ChessPiece(String color) {
        this.color = color;
        check = true;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();
}
