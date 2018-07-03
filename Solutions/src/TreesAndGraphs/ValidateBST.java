package TreesAndGraphs;

public class ValidateBST {

    public boolean minMax(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.value <= min || root.value > max) return false;
        return minMax(root.left, min, root.value) && minMax(root.right, root.value, max);
    }

    public static void main(String[] args) {
        MinimalTree minimalTree = new MinimalTree();
        TreeNode root = minimalTree.constructTree(new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        }, 0, 12);
        ValidateBST validateBST = new ValidateBST();
        boolean isValid = validateBST.minMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(isValid);
    }
}
