package Solver;
import java.util.*;
import java.io.*;
public class localSearch1 {
	//"local search using simulated annealing with the minimum conflict heuristic" 
	//implies using a local search algorithm that employs simulated annealing as a 
	//strategy to explore solutions probabilistically while employing the minimum 
	//conflict heuristic to guide the selection of moves or assignments. This 
	//combination helps in finding better solutions, even in complex problems with 
	//large search spaces and multiple local optima.
	//double temp = 10.0; // init temp
	//double cooling = 0.999; //cooling constant
	//int maxRuns = 1000; //max times it runs before cooling
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
        double startTemp = 100.0; // init temp
    	double cooling = 0.9; //cooling constant
    	int maxRuns = 10000; //max times it runs before cooling
    	
    	 List<List<int[]>> brokenDownBoard =create3x3();
    	 int[][] curBoard = fill3x3(brokenDownBoard, board);
    	 int cost = 1;
    	 if(cost ==0) {
    		 printBoard(curBoard);
    	 }else {
    		 int[][] answer = simAnnealing( curBoard,brokenDownBoard, board, maxRuns, cooling, startTemp);
    	 }
    	 //create3x3board
    	 //fill3x3blocks randomly
    	 
    	 //if error ==0 that means the solution is found
    	 //while not finsihed
    	 //when in sim annealing for loop
    	 //choose random 3x3box
    	 //flip cells in box
    	 //calc error of new fill = error2
    	 //run cost algorithm
    	 //whoever wins go with that and print error number
    	 //decrease cooling
    	 
    	 //fill3x3(brokenDownBoard, board);
    	/*int[][] answer = simAnnealing(board, maxRuns, cooling, startTemp);
    	if(answer != null) {
    		System.out.println("the correct solution");
    		printBoard(answer);
    	}else {
    		System.out.println("No solutoin found");
    	}*/
    }
	
	public static int[][] simAnnealing(int[][] curboard, List<List<int[]>> boardList, int[][] board, int maxRuns, double cooling, double startTemp) {
		//choose random 3x3box
   	 //flip cells in box
   	 //calc error of new fill = error2
   	 //run cost algorithm
   	 //whoever wins go with that and print error number
   	 //decrease cooling
		int err1=0;//error1
   	 	int err2=0;//error2
   	 	err1 = totalErrors(curBoard,);//calc error of first fill = error1
		double initTemp = startTemp; //need temp to make cooling schedule
		create3x3(board);
		
		for(int numRuns =0; numRuns < maxRuns; numRuns++) {
			initTemp = Math.max(1.0, cooling * initTemp); // can only get down to 1.0 never below
			//printBoard(curBoard);
			System.out.println("++++++++++++++++++");
			
		}	
			
	}
	
	public static List<List<int[]>> create3x3() { //create the lists of boxes
		//creates a list of 3x3 blocks for a Sudoku puzzle,
		//where each block is represented by a list of coordinate 
		//pairs (x, y) that correspond to the cells within that block
		List<List<int[]>> blocks = new ArrayList();//change it to int not Integer so you can use arraylsit methods
		
		for(int r = 0; r<9; r++) {
			List<int[]> coordinates = new ArrayList(); //change it int not Integer so you can use arraylist methods
			int[] columns = new int[3]; //create the colums of the boxes which have 3 spaces
			int[] row = new int[3];// create the rows of the boxes which have 3 spaces
			for(int i =0; i < 3; i++) {//splitting up row and colums for the 
				columns[i] = i+3 * (r%3);
				row[i] = i+3 * (r/3);
			}
			for(int x : columns) {//for x coordinate in column
				for(int y : row) {//for y coordinate in row
					coordinates.add(new int[]{x,y});
				}
			}
			blocks.add(coordinates);
		}
		return blocks;
	}
	public static int[][] fill3x3(List<List<int[]>> blocksList, int[][] board){//fill the 3x3 boxes based on which numbers can go in each box
		//loop through all blocks in the board
		//loop through the cells in each block
		//check for empty spaces
		//if there is an empty space, fill it with a random number(1-9) that is not already in the block
		
		//this function takes a partially filled Sudoku grid 
		//and a list of 3x3 blocks, and it fills the empty cells 
		//within each block with random numbers while ensuring 
		//that the numbers are valid and do not conflict with 
		//existing numbers in the same block.
		for(List<int[]>block : blocksList) {
			for(int[] cell : block) {
				int row = cell[0];
				int col = cell[1];
				
				int[][] curBlock = new int[3][3];
				for(int i =0; i< 3; i++){//copy values from orig board into block and place in right coordinates
					for(int j =0; j<3; j++) {
					curBlock[row][col] = board[i][j];
					}
				}
				if(curBlock[row][col] == 0) {
					int rando = getRandNum();
					int realInt =checkBox(curBlock,rando, row, col);
					curBlock[row][col] = realInt;
					board[row][col]= realInt;
				}
			}
		}
		return board;

	}
	public static int checkBox(int block[][],int rando, int row, int col) {
		int boxRowStart = row - row % 3;
	     int boxColStart = col - col % 3;
	 
	     for (int r = boxRowStart; r < boxRowStart + 3; r++){
	    	 for (int d = boxColStart; d < boxColStart + 3; d++) {
	           	if (block[r][d] == rando){
	           		rando=getRandNum();
	           		checkBox(block,rando, row, col);
	           	}
	     	}
	    }
	     return rando;
	}
	public static int totalErrors(int[][]board) {
		int numErrors =0;
		int row =0;
		int column =0;
		for(int num =1; num<=9; num++) {
			for(int i = 0; i< 9; i++) {//make sure row has no numbers the same
				if(board[row][i]==num) {//check if row has the number
					numErrors++;
					row++;
				}
				if(board[i][column] == num) { //check if column has the number
					numErrors++;
					column++;
				}
			}
		}
		return numErrors;
		
	}
	public static boolean cost(int firstErrors, int secondErrors, double temp) {
		Random rand = new Random();
		if(secondErrors-firstErrors<0) {
			return true; //say yes to second choice
		}else {
			if(Math.exp((secondErrors-firstErrors)/ temp)> Math.random()) {
				return true; //say yes to second choice
			}
		}
		return false;// say no to second choice
	}
		
	public static int[][] copyBoard(int[][] board){//copys board to use as a refernce later and to have other board to update
		int[][] copy = new int[9][9];
		for(int i =0; i<9; i++) {
			System.arraycopy(board[i],0, copy[i],0, 9);
		}
		return copy;

	}
	public static int getRandNum() { //getting random number 1-9 only
		Random rand = new Random();
		int min =1;
		int max =9;
		int newNum = rand.nextInt((max-min)+1)+min;
		return newNum;
	}
	public static int[] getRandomPos(){ //gets a random position in the sudoku puzzle
		Random rand = new Random();
		int randRow = rand.nextInt(9);
		System.out.println("row is "+ randRow);
		int randCol = rand.nextInt(9);
		System.out.println("col is " + randCol);
		int[] nums = {randRow,randCol};
		
		return nums; //trying to add randomness so get out of the local optima
		
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
	
	
}
