package com.my.hjaw.tools;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class TreeNodeTest {

    @Test
    public void testCreateTree() {
        Integer[] vals = new Integer[]{3, 9, 20, null, null, 15, 7};

        TreeNode root = TreeNode.createTree(vals);

        assertNotNull(root);

        Integer[] shows = TreeNode.showTree(root);

        assertNotNull(shows);

        System.out.println("tree size: " + shows.length);
        for (Integer show : shows) {
            System.out.printf(" " + show);
        }

        assertArrayEquals(vals, shows);
    }

    @Test
    public void testShowTree() {
        Integer[] vals = new Integer[]{7, 9, 8, 5, 10, null, 12, 6, null, 13, null};

        TreeNode root = TreeNode.createTree(vals);

        assertNotNull(root);

        Integer[] shows = TreeNode.showTree(root);

        assertNotNull(shows);

        System.out.println("tree size: " + shows.length);
        for (Integer show : shows) {
            System.out.printf(" " + show);
        }


    }
}