package org.assigment2.controller;

import org.assigment2.input.UserInput;
import org.assigment2.model.Board;
import org.assigment2.model.Player;

public class GameController implements GameInterface {
	private static final int dimention = 15;
	private static int countMove;
	private UserInput userInput;
	private Player player;
	Board board;

	public void initialGame() {
		// TODO Auto-generated method stub
		countMove = 0;
		board = new Board();
		userInput = new UserInput();
		System.out.println("-----Welcome-----");
		// if(userInput.hasNext()) {
		// String test = userInput.getInput();
		// System.out.println(test);
		// }
		board.drawBoard();
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		player = new Player("Black");
		while (true) {

			System.out.println(player.getName()
					+ "'s Turn: Where do you wish to place your stone: ");
			System.out.print("Please type x and y locations: ");
			String coordinate = userInput.getInput();
			if (this.checkInput(coordinate, dimention)) {
				String[] rawindex = coordinate.split(",");
				int x = (Integer.parseInt(rawindex[0]) - 1);
				int y = (Integer.parseInt(rawindex[1]) - 1);
				String preName = player.getName();
				if (!board.hasStone(x, y)) {
					board.setBoard(x, y, player);
					System.out.println("You have placed " + player.getName()
							+ " stone at (" + rawindex[0] + "," + rawindex[1]
							+ ")");
					board.drawBoard();
					if (this.checkWinner(x, y)) {
						System.out.println("Winner is " + player.getName());
						this.endGame();
					}
					this.nextTurn();
				} else {
					System.out.println("already has " + preName + " stone");
				}

			} else if (this.checkGiveUp(coordinate)) {
				System.out.println("Do you want to restart Game or not? Y/N ");
				String in = userInput.getInput();
				if (in.equalsIgnoreCase("Y")) {
					this.restartGame();
				} else if (in.equalsIgnoreCase("N")) {
					this.endGame();
				}
			}

		}
	}

	private void restartGame() {
		// TODO Auto-generated method stub
		this.initialGame();
		this.startGame();
	}

	private boolean checkGiveUp(String coordinate) {
		// TODO Auto-generated method stub
		if (coordinate.length() > 5) {
			if (coordinate.equalsIgnoreCase("Give up")) {
				return true;
			} else {
				System.out.println("Invalide format(Please input:Give up)");
				return false;
			}
		}
		return false;

	}

	private void nextTurn() {
		// TODO Auto-generated method stub
		if (player.getName().equals("Black")) {
			this.player.setName("White");
		} else if (player.getName().equals("White")) {
			this.player.setName("Black");
		}
	}

	public boolean checkInput(String coordinate, int boundary) {
		// TODO Auto-generated method stub
		int row;
		int column;
		boolean result = true;
		if (coordinate.length() <= 5) {
			if (coordinate.contains(",")) {
				int i = coordinate.indexOf(",");

				if (i == 0) {
					result = false;
					System.out
							.println("Invalide input (please input like this: number,number)");
				} else {

					String[] rawindex = coordinate.split(",");
					
					if(rawindex.length < 2) {
						result = false;
						System.out
								.println("Invalide input (please input like this: number,number)");
					} else {
	
						String rowString = rawindex[0];
						String columnString = rawindex[1];
						try {
							row = Integer.parseInt(rowString) - 1;
							if ((row > boundary) || (row < 0)) {

								System.out
										.println("Number of Row exceeds boundar please enter new Number   0 < number =< "
												+ boundary);
								result = false;
							}

						} catch (NumberFormatException e) {
							System.out
									.println("wrong Format you have to input number,number");
							result = false;
						}

						try {
							column = Integer.parseInt(columnString) - 1;
							if ((column > boundary) || (column < 0)) {
								System.out
										.println("Number of Row exceeds boundar please enter new number 0 < number =< "
												+ boundary);
								System.out
										.println("Invalide input(please input like this: number,number)");
								result = false;
							}
						} catch (NumberFormatException w) {
							System.out
									.println("wrong Format you have to input number,number");
							result = false;
						}
					}
				}
			}
		} else {
			result = false;
		}

		return result;
	}

	public boolean checkWinner(int x, int y) {
		// TODO Auto-generated method stub
		boolean check = false;

		String[][] gameBoard = board.getBoard();
		String stoneType = gameBoard[x][y];

		// check x
		int countX = 0;
		int iX = 0;
		int count_X = 0;
		int i_X = 0;
		if (x > 0 && x < dimention) {
			while (stoneType.equals(gameBoard[x + iX][y])) {
				if (x + iX < dimention - 1) {
					iX++;
					countX++;
				} else {
					break;
				}
			}
			while ((stoneType.equals(gameBoard[x - i_X][y]))) {
				if (x - i_X > 0) {
					i_X++;
					count_X++;
				} else {
					break;
				}
			}
		}
		if (countX == 5 || count_X == 5 || (count_X + countX) == 5) {
			check = true;
		}
		// check y
		int countY = 0;
		int iY = 0;
		int count_Y = 0;
		int i_Y = 0;
		if (y > 0 && y < dimention) {
			while (stoneType.equals(gameBoard[x][y + iY])) {
				if (y + iY < dimention - 1) {
					iY++;
					countY++;
				} else {
					break;
				}
			}
			while ((stoneType.equals(gameBoard[x][y - i_Y]))) {
				if (y - i_Y > 0) {
					i_Y++;
					count_Y++;
				} else {
					break;
				}
			}
		}
		if (countY == 5 || count_Y == 5 || (count_Y + countY) == 5) {
			check = true;
		}
		// check y = x
		int coutYX = 0;
		int iYX = 0;

		int count_YX = 0;
		int i_YX = 0;
		if (x > 0 && x < dimention && y > 0 && y < dimention) {
			while (stoneType.equals(gameBoard[x - iYX][y + iYX])) {
				if (x - iYX > 0 && y + iYX < dimention - 1) {
					iYX++;
					coutYX++;
				} else {
					break;
				}
			}
			while ((stoneType.equals(gameBoard[x + i_YX][y - i_YX]))) {
				if (x + i_YX < dimention - 1 && y - i_YX > 0) {
					i_YX++;
					count_YX++;
				} else {
					break;
				}
			}
		}
		if (coutYX == 5 || count_YX == 5 || (count_YX + coutYX) == 5) {
			check = true;
		}
		// check y= -x
		int coutY_X = 0;
		int iY_X = 0;
		int count_Y_X = 0;
		int i_Y_X = 0;
		if (x > 0 && x < dimention && 0 < y && y < dimention) {
			while (stoneType.equals(gameBoard[x + iY_X][y + iY_X])) {
				if (x + iY_X < dimention - 1 && y + iY_X < dimention - 1) {
					iY_X++;
					coutY_X++;
				} else {
					break;
				}
			}
			while ((stoneType.equals(gameBoard[x - i_Y_X][y - i_Y_X]))) {
				if (x - i_Y_X > 0 && y - i_Y_X > 0) {
					i_Y_X++;
					count_Y_X++;
				} else {
					break;
				}
			}
		}
		if (coutY_X == 5 || count_Y_X == 5 || (count_Y_X + coutY_X) == 5) {
			check = true;
		}
		// check if there are five stone
		return check;
	}

	@Override
	public void endGame() {
		// TODO Auto-generated method stub
		System.out.println("Game end!");
		System.exit(0);
	}

}
