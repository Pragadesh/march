package org.pg.march.geeksforgeeks;

import org.junit.Test;

import junit.framework.Assert;

public class TestTwoDimensionArrayRotation {

	@Test
	public void test3D_Matrix() {
		int matrixDimension = 3;
		String inputValues = "1 2 3 4 5 6 7 8 9";
		int[][] matrix = TwoDimensionArrayRotation.convertToArray(inputValues, matrixDimension);
		TwoDimensionArrayRotation.rotate90(matrix, matrixDimension);
		String outputMatrix = TwoDimensionArrayRotation.printMatrix(matrix);
		Assert.assertEquals("Compare 3D matrix after rotation", "7 4 1 8 5 2 9 6 3", outputMatrix);
	}
	
	@Test
	public void test2D_Matrix() {
		int matrixDimension = 2;
		String inputValues = "56 96 91 54";
		int[][] matrix = TwoDimensionArrayRotation.convertToArray(inputValues, matrixDimension);
		TwoDimensionArrayRotation.rotate90(matrix, matrixDimension);
		String outputMatrix = TwoDimensionArrayRotation.printMatrix(matrix);
		Assert.assertEquals("Compare 2D matrix after rotation", "91 56 54 96", outputMatrix);
	}
	
	@Test
	public void test4D_Matrix() {
		int matrixDimension = 4;
		String inputValues = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16";
		int[][] matrix = TwoDimensionArrayRotation.convertToArray(inputValues, matrixDimension);
		TwoDimensionArrayRotation.rotate90(matrix, matrixDimension);
		String outputMatrix = TwoDimensionArrayRotation.printMatrix(matrix);
		Assert.assertEquals("Compare 3D matrix after rotation", "13 9 5 1 14 10 6 2 15 11 7 3 16 12 8 4", outputMatrix);
	}
}
