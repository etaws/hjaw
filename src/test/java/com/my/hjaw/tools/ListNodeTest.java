package com.my.hjaw.tools;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class ListNodeTest {

    @Test
    public void testCreateList() {
        Integer[] vals = new Integer[]{3, 9, 20, null, null, 15, 7};

        ListNode head = ListNode.createList(vals);

        assertNotNull(head);

        Integer[] shows = ListNode.showList(head);

        assertNotNull(shows);

        Integer[] expect = new Integer[]{3, 9, 20, 15, 7};

        assertArrayEquals(shows, expect);
    }
}
