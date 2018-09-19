package com.zkx.bbs.algorithm;

import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;

        n2.left = n4;

        n4.right = n6;

        n6.left = n7;
        n6.right = n8;

        n3.right = n5;

        pre(n1);
        System.out.println();
        mid(n1);
        System.out.println();
        aft(n1);
        System.out.println();
    }

    public static void pre(TreeNode n) {
//        if (n != null) {
//            System.out.print(n.val + ", ");
//            pre(n.left);
//            pre(n.right);
//        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = n;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.print(cur.val + ", ");
                stack.push(cur.right);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
            }
        }
    }

    public static void mid(TreeNode n) {
//        if (n != null) {
//            mid(n.left);
//            System.out.print(n.val + ", ");
//            mid(n.right);
//        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = n;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                System.out.print(cur.val + ", ");
                cur = cur.right;
            }
        }
    }

    public static void aft(TreeNode n) {
//        if (n != null) {
//            aft(n.left);
//            aft(n.right);
//            System.out.print(n.val + ", ");
//        }
        TreeNode cur = n;
        TreeNode lastVisit = n;

        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            System.out.println("cur:" + cur.val);
            if (cur.right == null || lastVisit == cur.right) {
                System.out.print(cur.val + ", ");
                lastVisit = cur;

                stack.pop();
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

}


