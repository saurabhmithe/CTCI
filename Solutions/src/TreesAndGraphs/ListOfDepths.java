package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

    public void calculate(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.addLast(root);
        calculate(root.left, lists, level + 1);
        calculate(root.right, lists, level + 1);
    }

    public static void main(String[] args) {
        MinimalTree minimalTree = new MinimalTree();
        TreeNode root = minimalTree.constructTree(new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        }, 0, 12);
        ListOfDepths listOfDepths = new ListOfDepths();
        List<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        listOfDepths.calculate(root, lists, 0);

        for (LinkedList<TreeNode> list : lists) {
            for (TreeNode n : list) {
                System.out.print(n.value + " ");
            }
            System.out.println();
        }
    }
}
