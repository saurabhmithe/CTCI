package TreesAndGraphs;

public class Successor {

    /*

    Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
    You may assume that each node has a link to its parent.

    */

    public TreeNode successor(TreeNode node) {
        if (node == null) return null;
        if (node.right != null) {
            TreeNode temp = node.right;
            while (temp.left != null) temp = temp.left;
            return temp;
        } else {
            TreeNode current = node;
            TreeNode parent = node.parent;
            while (parent != null && parent.left != current) {
                current = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public static void main(String[] args) {
        MinimalTree minimalTree = new MinimalTree();
        TreeNode root = minimalTree.constructTree(new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        }, 0, 12);
        Successor successor = new Successor();
        TreeNode successorNode = successor.successor(root);
        System.out.println(successorNode);
    }

}
