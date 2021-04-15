package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
		
		
	}
	
	@Override
	public String toString() {
		return "K";
		
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
	return p == null || p.getColor() != getColor();
		
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position); 
		return p !=null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0; // significa que tem um torre apta para jogada rook
	}
	
	
	
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		
		//above - acima
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// below - abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// left - esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//right - direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// nw = noroeste - diagonal para cima e esquerda
		p.setValues(position.getRow() -1 , position.getColumn() -1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// ne = nordeste - diagonal para direita e acima
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// sw = sudoeste - diagonal para esquerda e abaixo
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// se = sudeste - diagonal para direita e abaixo
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
				
		// #specialmove castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #specialmove castling kingside rook - rook pequeno
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);//posicao possivel da torre do rei
			if(testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);//casa a direita
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);// 2 casas a direita
				if(getBoard().piece(p1)==null && getBoard().piece(p2)==null){
					//posso fazer o roque
					mat[position.getRow()][position.getColumn()+2] = true;
					
				}
				
			}
			// #specialmove castling queenside rook - roque grande
			Position posT2 = new Position(position.getRow(), position.getColumn() -4);//posicao possivel da torre do rei
			if(testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() -1);//casa a esquerda
				Position p2 = new Position(position.getRow(), position.getColumn() -2);// 2 casas a esquerda
				Position p3 = new Position(position.getRow(), position.getColumn() -3);// 3 casas a esquerda
				if(getBoard().piece(p1)==null && getBoard().piece(p2)==null && getBoard().piece(p3) == null){
					//posso fazer o roque
					mat[position.getRow()][position.getColumn()-2] = true;
								
				}
							
			}
		}
		
		
		return mat;
	}
	

	
}
