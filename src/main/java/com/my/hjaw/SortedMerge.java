package com.my.hjaw;

import com.my.hjaw.tools.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SortedMerge {

    public Integer[] mergeByList(Integer[] a, Integer[] b) {

        if ((a.length == 0) && (b.length == 0)) {
            return new Integer[0];
        }

        ListNode aList = ListNode.createList(a);
        ListNode bList = ListNode.createList(b);

        ListNode r = null;
        ListNode tail = null;

        while (aList != null && bList != null) {

            ListNode c;
            if (aList.val > bList.val) {
                c = bList;
                bList = bList.next;
            } else {
                c = aList;
                aList = aList.next;
            }

            if (r == null) {
                r = c;
            } else {
                tail.next = c;
            }
            tail = c;
        }

        ListNode c;
        if (aList != null) {
            c = aList;
        } else {
            c = bList;
        }

        while (c != null) {
            if (r == null) {
                r = c;
            } else {
                tail.next = c;
            }
            tail = c;

            c = c.next;
        }

        return ListNode.showList(r);
    }

    public void merge(int[] a, int[] b) {

        if ((a.length == 0) && (b.length == 0)) {
            return;
        }

        if (b.length == 0) {
            return;
        }

        assert a.length >= b.length;

        int i = a.length;
        for (; i > 0; i--) {
            if (a[i - 1] != 0) {
                int trueLength = a.length - i + 1;
                assert a.length == (b.length + trueLength);
                break;
            }
        }

        int k = a.length;
        int j = b.length;

        while ((j > 0) && (i > 0)) {
            if (b[j - 1] >= a[i - 1]) {
                a[--k] = b[--j];
            } else {
                a[--k] = a[--i];
            }
        }

        if (j > 0) {
            while (j > 0) {
                a[--k] = b[--j];
            }
        }

        if (i > 0) {
            while (i > 0) {
                a[--k] = a[--i];
            }
        }
    }

    public Integer[] distinctList(Integer[] a) {

        if (a.length == 0) {
            return new Integer[0];
        }

        if (a.length == 1) {
            return a;
        }

        ListNode aList = ListNode.createList(a);

        int v = -1;
        ListNode c = aList;

        ListNode head = null;
        ListNode tail = null;
        while (c != null) {
            if (c.val == v) {
                c = c.next;
                continue;
            }

            v = c.val;

            if (head == null) {
                head = c;
            } else {
                tail.next = c;
            }

            tail = c;
            c = c.next;
            tail.next = null;
        }

        return ListNode.showList(head);
    }

    public Integer[] reverseList(Integer[] a) {

        if (a.length == 0) {
            return new Integer[0];
        }

        if (a.length == 1) {
            return a;
        }

        ListNode c = ListNode.createList(a);

        ListNode head = null;
        while (c != null) {

            if (head == null) {
                head = c;
                c = c.next;
                head.next = null;
            } else {
                ListNode t = head;
                head = c;
                c = c.next;
                head.next = t;
            }
        }

        return ListNode.showList(head);
    }

    public Integer[] midList(Integer[] a) {

        if (a.length == 0) {
            return new Integer[0];
        }

        if (a.length == 1) {
            return a;
        }

        if (a.length == 2) {
            List<Integer> r = new ArrayList<>();
            r.add(a[1]);
            return r.toArray(r.toArray(new Integer[0]));
        }

        ListNode slow = ListNode.createList(a);
        ListNode fast = slow;

        while (fast.next != null) {
            slow = slow.next;

            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        slow.next = null;
        return ListNode.showList(slow);
    }
}
