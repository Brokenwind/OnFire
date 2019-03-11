package com.broken.cate.leet.media;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        //http://www.cnblogs.com/grandyang/p/4669134.html
        if (matrix == null || matrix.length == 0)
            return false;
        int curRow = matrix.length - 1;
        int curCol = 0;
        while (curRow >= 0 && curCol < matrix[0].length) {
            if (matrix[curRow][curCol] > target) {
                curRow--;
            } else if (matrix[curRow][curCol] < target) {
                curCol++;
            } else {
                return true;
            }
        }
        return false;
    }
}
