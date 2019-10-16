package org.pg.march.lc.graph;

/*
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    private int rowLength;
    private int colLength;
    
    public int maximalRectangle(char[][] matrix) {
        int rowLength, maximal = 0;
        if ((rowLength = matrix.length) == 0) {
            return 0;
        }
        int colLength = matrix[0].length;
        int[][] runWidth = new int[rowLength][colLength];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == '1') {
                    int maxWidth = 1 + (col == 0 ? 0 : runWidth[row][col-1]);
                    runWidth[row][col] = maxWidth;
                    for (int i = row; i >= 0; i--) {
                        maxWidth = Math.min(maxWidth, runWidth[i][col]);
                        maximal = Math.max(maximal, maxWidth * (row - i + 1));
                    }
                }
            }
        }
        return maximal;
    }
    
    public int maximalRectangleFirstTry(char[][] matrix) {
        int maximal = 0;
        if ((rowLength = matrix.length) == 0) {
            return 0;
        }
        colLength = matrix[0].length;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == '1')
                    maximal = Math.max(maximal, _findMaximal(matrix, row, col, row, col));
            }
        }
        return maximal;
    }
    
    private int _findMaximal(char[][] matrix, int rStart, int cStart, int rEnd, int cEnd) {
        
        boolean extendRow = false;
        if(extendRow = (rEnd + 1 < rowLength)) {
            for(int i = cStart; i<= cEnd; i++) {
                extendRow = extendRow && (matrix[rEnd + 1][i] == '1');
            }
        }
        int rowMaximal = extendRow? _findMaximal(matrix, rStart, cStart, rEnd + 1, cEnd) : 0;
        boolean extendCol = false;
        if(extendCol = (cEnd + 1 < colLength)) {
            for(int i = rStart; i<= rEnd; i++) {
                extendCol = extendCol && (matrix[i][cEnd + 1] == '1');
            }
        }
        int colMaximal = extendCol? _findMaximal(matrix, rStart, cStart, rEnd, cEnd + 1) : 0;
        
        boolean extendDiag = extendRow && extendCol && matrix[rEnd + 1][cEnd + 1] == '1';
        int diagMaximal = extendDiag? _findMaximal(matrix, rStart, cStart, rEnd + 1, cEnd + 1) : 0;
        int currMaximal = (cEnd - cStart + 1) * (rEnd - rStart + 1);
        
        return Math.max(Math.max(rowMaximal, colMaximal), Math.max(currMaximal, diagMaximal));
    }
    
    
}
