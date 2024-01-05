package io.github.ishantgargweb.SudokuSolver.serviceImpl;

import org.springframework.stereotype.Service;

import io.github.ishantgargweb.SudokuSolver.constants.GlobalConstants;
import io.github.ishantgargweb.SudokuSolver.serviceInterf.SudokuSolverInterface;

@Service
public class SudokuSolverImpl implements SudokuSolverInterface{

	public boolean solveSudoku(int[][] grid) {
		
		/**
		 * Condition:
		 * 1. it must be a valid sudoku.
		 * 2. Must follow Rules for filling non-filled numbers.
		 * 
		 * Return:
		 * false: if sudoku is invalid.
		 * true: if sudoku is solved, then it filled with all values.
		 */
		
		/**
		 * Condition 1: implementation
		 */
		if(!isSudokuValid(grid)) {
			return false;
		}else {
			for (int row=0;row<GlobalConstants.NUMBER_OF_ROWS;row++) {
				for (int col=0;col<GlobalConstants.NUMBER_OF_COLUMNS;col++) {
					if(grid[row][col] == 0) {
						/**
						 * Now, we will fill to start values from 1 to 9 one-by-one.
						 * After filled with a value, then we will check it leads to a solution or not.
						 */
						for (int fill=1;fill<=9;fill++) {
							if(canWePutFillInGrid(grid, row, col, fill)) {
								grid[row][col] = fill;
								if(solveSudoku(grid)) {
									return true;
								}
								grid[row][col] = 0;
							}
						}
						/**
						 * it means, we can not fill any value at this (row, col).
						 */
						return false;
					}
				}
			}
			/**
			 * it means,sudoku is valid.
			 */
			return true;
		}
	}

	private boolean canWePutFillInGrid(int[][] grid, int currentRow, int currentColumn, int fill) {
		
		/**
		 * Condition to put value fill at (row, col).
		 * 1. Check in current column.
		 * 2. Check in current row.
		 * 3. Check in 3x3 subgrid.
		 */
		
		/**
		 * Condition 1: implementation
		 */
		for (int col=0;col<9;col++) {
    		if(grid[currentRow][col] == fill) {
    			return false;
    		}
    	}
		/**
		 * Condition 2: implementation
		 */
    	
    	for (int row=0;row<9;row++) {
    		if(grid[row][currentColumn] == fill) {
    			return false;
    		}
    	}
    	/**
		 * Condition 3: implementation
		 */
    	int colBasket = currentColumn/3;
    	int rowBasket = currentRow/3;
    	
    	int topi, topj, bottomi, bottomj = 0;
    	bottomi = colBasket*3;
    	bottomj = colBasket*3+2;
    	
    	topi = rowBasket * 3;
    	topj = rowBasket * 3+2;
    	
    	for (int p1=topi;p1<=topj;p1++) {
    		for (int p2 = bottomi;p2<=bottomj;p2++) {
    			if(grid[p1][p2] == fill) {
    				return false;
    			}
    		}
    	}
    	/**
    	 * it means sudoku is valid.
    	 */
    	return true;
	}


	public boolean isSudokuValid(int[][] grid) {
		/**
		 * This method will check, if user input grid is valid Input or not.
		 * grid[i][j] = 0, means we have to fill a valid value at (i,j) for 9>i,j>=0
		 * if @Valid -> return true
		 * else -> return false
		 */
		int numberOfRows = grid.length;
		int numberOfColums = grid[0].length;
		
		/**
		 * Condition for invalid user input grid.
		 * 1. numberOfRows is not equals to numberOfColumns.
		 * 2. Sudoku must be of type Mini-Sudoku(9x9)
		 * 3. There must be number present between [0,9] both inclusive. 
		 *    0 means not-filled.
		 *    [1-9] means filled.
		 * 
		 * Rules for a valid Sudoku:
		 * 
		 * 1. Each row of grid must have unique values from 1 to 9.
		 * 2. Each column of grid must have unique values from 1 to 9.
		 * 3. Each subgrid of size 3x3, must have unique values from 1 to 9.
		 */
		
		/**
		 * Condition 1: implementation
		 */
		if(numberOfRows != numberOfColums) {
			return false;
		}
		
		/**
		 * Condition 2: implementation
		 */
		if(numberOfRows != GlobalConstants.NUMBER_OF_ROWS) {
			return false;
		}
		/**
		 * Condition 3: implementation
		 */
		for (int row=0;row<numberOfRows;row++) {
			for (int col=0;col<numberOfColums;col++) {
				if(!(grid[row][col]>=0 && grid[row][col]<=9)) {
					return false;
				}
			}
		}
		/**
		 * it means, it is a valid sudoku.
		 */
		return true;
	}
	
	/**
	 * it is printGrid in table.
	 */

	public void printGrid(int[][] grid) {
		int numberOfRows = grid.length;
		int numberOfCols = grid[0].length;
		for (int row=0;row<numberOfRows;row++) {
			for (int col=0;col<numberOfCols;col++) {
				System.out.print(grid[row][col]+" ");
			}
			System.out.println();
		}
	}
	

}
