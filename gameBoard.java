package Solver;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class gameBoard {
	String[][] board = new String[9][9];
    int[][] intBoard = new int[9][9];
	 public void makeBoard(String file)throws Exception{
	       File input = new File(file);
	       Scanner sc = new Scanner(input);
	       //int column = 0;
	       int row = 0;
	       while(sc.hasNext()){
	           String[] rowin = sc.next().split(",");
	           for(int i = 0; i < 9; i++){
	               if(rowin[i].contains("?")){
	                   rowin[i] = "0";
	               }
	           }
	           board[row] = rowin.clone();
	           row++;
	       }
	      }
	    public void parseBoard(){
	        for(int i = 0; i < 9; i++){
	            for(int j = 0; j < 9; j++){
	                intBoard[i][j] = Integer.parseInt(board[i][j]);
	            }
	        }
	    }
	    public void printBoard(){
	         System.out.println(Arrays.deepToString(board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	    }
}
