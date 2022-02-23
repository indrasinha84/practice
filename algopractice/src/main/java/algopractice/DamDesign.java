package algopractice;

public class DamDesign {

	public static void main(String[] args) {

		int n = 3;
		int[] wallPositions = { 1, 3, 7 };
		int[] wallHeights = { 4, 3, 3 };

		DamDesign dam = new DamDesign();
		System.out.println(dam.calculateWallHeight(n, wallPositions, wallHeights));
	}

	int calculateWallHeight(int n, int[] wallPositions, int[] wallHeights) {
		int maxMudWallHeight = 0;
		int lastWallHeight = 0;
		int wallPosition = 1;
		for (int i = 0; i < n - 1; i++) {
			while (wallPosition < wallPositions[i + 1]) {
				int mudWallHeight = 0;
				if (wallPosition == wallPositions[i]) {
//					System.out.println(
//							"Cement wall present at position " + wallPosition + " of height " + wallHeights[i]);
					lastWallHeight = wallHeights[i];
				} else {

					if (wallPositions[i + 1] == wallPosition + 1) {
						mudWallHeight = Integer.min(wallHeights[i + 1], lastWallHeight) + 1;
					} else {
						mudWallHeight = lastWallHeight + 1;
					}
//					System.out.println("Creating mud wall at position " + wallPosition + " of height " + mudWallHeight);

					maxMudWallHeight = mudWallHeight > maxMudWallHeight ? mudWallHeight : maxMudWallHeight;
					lastWallHeight = mudWallHeight;
				}
				wallPosition++;
			}
		}
		return maxMudWallHeight;
	}

}
