package com.my.hjaw;

import com.my.hjaw.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OnTree {

    public Integer[] mid(Integer[] vals) {

        TreeNode root = TreeNode.createTree(vals);

        List<TreeNode> stack = new LinkedList<>();

        ArrayList<Integer> ret = new ArrayList<>();

        TreeNode node = root;

        while (true) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            node = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);

            ret.add(node.val);

            node = node.right;
        }

        return ret.toArray(new Integer[0]);
    }

    public Integer[] pre(Integer[] vals) {

        TreeNode root = TreeNode.createTree(vals);

        List<TreeNode> stack = new LinkedList<>();

        ArrayList<Integer> ret = new ArrayList<>();

        TreeNode node = root;

        while (true) {
            while (node != null) {

                ret.add(node.val);

                stack.add(node);
                node = node.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            node = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);


            node = node.right;
        }

        return ret.toArray(new Integer[0]);
    }

    public Integer[] post(Integer[] vals) {

        TreeNode root = TreeNode.createTree(vals);

        List<TreeNode> stack = new LinkedList<>();

        ArrayList<Integer> ret = new ArrayList<>();

        TreeNode node = root;

        TreeNode pre = null;

        while (true) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            node = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);

            if ((node.right == null) || (node.right == pre)) {
                ret.add(node.val);
                pre = node;
                node = null;
            } else {
                pre = null;
                stack.add(node);
                node = node.right;
            }
        }

        return ret.toArray(new Integer[0]);
    }

    int height(Integer[] vals) {

        if (vals.length == 0) {
            return 0;
        }

        TreeNode root = TreeNode.createTree(vals);

        int height = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int expectSize = 1;
        int size = 0;
        int nextSize = 0;

        while (!queue.isEmpty()) {

            TreeNode node = queue.removeFirst();

            if (node.left != null) {
                queue.add(node.left);
                nextSize++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextSize++;
            }

            size++;

            if (size == expectSize) {
                height++;
                size = 0;
                expectSize = nextSize;
                nextSize = 0;
            }
        }

        return height;
    }
}
