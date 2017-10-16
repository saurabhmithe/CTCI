
public class RotateMatrix {
	public static void main(String[] args) {

		int n = 4;
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		printMatrix(rotate(matrix, n), n);
	}

	private static void printMatrix(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println("\n");
		}
	}

	private static int[][] rotate(int[][] a, int n) {

		for (int layer = 0; layer < n / 2; layer++) {

			int first = layer;
			int last = n - layer - 1;

			for (int i = layer; i < n - layer - 1; i++) {
				int offset = i - first;
				
				int temp = a[first][i];
				a[first][i] = a[last - offset][first];
				a[last-offset][first] = a[last][last-offset];
				a[last][last-offset] = a[i][last];
				a[i][last] = temp;
			}

		}
		return a;

	}
}
