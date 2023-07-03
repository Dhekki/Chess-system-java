package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        //position é automáticamente nula quando não é atribuído nada
    }

    protected Board getBoard() {
        return board;
    }
}
