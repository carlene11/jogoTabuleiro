package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;


public class Bishop extends ChessPiece{

	public Bishop(Board board, Color color) {
		super(board, color);
	
	}

	@Override	
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		
		//nw - noroesteabove e left -acima e esquerda 
		p.setValues(position.getRow() - 1, position.getColumn() -1);
		while(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]= true; //ou seja pode mover a pe�a para a posi��o acima
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// ne - nordeste 
		p.setValues(position.getRow() -1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true; // ou seja pode mover a pe�a para a posi��o acima
			p.setValues(p.getRow() - 1, p.getColumn() +1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// se - sudeste
		p.setValues(position.getRow() +1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true; // ou seja pode mover a pe�a para a posi��o acima
			p.setValues(p.getRow() +1, p.getColumn() +1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// su - sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true; // ou seja pode mover a pe�a para a posi��o acima
			p.setValues(p.getRow() +1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
				
		return mat;
	}
	
	
}
