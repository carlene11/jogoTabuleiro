package chess;

import boardGame.Board;
import boardGame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	//Partida de xadrez
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}

	public ChessPiece[][] getPieces(){
		//retorna matriz de xadrez
		//o programa vai conhecer apenas a camada de xadrez, e nao as peças do tabuleiro
		
				
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for(int i =0;i<board.getRows();i++) {
			for (int j = 0; j<board.getColumns();j++) {
			 
				mat[i][j] = (ChessPiece)board.piece(i, j);
				
		
			}
		}
		return mat;
		
	}
	//inicia a partida de xadrez
	private void initialSetup() {
		board.placePiece(new Rook(board,Color.WHITE), new Position(2,1));
		board.placePiece(new King(board,Color.BLACK), new Position(0,4));
		board.placePiece(new King(board,Color.WHITE), new Position(7,4));
	}
}
