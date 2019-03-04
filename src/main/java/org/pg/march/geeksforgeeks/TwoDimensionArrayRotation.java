package org.pg.march.geeksforgeeks;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoDimensionArrayRotation {

	public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int totalTestcases = scanner.nextInt();
            while (totalTestcases-- > 0) {
                int matrixDimension = Integer.parseInt(scanner.nextLine());
                String inputValues = scanner.nextLine();
                int[][] matrix = convertToArray(inputValues, matrixDimension);
                rotate90(matrix, matrixDimension);
                System.out.println(printMatrix(matrix));
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(scanner != null) {
                try {
                    scanner.close();
                }catch(Exception e) {}
            }
        }
	}

	protected static String printMatrix(int[][] matrix) {
		boolean firstElement = true;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < matrix.length; i++) {
			for(int j=0; j < matrix[i].length; j++) {
				if(firstElement) {
					firstElement = false;
					sb.append(matrix[i][j]);
				}else {
					sb.append(" " + matrix[i][j]);
				}
			}
		}
		return sb.toString();
	}
	
	protected static void rotate90(int[][] matrix, int matrixDimension) {
		int noOfInnerMatrix = matrixDimension/2;
		for(int i = 0; i < noOfInnerMatrix; i++) {
			for(int j = i; j < matrixDimension - i - 1; j++) {
				int currRow = i, currColumn = j;
				int nextData = matrix[i][j];
				int nextRow = -1, nextColumn = -1;
				while(nextRow != i || nextColumn != j) {
					nextRow = currColumn;
					nextColumn = (matrixDimension - currRow - 1);
					int tempData = matrix[nextRow][nextColumn];
					matrix[nextRow][nextColumn] = nextData;
					nextData = tempData;
					currRow = nextRow;
					currColumn = nextColumn;
				}
			}
		}
	}
	
	protected static int[][] convertToArray(String inputValues, int matrixDimension){
		List<Integer> intArray = Stream.of(inputValues.split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		int[][] matrix = new int[matrixDimension][matrixDimension];
		int row = 0, column = 0;
		for(Integer intValue : intArray) {
			matrix[row][column] = intValue;
			if(column == matrixDimension - 1) {
				column = 0;
				row ++;
			}else {
				column ++;
			}
		}
		return matrix;
	}

}
