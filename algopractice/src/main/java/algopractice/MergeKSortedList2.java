package algopractice;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MergeKSortedList2 {

	public static void main(String[] args) {

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		java.util.NavigableMap<Integer, ListNode> kTree = new TreeMap<>();
		Arrays.asList(lists).stream().forEach(p -> insertInToTree(p, kTree));
		return kTree == null ? null : kTree.firstEntry().getValue();

	}

	private void insertInToTree(ListNode p, java.util.NavigableMap<Integer, ListNode> kTree) {
		while (p != null) {
			ListNode newNode = new ListNode(p.val);
			ListNode firstNode = kTree.get(p.val);
			kTree.put(p.val, newNode);
			if (firstNode != null) {
				newNode.next = firstNode;
			} else {
				java.util.Map.Entry<Integer, ListNode> ceilingEntry = kTree.ceilingEntry(p.val + 1);
				if (ceilingEntry != null)
					newNode.next = ceilingEntry.getValue();
			}
			java.util.Map.Entry<Integer, ListNode> previousEntry = kTree.floorEntry(p.val - 1);
			if (previousEntry != null) {
				ListNode lastEntryOfPreviousEntry = previousEntry.getValue();
				while (lastEntryOfPreviousEntry.next != null
						&& lastEntryOfPreviousEntry.next.val == lastEntryOfPreviousEntry.val)
					lastEntryOfPreviousEntry = lastEntryOfPreviousEntry.next;
				lastEntryOfPreviousEntry.next = newNode;
			}
			p = p.next;
		}
	}
}
