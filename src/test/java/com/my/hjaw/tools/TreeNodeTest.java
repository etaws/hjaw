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

        Integer[] shows = TreeNode.showTree(root, vals.length);

        assertNotNull(shows);

        System.out.println("tree size: " + shows.length);
        for (Integer show : shows) {
            System.out.printf(" " + show);
        }

        assertArrayEquals(vals, shows);
    }

}