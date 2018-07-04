package TreesAndGraphs;

public class CheckSubtree {

    /*

    4.10 Check Subtree
    T1 and T2 are two very large binary trees, with T1 much bigger than T2.
    Create an algorithm to determine if T2 is a subtree of T1.
    A tree T2 is a subtree of T1 if there exists a node n in Tl such that
    the subtree of n is identical to T2. That is, if you cut off the tree
    at node n, the two trees would be identical.

    */

    public boolean checkSubtree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        if (t1.value == t2.value && verify(t1, t2)) return true;
        return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
    }

    public boolean verify(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        else if (t1 == null || t2 == null) return false;
        else if (t1.value != t2.value) return false;
        else return verify(t1.left, t2.left) && verify(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode fifteen = new TreeNode(15);
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        TreeNode thirteen = new TreeNode(13);
        TreeNode seventeen = new TreeNode(17);

        t1.left = five;
        t1.right = fifteen;

        five.left = three;
        five.right = seven;

        fifteen.left = thirteen;
        fifteen.right = seventeen;

        TreeNode t2 = new TreeNode(15);
        t2.left = new TreeNode(13);
        t2.right = new TreeNode(17);

        if (t2 == null) {
            System.out.println(false);
            return;
        }

        CheckSubtree checkSubtree = new CheckSubtree();
        boolean isSubtree = checkSubtree.checkSubtree(t1, t2);
        System.out.println(isSubtree);
    }

}
