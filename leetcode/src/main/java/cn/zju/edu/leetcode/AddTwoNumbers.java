/*
 * FILE     :  AddTwoNumbers.java
 *
 * CLASS    :  AddTwoNumbers
 *
 * COPYRIGHT:
 *
 *   The computer systems, procedures, data bases and programs
 *   created and maintained by Qware Technology Group Co Ltd, are proprietary
 *   in nature and as such are confidential.  Any unauthorized
 *   use or disclosure of such information may result in civil
 *   liabilities.
 *
 *   Copyright Jul 18, 2013 by Qware Technology Group Co Ltd.
 *   All Rights Reserved.
 */
package cn.zju.edu.leetcode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode newHead = null, pre = null;
		int more = 0;
		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		while (l1 != null || l2 != null) {
			int n1 = 0;
			int n2 = 0;
			if (l1 != null) {
				n1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				n2 = l2.val;
				l2 = l2.next;
			}
			int sum = n1 + n2 + more;
			if (sum > 9) {
				more = 1;
				sum = sum - 10;
			} else {
				more = 0;
			}
			ListNode node = new ListNode(sum);
			if (newHead == null) {
				newHead = node;
			}
			if (pre == null) {
				pre = newHead;
			} else {
				pre.next = node;
				pre = node;
			}
		}
		if (more == 1) {
			ListNode node = new ListNode(1);
			pre.next = node;
		}
		return newHead;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AddTwoNumbers ddd = new AddTwoNumbers();
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(8);
		ListNode n3 = new ListNode(5);
		n1.next = n2;
		// n2.next = n3;
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(5);
		n4.next = n5;
		n5.next = n6;
		ListNode no = ddd.addTwoNumbers(n1, n4);
		while (no != null) {
			System.out.println(no.val);
			no = no.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}