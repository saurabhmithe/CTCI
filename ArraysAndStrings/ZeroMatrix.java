
public class ZeroMatrix {
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
		printMatrix(nullifyZeros(matrix, m, n));
	}

	private static int[][] nullifyZeros(int[][] matrix, int m, int n) {

		printMatrix(matrix);
		
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
		
		printMatrix(matrix);

		for (int i = 0; i < toNullifyColumn.length; i++) {
			if (toNullifyColumn[i]) {
				nullifycolumn(i, matrix);
			}
		}

		return matrix;
	}

	private static void nullifyRow(int i, int[][] matrix) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[i][j] = 0;
		}
	}

	private static void nullifycolumn(int i, int[][] matrix) {
		for (int j = 0; j < matrix.length; j++) {
			matrix[j][i] = 0;
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("  " + matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}
}
