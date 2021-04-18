package com.eklavya.ds.tree;

import com.eklavya.ds.utils.TreePrinter;

public class SumOfLeaves {
    public static void main(String[] args) {

    }

//                1
//          2          3
//      4       5   6
    public static int SumOfLeftLeaves (Node root, Node parent){
        if(root==null) return 0;

        if(root.left == null && root.right == null
                && parent != null && parent.left == root){
            return root.data;
        }

        //6, 3
        int leftSide=SumOfLeftLeaves(root.left,root);
        //null, 5
        int rightSide=SumOfLeftLeaves(root.right,root);

        return leftSide+rightSide;
    }

    class Node implements TreePrinter.PrintableNode {
        public int data;
        public Node left;
        public Node right;

        @Override
        public TreePrinter.PrintableNode getLeft() {
            return left;
        }

        @Override
        public TreePrinter.PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return String.valueOf(data);
        }
    }
}
