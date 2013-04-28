package org.assigment2.model;

import javax.jws.soap.SOAPBinding;

public class Board {
	private static final int ROWS = 15;
	private static final int COLUMNS = 15;
	private static String[][] board;
	private Stone stone;
	
	public Board() {
		// TODO Auto-generated constructor stub
		board = new String[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				board[i][j] = "-";
			}
		}
	}

	public String[][] getBoard() {
		return board;
	}

	public void drawBoard() {
		// TODO Auto-generated method stub
	
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	


	public void setBoard(int x, int y, Player player) {
		// TODO Auto-generated method stub
		
		if(player.getName().equalsIgnoreCase("BLACK")) {
			stone = new BlackStone(x, y);
			board[x][y] = stone.getType();
		} else if (player.getName().equalsIgnoreCase("WHITE")) {
			stone = new WhiteStone(x, y);
			board[x][y] = stone.getType();
		}
	}

	public boolean hasStone(int x, int y) {
		// TODO Auto-generated method stub
		if(board[x][y].equals("-")) {
			return false;
		} else {
			return true;
		}
	}
}
