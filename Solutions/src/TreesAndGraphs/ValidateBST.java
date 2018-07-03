package TreesAndGraphs;

public class ValidateBST {

    public boolean minMax(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.value <= min || root.value > max) return false;
        return minMax(root.left, min, root.value) && minMax(root.right, root.value, max);
    }

    int index = 0;

    public void inorderSorting(TreeNode root, int[] array) {
        if (root == null) return;
        inorderSorting(root.left, array);
        array[index++] = root.value;
        inorderSorting(root.right, array);
    }

    public static void main(String[] args) {
        MinimalTree minimalTree = new MinimalTree();
        TreeNode root = minimalTree.constructTree(new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        }, 0, 12);
        ValidateBST validateBST = new ValidateBST();
        boolean isValid = validateBST.minMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(isValid);

        int[] a = new int[13];
        boolean res = true;
        validateBST.inorderSorting(root, a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] >= a[i + 1]) res = false;
        }
        System.out.println(res);
    }

}
