
/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. (can you do this in place?)
 */
public class RotateMatrix {
	public static void main(String[] args) {

		int n = 4;
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		printMatrix(rotate(matrix, n), n);
	}

	/**
	 * This approach rotates the given two dimensional matrix layer by layer.
	 * We can think of the matrix as nested squares which are rotated one by one starting from the outermost square.
	 *
	 * When rotating each square, we shift the elements to the appropriate place starting from left to right.
	 *
	 * Since this solution needs to access every element at least once, the time complexity for this one would be O(N^2)
	 *
	 * @param a
	 * @param n
	 * @return
	 */
	private static int[][] rotate(int[][] a, int n) {

		for (int layer = 0; layer < n / 2; layer++) {

			int first = layer;
			int last = n - layer - 1;

			for (int i = layer; i < n - layer - 1; i++) {
				int offset = i - first;

				int temp = a[first][i];
				a[first][i] = a[last - offset][first];
				a[last - offset][first] = a[last][last - offset];
				a[last][last - offset] = a[i][last];
				a[i][last] = temp;

			}

		}
		return a;
	}

	private static void printMatrix(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println("\n");
		}
	}
}
