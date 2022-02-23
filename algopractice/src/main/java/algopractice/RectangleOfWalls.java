package algopractice;

public class RectangleOfWalls {

	public static void main(String[] args) {
		int[] inputArray = { 5, 6, 10, 12, 4, 50, 13 };
		RectangleOfWalls r = new RectangleOfWalls();
		System.out.println(r.getLargestRectangle(inputArray));
	}

	private int getLargestRectangle(int[] inputArray) {
		int largestArea = 0;
		int[][] temp = new int[inputArray.length][inputArray.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = i; j < temp.length; j++) {
				if (i == 0) {
					temp[i][j] = inputArray[j];
				} else {
					temp[i][j] = Math.min(temp[i - 1][j], inputArray[j - i]);
					
				}
				if (temp[i][j] * (i + 1) > largestArea) {
					largestArea = temp[i][j] * (i + 1);
				}
			}
		}
		return largestArea;
	}

}
