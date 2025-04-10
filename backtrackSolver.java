package Solver;
import java.util.*;
import java.io.*;
public class backtrackSolver {
	//public class gameBoard{
      
      public static void main() throws Exception{
    	  gameBoard board = new gameBoard();
          board.makeBoard("C:\\Users\\wbwas\\Downloads\\Easy-P1.csv");
          board.parseBoard();
          board.printBoard();
          
  	}
        
	public static boolean isPossible(int[][] board, int row, int column, int num) {
		for(int i = 0; i< 9; i++) {//make sure row has no numbers the same
			if(board[row][i]==num) {//check if row has the number
				return false;
			}
			if(board[i][column] == num) { //check if column has the number
				return false;
			}
			int sqrt = (int)Math.sqrt(9);//box check taken from geeksforgeeks
	        int boxRowStart = row - row % sqrt;
	        int boxColStart = column - column % sqrt;
	 
	        for (int r = boxRowStart; r < boxRowStart + sqrt; r++){
	            for (int d = boxColStart; d < boxColStart + sqrt; d++)
	            	if (board[r][d] == num){
	            		return false;
	                }
	            }
	        }
		return true;//return true if and only if all above loops are true
	
	}
	
	public static void printBoard(int[][] board) {
		for(int row= 0; row< 9; row++) { //printing the board line by line
			for(int col = 0; col< 9; col++) {
				System.out.print(board[row][col]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	public static boolean backSolver(int[][] board) {
		int row = -1;
		int column = -1; //initializes row and column to -1, which will be used to keep track of the first empty cell (cell with a value of 0) in the puzzle.
		boolean isSolved = true; //to search for first empty cell that hehe
		for (int r =0 ; r< 9; r++) {
			for( int c =0; c<9; c++) {
				if(board[r][c]==0) {//is there an empty space?
					row = r;
					column = c;
					isSolved = false;//means board is not solved after checking column
					break; 
				}
			}
			if(!isSolved) {//literally the sme as above jsut for row
				break;
			}
		}
		if(isSolved) { //if it is solved return true
			return true;
		}
		for (int num = 1; num <= 9; num++)//portion taken from geeks for geeks
        {
            if (isPossible(board, row, column, num))
            {
                board[row][column] = num;
                //forward checking
                if (backSolver(board))
                {
                    
                    return true;
                }
                else
                {
                    // replace it
                    board[row][column] = 0;
                }
            }
        }
        return false;
	}
	

   
	 public static void main(String args[])
	    {
	 
	        int[][] board = new int[][] {
	            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
	            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
	            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
	            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
	            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
	            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
	            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
	        };
	        //int N = board.length;
	 
	        if(backSolver(board))
	        {
	            // print solution
	            printBoard(board);
	        }
	        else {
	            System.out.println("No solution");
	        }
	    }
	
	
}

