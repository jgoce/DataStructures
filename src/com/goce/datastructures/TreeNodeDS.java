package com.goce.datastructures;

import java.util.*;

public class TreeNodeDS {

    //[6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    TreeNode p = new TreeNode(7), q = new TreeNode(9), root = null;

    public static void main(String args[])
    {
        TreeNodeDS tree = new TreeNodeDS();

        Integer[] treeIntVal = {3,9,20,null,null,15,7}; //{6,2,8,0,4,7,9,null,null,3,5};
        Arrays.stream(treeIntVal)
                .forEach(v -> tree.insert(v));

        /*
            Let us create following BST
                      50
                   /     \
                  30      70
                 /  \    /  \
               20   40  60   80
                tree.insert(50);
                tree.insert(30);
                tree.insert(20);
                tree.insert(40);
                tree.insert(70);
                tree.insert(60);
                tree.insert(80);
         */

        System.out.println(tree.lowestCommonAncestor().val);
        System.out.println(String.format("maxDepth = %d ", tree.maxDepth()));

        List<List<Integer>> result = tree.bfsLevelOrder();

        for (List<Integer> outList : result){
            for(Integer value : outList){
                System.out.println(value + ",");
            }
        }
    }

    public TreeNode lowestCommonAncestor() {
        return lowestCommonAncestor(root,p,q);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p,q);
        else
            return root;
    }

    public int maxDepth(){
        return maxDepth(root);
    }

    private int maxDepth(TreeNode node){
        if(node == null)
            return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return Math.max(left, right) + 1;
    }

    public void insert(Integer treeValue){
        root = insertTreeNodes(root, treeValue);
    }

    private TreeNode insertTreeNodes(TreeNode root, Integer intTreeValue){

        if(intTreeValue == null)
            return root;

        if(root == null){
            root =  new TreeNode(intTreeValue);
            return root;
        }

        if (root.val > intTreeValue)
            root.left = insertTreeNodes(root.left, intTreeValue);
        else if (root.val < intTreeValue)
            root.right = insertTreeNodes(root.right, intTreeValue);

        return root;
    }

    public List<List<Integer>> bfsLevelOrder(){
        return bfsLevelOrder(root);
    }

    public List<List<Integer>> bfsLevelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return  result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode current = queue.remove();
                currentLevel.add(current.val);

                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
