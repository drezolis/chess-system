package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{
    private Color color;
    private int moveCount;

    // No construtor da classe que herdou, deve conter todos os atributos da classe herdada. Caso eu não tivesse feito esse construtor na classe que herdou (ChessPiece), haveria um erro de compilação por que a superclasse(Piece) não tem um construtor padrão. O programa não conseguiria instanciar a classe ChessPiece justamente por não ter um construtor acessível.
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // Não foi criado o método setColor() pois a cor da peça não deve ser alterada.
    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    protected void increaseMoveCount(){
        moveCount++;
    }

    protected void decreaseMoveCount(){
        moveCount--;
    }
}
