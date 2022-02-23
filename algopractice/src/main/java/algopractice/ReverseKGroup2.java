package algopractice;

public class ReverseKGroup2 {

	public static void main(String[] args) {
		ReverseKGroup2 rkg = new ReverseKGroup2();
		ListNode linkedList = new ListNode(1);
		linkedList.next = new ListNode(2);
		linkedList.next.next = new ListNode(3);
		linkedList.next.next.next = new ListNode(4);
		linkedList.next.next.next.next = new ListNode(5);
		linkedList.next.next.next.next.next = new ListNode(6);
		linkedList.next.next.next.next.next.next = new ListNode(7);
		printList(linkedList);

		ListNode reversedList = rkg.reverseKGroup(linkedList, 7);
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
		ListNode[] temp = new ListNode[k];
		ListNode reverseStart = null, reverseHead = null;
		int groupCounter = 0;
		while (head != null) {
			temp[groupCounter++] = head;
			head = head.next;
			if (groupCounter == k) {
				if (reverseStart == null) {
					reverseStart = temp[k - 1];
				}
				for (int i = groupCounter - 1; i > 0; i--) {
					temp[i].next = temp[i - 1];
	
				}
				if (reverseHead != null)
					reverseHead.next = temp[k - 1];
				reverseHead = temp[0];
				reverseHead.next = head;
				groupCounter = 0;
			}
		}
		return reverseStart == null ? temp[0] : reverseStart;
		
	
	}

}
