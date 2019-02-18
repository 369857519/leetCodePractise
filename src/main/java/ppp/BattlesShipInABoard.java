package ppp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BattlesShipInABoard {

	private class Coordinate {

		private int x;
		private int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Coordinate) {
				Coordinate coordinate = (Coordinate) obj;
				return coordinate.x == x && coordinate.y == y;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int hash = 3;
			hash = 53 * hash + x;
			hash = 53 * hash + y;
			return hash;
		}
	}

	public static void main(String args[]) {
		BattlesShipInABoard battlesShipInABoard = new BattlesShipInABoard();
		int res=battlesShipInABoard.countBattleships(new char[][]{
			{'X', '.', '.', 'X'},
			{'.', '.', '.', 'X'},
			{'.', '.', '.', 'X'}
		});
		System.out.println(res);
	}

	public int countBattleships(char[][] board) {
		//r,x
		//c,y
		int count = 0;
		Set<Coordinate> shipPoints = new HashSet<Coordinate>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				Coordinate coordinate = new Coordinate(i, j);
				if (board[i][j] == 'X' && !shipPoints.contains(coordinate)) {
					//上下左右
					getShip(coordinate, shipPoints, board);
					count++;
				}
			}
		}
		return count;
	}

	private void getShip(Coordinate coordinate, Set<Coordinate> shipPoints, char[][] board) {
		int[][] nearPlace = new int[][]{
			{0, 1},
			{0, -1},
			{1, 0},
			{-1, 0},
		};
		shipPoints.add(coordinate);
		for (int i = 0; i < nearPlace.length; i++) {
			int newX = coordinate.x + nearPlace[i][0];
			int newY = coordinate.y + nearPlace[i][1];
			if (newX >= 0 && newX < board.length && newY >= 0
				&& newY < board[0].length && board[newX][newY] == 'X') {
				Coordinate coordinate1 = new Coordinate(newX, newY);
				if (!shipPoints.contains(coordinate1)) {
					getShip(coordinate1, shipPoints, board);
				}
			}
		}
	}
}
