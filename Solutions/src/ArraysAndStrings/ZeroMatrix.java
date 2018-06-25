package ArraysAndStrings;

public class ZeroMatrix {

	/*

	Write an algorithm such that if an element in an MxN matrix is 0,
	its entire row and column are set to O.

	*/

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = i + j + 2;
            }
        }
        matrix[0][3] = 0;
        matrix[1][2] = 0;
        matrix[2][3] = 0;
        nullifyZeros(matrix, m, n);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("  " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * In this approach, we use two boolean arrays to maintain the row number to be nullified and the
     * column number to be nullified. We access each element in the given matrix and if the element is 0,
     * we add the set the value corresponding to the row number in the row boolean array to true.
     * Similarly, we set the value corresponding to the column number in the column boolean array to true.
     * <p>
     * Now that we have two arrays which indicate the row number and column number to be nullified respectively,
     * we traverse through the arrays and set the row and column to 0 in the original matrix according
     * to the data in the arrays.
     * <p>
     * Time Complexity - O(m * n)
     * Space Complexity - O(m + n)
     */
    private static int[][] nullifyZeros(int[][] matrix, int m, int n) {
        boolean[] toNullifyRow = new boolean[m];
        boolean[] toNullifyColumn = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    toNullifyRow[i] = true;
                    toNullifyColumn[j] = true;
                }
            }
        }
        for (int i = 0; i < toNullifyRow.length; i++) {
            if (toNullifyRow[i]) {
                nullifyRow(i, matrix);
            }
        }
        for (int i = 0; i < toNullifyColumn.length; i++) {
            if (toNullifyColumn[i]) {
                nullifyColumn(i, matrix);
            }
        }
        return matrix;
    }

    private static void nullifyRow(int i, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }

    private static void nullifyColumn(int i, int[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][i] = 0;
        }
    }

}
