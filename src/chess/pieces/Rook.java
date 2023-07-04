package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        for (int i = -1; i < 2; i++) {
            if (i == 0) continue;

            p.setValue(position.getRow() + i, position.getColumn());
            while (getBoard().positionExists(p) && canMove(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setRow(p.getRow() + i);
            }
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

            for (int j = -1; j < 2; j++) {
                if (j == 0) continue;

                p.setValue(position.getRow(), position.getColumn() + j);
                while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setColumn(p.getColumn() + j);
                }
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
        return mat;
    }
}
