
public class ArrayList {

	private String[] array;
	private int n;
	private int pointer;

	public ArrayList() {
		n = 5; // Initial size of the array
		pointer = 0; // Pointer for inserting values
		array = new String[5];
	}

	public void add(String s) {
		// if array is full, create a new array, copy all the existing elements from
		// current array to the new array and add the new element to the end of the
		// new array
		if (pointer >= array.length) {
			n = n * 2;
			String[] newArray = new String[n];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[pointer++] = s;
	}

	public String get(int index) {
		if (index < array.length) {
			return array[index];
		}
		return null;
	}

	public int size() {
		return n;
	}
}
