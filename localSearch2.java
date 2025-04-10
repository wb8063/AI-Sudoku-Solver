package Solver;

/*public class localSearch2 {
	//local search using a genetic algorithm with a penalty function and tournament selection
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
    	double cooling = 0.99; //cooling constant
    	int maxRuns = 1000; //max times it runs before cooling
    	
    	int[][] answer = simAnnealing(board, maxRuns, cooling, startTemp);
    	if(answer != null) {
    		printBoard(answer);
    	}else {
    		System.out.println("No solutoin found");
    	}
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
	//if(isSolved(curBoard, newNum)) {//if the board provided is a solved board, print le board
				//return curBoard;
			//}
			
			int[] randPos = getRandomPos();//select random square
			while(curBoard[randPos[0]][randPos[1]] != 0) {
				randPos = getRandomPos();
			}
			
		//int randRow = randPos[]
			int curNum = curBoard[randPos[0]][randPos[1]];
			int newNum = getRandNum();
			System.out.println(newNum);
			int generated =1;
			if(isSolved(curBoard, newNum)) {//if the board provided is a solved board, print le board
				return curBoard;
			}
			while(newNum == curNum || !isPossible(curBoard, randPos[0], randPos[1], newNum)) {
				if(generated == 9) {
					//curBoard= copyBoard(reuseBoard);
					break;
				}
				newNum = getRandNum();
				generated++;
				//System.out.println("in da loop");
				
			}
			System.out.println("made it past loop");
			curBoard[randPos[0]][randPos[1]] = newNum; //update board with new number
			System.out.println(newNum);
		}
		return null;
}*/
