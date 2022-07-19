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
}
