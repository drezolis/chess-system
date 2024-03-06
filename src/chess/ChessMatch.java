package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    // Conceito importante de composição. Basicamente significa "uma partida de
    // xadrez (ChessMatch) TEM UM tabuleiro (Board)"
    private Board board;

    public int turn;
    public Color currentPlayer;
    public boolean check;
    public boolean checkMate;
    public ChessPiece enPassantVulnerable;
    public ChessPiece promoted;

    // No construtor para instanciar uma partida de xadrez, há também a instanciação
    // de um novo tabuleiro com o tamanho 8x8 pré estabelecido. A classe ChessMatch
    // é responsável por "saber" o tamanho do tabuleiro.
    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        // Instanciação de uma matriz de objetos "ChessPiece" com base nas dimensões do
        // tabuleiro (Board).
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColums()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColums(); j++) {
                // Downcasting para o programa interpretar como uma peça de xadrez (ChessPiece)
                // e não como uma peça comum (Piece).
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void initialSetup() {
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
    }
}
