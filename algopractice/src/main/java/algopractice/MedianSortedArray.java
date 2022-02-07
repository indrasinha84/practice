package algopractice;

public class MedianSortedArray {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int maxMedianPosition = (nums1.length + nums2.length) / 2;
		int minMedianPosition = (nums1.length + nums2.length) % 2 == 1 ? -1 : maxMedianPosition - 1;

		int medianCounter = 0;
		int pos1 = 0, pos2 = 0;
		int medianSum = 0;
		while (medianCounter <= maxMedianPosition) {
			if (pos2 < nums2.length && (pos1 >= nums1.length  || nums1[pos1] > nums2[pos2]) ) {
				if (medianCounter == minMedianPosition)
					medianSum = nums2[pos2];
				else if (medianCounter == maxMedianPosition)
					medianSum += nums2[pos2];
				pos2++;
			} else {
				if (medianCounter == minMedianPosition)
					medianSum = nums1[pos1];
				else if (medianCounter == maxMedianPosition)
					medianSum += nums1[pos1];
				pos1++;
			}
			medianCounter++;
		}
		return minMedianPosition  != -1 ? medianSum/2.0 : medianSum;
	}

	public static void main(String[] args) {
		MedianSortedArray msa = new MedianSortedArray();
		int[] a = { 2 };
		int[] b = { };
		System.out.println(msa.findMedianSortedArrays(a, b));

	}

}
