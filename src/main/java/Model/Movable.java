package Model;

public interface Movable {

    default boolean isMovedToCurrent(int line, int column, int toLine, int toColumn) {
        return line == toLine && column == toColumn;
    }

    default boolean isMovedOutBoard(int toLine, int toColumn) {
        return toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8;
    }

    default boolean isPathClear(ChessPiece[][] board, int startLine, int startColumn, int endLine, int endColumn) {
        int stepLine = Integer.compare(endLine, startLine);
        int stepColumn = Integer.compare(endColumn, startColumn);

        int currentLine = startLine + stepLine;
        int currentColumn = startColumn + stepColumn;

        while (currentLine != endLine || currentColumn != endColumn) {
            if (board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += stepLine;
            currentColumn += stepColumn;
        }
        return true;
    }
}
