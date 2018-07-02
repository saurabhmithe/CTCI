package TreesAndGraphs;

public class MinimalTree {

    /*

    Given a sorted (increasing order) array with unique integer elements,
    write an algorithm to create a binary search tree with minimal height.

    */

    public TreeNode constructTree(int[] a, int low, int high) {
        if (low > high) return null;
        int mid = (high + low) / 2;
        TreeNode newNode = new TreeNode(a[mid]);
        newNode.left = constructTree(a, low, mid - 1);
        newNode.right = constructTree(a, mid + 1, high);

        return newNode;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        MinimalTree minimalTree = new MinimalTree();
        TreeNode root = minimalTree.constructTree(a, 0, a.length - 1);
        minimalTree.print(root);
    }

    public void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.println(root.value);
            print(root.right);
        }
    }
}
