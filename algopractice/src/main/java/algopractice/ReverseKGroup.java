package algopractice;

public class ReverseKGroup {

	public static void main(String[] args) {
		ReverseKGroup rkg = new ReverseKGroup();
		ListNode linkedList = new ListNode(1);
		linkedList.next = new ListNode(2);
		linkedList.next.next = new ListNode(3);
		linkedList.next.next.next = new ListNode(4);
		linkedList.next.next.next.next = new ListNode(5);
		linkedList.next.next.next.next.next = new ListNode(6);
//		linkedList.next.next.next.next.next.next = new ListNodes(7);
		printList(linkedList);

		ListNode reversedList = rkg.reverseKGroup(linkedList, 3);
		printList(reversedList);

	}

	private static void printList(ListNode list) {
		while (list != null) {
			System.out.printf("%s ", list.val);
			list = list.next;
		}
		System.out.println();
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode lastGroupEnd = null;
		ListNode start[] = new ListNode[1];
		int[] groupCount = new int[1];
		while (head != null) {
			groupCount[0] = k;
			head = recur(start, lastGroupEnd, head, k - 1, groupCount);
			if (groupCount[0] == 0)
				lastGroupEnd = head;
			head = head.next;
		}
		return start[0];
	}

	public ListNode recur(ListNode start[], ListNode lastGroupEnd, ListNode head, int k, int groupCount[]) {
		ListNode rev = null;
		groupCount[0]--;
		if (head.next != null && k > 0)
			rev = recur(start, lastGroupEnd, head.next, k - 1, groupCount);
		if (k == 0 || head.next == null) {
			if (lastGroupEnd != null && groupCount[0] == 0)
				lastGroupEnd.next = head;
			if (start[0] == null) {
				start[0] = head;
			}
		} else if (groupCount[0] == 0) {
			ListNode oldNext = rev.next;
			rev.next = head;
			head.next = oldNext;
		}
		return head;
	}
}
