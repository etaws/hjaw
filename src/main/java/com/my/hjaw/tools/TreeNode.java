package com.my.hjaw.tools;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {

    public Integer val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode createTree(Integer[] vals) {

        assert vals.length > 0;

        TreeNode[] ta = new TreeNode[vals.length];

        TreeNode root = new TreeNode(vals[0]);
        ta[0] = root;

        for (int i = 1; i < vals.length; ++i) {
            if (vals[i] != null) {
                ta[i] = new TreeNode(vals[i]);
                TreeNode pNode = ta[(i + 1) / 2 - 1];
                if (i % 2 == 0) {
                    pNode.right = ta[i];
                } else {
                    pNode.left = ta[i];
                }
            } else {
                ta[i] = null;
            }
        }

        return root;
    }

    public static Integer[] showTree(TreeNode root, int length) {

        assert root != null;

        LinkedList<TreeNode> queue = new LinkedList<>();

        ArrayList<Integer> ret = new ArrayList<>();

        queue.add(root);

        for (int i = 0; i < length; ++i) {
            if (queue.isEmpty()) {
                break;
            }

            TreeNode node = queue.removeFirst();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                ret.add(node.val);
            } else {
                ret.add(null);
            }
        }

        return ret.toArray(new Integer[0]);
    }
}
