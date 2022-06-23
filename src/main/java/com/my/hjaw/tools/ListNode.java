package com.my.hjaw.tools;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

    public Integer val;
    public ListNode next;

    public ListNode(Integer x) {
        val = x;
        next = null;
    }

    public static ListNode createList(Integer[] vals) {

        if ((vals == null) || (vals.length == 0)) {
            return null;
        }

        ListNode head = null;
        ListNode tail = null;
        for (Integer v : vals) {
            if (v == null) {
                continue;
            }
            ListNode node = new ListNode(v);
            if (head == null) {
                head = node;
                tail = node;
                continue;
            }

            tail.next = node;
            tail = node;
        }

        return head;
    }

    public static Integer[] showList(ListNode head) {

        List<Integer> r = new ArrayList<>();

        ListNode c = head;
        while (c.next != null) {

            r.add(c.val);

            c = c.next;
        }

        r.add(c.val);

        return r.toArray(r.toArray(new Integer[0]));

    }
}
