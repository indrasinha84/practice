package algopractice;

import java.util.Arrays;

public class MergeKSortedList {

	public static void main(String[] args) {

	}


	public ListNode mergeKLists(ListNode[] lists) {

		ListNode outputList = null, outputListHead = null;
		ListNode[] nextValue = new ListNode[lists.length];
		int lowestValuePosition = -1;
		boolean moreToRead = false;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				moreToRead = true;
				nextValue[i] = lists[i];
			}
		}

		while (moreToRead) {
			moreToRead = false;
            lowestValuePosition = -1;
			for (int i = 0; i < lists.length; i++) {
				if (nextValue[i] != null) {
					moreToRead = true;
					if (lowestValuePosition == -1 || nextValue[i].val < nextValue[lowestValuePosition].val) {
						lowestValuePosition = i;
					}

				}
			}
            if (lowestValuePosition == -1) {
                break;
            }
			outputListHead = addAndMoveToNextPosition(lowestValuePosition, outputListHead, nextValue);
            if (outputList == null) {
                outputList = outputListHead;
            }
      		nextValue[lowestValuePosition] = nextValue[lowestValuePosition].next;

		}
		return outputList;

	}

	private ListNode addAndMoveToNextPosition(int lowestValuePosition, ListNode outputListHead,
			ListNode[] nextValue) {
		if (outputListHead == null) {
			outputListHead = new ListNode(nextValue[lowestValuePosition].val);
		} else {
			outputListHead.next = new ListNode(nextValue[lowestValuePosition].val);
            outputListHead = outputListHead.next;
		}
		return outputListHead;
	}

}
