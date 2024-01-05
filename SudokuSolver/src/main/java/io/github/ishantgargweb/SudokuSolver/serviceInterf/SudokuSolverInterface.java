package io.github.ishantgargweb.SudokuSolver.serviceInterf;



public interface SudokuSolverInterface {
	
	/**
	 * 
	 * @param grid
	 * 
	 * Return all values of Sudoku in the form of List.
	 * 
	 * @return
	 */
	abstract boolean solveSudoku(int grid[][]);
	
	/**
	 * 
	 * @param grid
	 * 
	 * return true if given Sudoku grid is Valid otherwise false.
	 * 
	 * @return
	 */
	abstract boolean isSudokuValid(int grid[][]);
	
	/**
	 * 
	 * @param grid
	 * it will print grid in 9x9 format.
	 * 
	 */
	abstract void printGrid(int grid[][]);
	
	
}
